package com.example.GameSiteProject.service.impl;

import lombok.RequiredArgsConstructor;
import com.example.GameSiteProject.dtos.UserJwtPespons;
import com.example.GameSiteProject.dtos.UserJwtRequest;
import com.example.GameSiteProject.models.entity.User;
import com.example.GameSiteProject.security.JwtTokenProvider;
import com.example.GameSiteProject.service.AuthService;
import com.example.GameSiteProject.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public UserJwtPespons login(final UserJwtRequest loginRequest) {
        UserJwtPespons jwtResponse = new UserJwtPespons();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(), loginRequest.getPassword())
        );
        User user = userService.getByUsername(loginRequest.getUsername());
        jwtResponse.setId(user.getId());
        jwtResponse.setUsername(user.getUsername());
        jwtResponse.setAccessToken("Breare " + jwtTokenProvider.createAccessToken(
                user.getId(), user.getUsername(), user.getRoles())
        );
        jwtResponse.setRefreshToken(jwtTokenProvider.createAccessToken(
                user.getId(), user.getUsername(), user.getRoles())
        );
        return jwtResponse;
    }


}
