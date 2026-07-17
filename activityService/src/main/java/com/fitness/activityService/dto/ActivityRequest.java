package com.fitness.activityService.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fitness.activityService.model.ActivityType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;


@Data
public class ActivityRequest {
    private String userId;
    private ActivityType type;
    private Integer duration;
    @JsonAlias("coloriesBurned")
    private Integer caloriesBurned;
    private LocalDateTime startTime;
    @JsonAlias("additionalMatrices")
    private Map<String, Object> additionalMetrics;

}
