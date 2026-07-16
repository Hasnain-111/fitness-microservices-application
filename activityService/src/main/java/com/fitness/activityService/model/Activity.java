package com.fitness.activityService.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;

@Document("activities")
public class Activity {
    private String id;
    private String userId;
    private Integer coloriesBurned;
    private Integer duration;
    private ActivityType type;
    private LocalDateTime startTime;
    Map<String,Object> additionalMatrices;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
