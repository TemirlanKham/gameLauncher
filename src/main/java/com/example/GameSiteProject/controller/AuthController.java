package com.example.GameSiteProject.controller;


import com.example.GameSiteProject.dtos.UserJwtPespons;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.GameSiteProject.service.AuthService;
import com.example.GameSiteProject.service.UserService;
import com.example.GameSiteProject.mapper.UserMapper;
import com.example.GameSiteProject.dtos.UserJwtRequest;
import com.example.GameSiteProject.dtos.UserDto;
import com.example.GameSiteProject.models.entity.User;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/login")
    @Operation(summary = "Login In")
    public UserJwtPespons login(@Validated
                             @RequestBody final UserJwtRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    @Operation(summary = "Register In")
    public UserDto register(@RequestBody final UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User createdUser = userService.create(user);
        return userMapper.toDto(createdUser);
    }
}