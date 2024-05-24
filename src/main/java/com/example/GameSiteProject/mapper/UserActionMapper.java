package com.example.GameSiteProject.mapper;

import com.example.GameSiteProject.dtos.UserActionDto;
import com.example.GameSiteProject.models.entity.UserAction;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserActionMapper extends EntityMapper<UserActionDto,UserAction> {
    UserActionDto toDto(UserAction entity);
    UserAction toEntity(UserActionDto dto);
    List<UserAction> toEntity(List<UserActionDto> dtoList);
    List<UserActionDto> toDto(List<UserAction> entityList);
}
