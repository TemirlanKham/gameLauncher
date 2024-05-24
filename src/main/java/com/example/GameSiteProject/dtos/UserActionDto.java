package com.example.GameSiteProject.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.GameSiteProject.models.enums.ActionType;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserActionDto {
    private Long id;
    private Integer userId;
    private Integer bookId;
    private ActionType actionType;
}
