package com.example.GameSiteProject.service;

import com.example.GameSiteProject.models.entity.Game;
import com.example.GameSiteProject.dtos.UserActionRequest;
import com.example.GameSiteProject.models.entity.UserAction;
import com.example.GameSiteProject.models.enums.ActionType;

import java.util.List;

public interface UserActionService {
    void createAction(UserActionRequest userActionRequest);
    List<Game> getActionType(Long userId , ActionType actionType);
}
