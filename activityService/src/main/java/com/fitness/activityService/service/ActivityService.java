package com.fitness.activityService.service;

import com.fitness.activityService.ActivityRepository;
import com.fitness.activityService.dto.ActivityRequest;
import com.fitness.activityService.dto.ActivityResponse;
import com.fitness.activityService.model.Activity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service

@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final ValidateUserService validateUserService;
    private final KafkaTemplate<String,Activity> kafkaTemplate;

    @Value("${kafka.topic.name}")
    private String topicName;
    public ActivityResponse trackActivity(ActivityRequest request) {
        boolean isValidUser = validateUserService.validateUser(request.getUserId());

        if(!isValidUser){
            throw new RuntimeException("Invalid user:" + request.getUserId());
        }
        Activity activity = Activity.builder().
                userId(request.getUserId()).
                type(request.getType()).
                duration(request.getDuration()).
                caloriesBurned(request.getCaloriesBurned()).
                startTime(request.getStartTime()).
                additionalMetrics(request.getAdditionalMetrics()).build();

        Activity savedActivity = activityRepository.save(activity);
        try{
            kafkaTemplate.send(topicName,savedActivity.getUserId(),savedActivity);
        }catch (Exception e){
            e.printStackTrace();
        }
         activity = Activity.builder()
                .id(UUID.randomUUID().toString())
                .userId(request.getUserId())
                .type(request.getType())
                .duration(request.getDuration())
                .caloriesBurned(request.getCaloriesBurned())
                .startTime(request.getStartTime())
                .additionalMetrics(request.getAdditionalMetrics())
                .build();


        System.out.println("Saved Activity:");
        System.out.println(savedActivity);

        System.out.println("All Activities:");
        System.out.println(activityRepository.findAll());

        ActivityResponse activityResponse = new ActivityResponse();
        activityResponse.setId(savedActivity.getId());
        activityResponse.setUserId(savedActivity.getUserId());
        activityResponse.setDuration(savedActivity.getDuration());
        activityResponse.setType(savedActivity.getType());
        activityResponse.setCaloriesBurned(savedActivity.getCaloriesBurned());
        activityResponse.setAdditionalMetrics(savedActivity.getAdditionalMetrics());
        activityResponse.setCreatedAt(savedActivity.getCreatedAt());
        activityResponse.setStartTime(savedActivity.getStartTime());
        activityResponse.setUpdatedAt(savedActivity.getUpdatedAt());
        return  activityResponse;
    }
}
