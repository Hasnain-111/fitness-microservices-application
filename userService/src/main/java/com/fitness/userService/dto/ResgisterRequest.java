package com.fitness.userService.dto;

import lombok.Data;

@Data
public class ResgisterRequest {
    private String email;
    private String password;
    private String firstName;
    private String LastName;
}
