package com.example.GameSiteProject.service;


import com.example.GameSiteProject.dtos.UserJwtPespons;
import com.example.GameSiteProject.dtos.UserJwtRequest;

public interface AuthService {
    UserJwtPespons login(final UserJwtRequest loginRequest);
}
