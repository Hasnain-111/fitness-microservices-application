package com.fitness.aiserver.repository;

import com.fitness.aiserver.models.Recommendation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface RecommendationRepository extends MongoRepository <Recommendation,String>{
    List<Recommendation> findByUserId(String userId);

    Optional<Recommendation> findByActivityId(String activityId);
}
