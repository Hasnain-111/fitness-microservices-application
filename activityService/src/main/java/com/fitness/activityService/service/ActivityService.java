package com.fitness.activityService.service;

import com.fitness.activityService.ActivityRepository;
import com.fitness.activityService.dto.ActivityRequest;
import com.fitness.activityService.dto.ActivityResponse;
import com.fitness.activityService.model.Activity;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service

@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRepository activityRepository;
    public ActivityResponse trackActivity(ActivityRequest request) {
        Activity activity = Activity.builder().
                userId(request.getUserId()).
                type(request.getType()).
                duration(request.getDuration()).
                coloriesBurned(request.getColoriesBurned()).
                startTime(request.getStartTime()).
                additionalMatrices(request.getAdditionalMatrices()).build();

        Activity savedActivity = activityRepository.save(activity);

        ActivityResponse activityResponse = new ActivityResponse();
        activityResponse.setId(savedActivity.getId());
        activityResponse.setUserId(savedActivity.getUserId());
        activityResponse.setDuration(savedActivity.getDuration());
        activityResponse.setType(savedActivity.getType());
        activityResponse.setCaloriesBurned(savedActivity.getColoriesBurned());
        activityResponse.setAdditionalMatrices(savedActivity.getAdditionalMatrices());
        activityResponse.setCreatedAt(savedActivity.getCreatedAt());
        activityResponse.setStartTime(savedActivity.getStartTime());
        activityResponse.setUpdatedAt(savedActivity.getUpdatedAt());
        return  activityResponse;
    }
}
