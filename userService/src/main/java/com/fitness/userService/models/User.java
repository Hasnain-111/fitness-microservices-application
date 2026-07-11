package com.fitness.userService.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private UserRole role =UserRole.USER;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
