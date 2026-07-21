package com.fitness.aiserver.service;

import com.fitness.aiserver.controller.RecommendationController;
import com.fitness.aiserver.models.Recommendation;
import com.fitness.aiserver.repository.RecommendationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecommendationService {
    private final RecommendationRepository recommendationRepository;

    public  List<Recommendation> getUserRecommendation(String userId) {
        return recommendationRepository.findByUserId(userId);
    }

    public Recommendation getActivityRecommendation(String activityId) {
        return recommendationRepository.findByActivityId(activityId)
                .orElseThrow( () -> new RuntimeException("No recommendation found for this id:"+ activityId));
    }
}
