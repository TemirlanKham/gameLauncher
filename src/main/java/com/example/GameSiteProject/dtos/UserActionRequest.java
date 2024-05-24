package com.example.GameSiteProject.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.GameSiteProject.models.enums.ActionType;

@Data
@NoArgsConstructor
public class UserActionRequest {
    private Long userId;
    private Long gameId;
    private ActionType actionType;
}
