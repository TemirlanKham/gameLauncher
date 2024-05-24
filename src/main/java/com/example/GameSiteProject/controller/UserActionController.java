package com.example.GameSiteProject.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import com.example.GameSiteProject.dtos.UserActionRequest;
import com.example.GameSiteProject.models.entity.UserAction;
import com.example.GameSiteProject.models.enums.ActionType;
import com.example.GameSiteProject.service.UserActionService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v4/action")
@RequiredArgsConstructor
public class UserActionController {
    private final UserActionService userActionService;

    @PostMapping("/create")
    @Operation(summary = "createAction")
    public void createAction(@RequestBody UserActionRequest userActionRequest) {
        userActionService.createAction(userActionRequest);
    }

}
