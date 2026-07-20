package com.fitness.activityService.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;

@Service
@AllArgsConstructor
public class ValidateUserService {

    private final WebClient.Builder webClientBuilder;

    public boolean validateUser(String userId) {
        try {
            return webClientBuilder.build()
                    .get()
                    .uri("http://USERSERVICE/api/users/{userId}/validate", userId)
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block();
        } catch (WebClientException e) {
            e.printStackTrace();
            return false;
        }
    }
}