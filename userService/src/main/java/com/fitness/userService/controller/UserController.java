package com.fitness.userService.controller;

import com.fitness.userService.dto.ResgisterRequest;
import com.fitness.userService.dto.UserResponse;
import com.fitness.userService.services.UserServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {
    private UserServices userServices;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody ResgisterRequest request){
        return ResponseEntity.ok(userServices.register(request));
    }
}
