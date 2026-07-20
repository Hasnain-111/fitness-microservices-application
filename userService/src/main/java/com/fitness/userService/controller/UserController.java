package com.fitness.userService.controller;

import com.fitness.userService.dto.ResgisterRequest;
import com.fitness.userService.dto.UserResponse;
import com.fitness.userService.services.UserServices;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {
    private final UserServices userServices;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserProfile(@PathVariable String userId){
        return ResponseEntity.ok(userServices.getUserProfile(userId));
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody ResgisterRequest request){
        return ResponseEntity.ok(userServices.register(request));
    }

    @GetMapping("{userId}/validate")
    public ResponseEntity<Boolean> validateUser(@PathVariable String userId){
        return ResponseEntity.ok(userServices.existByUserId(userId));
    }
}
