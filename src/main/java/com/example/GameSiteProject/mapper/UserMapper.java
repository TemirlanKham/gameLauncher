package com.example.GameSiteProject.mapper;

import com.example.GameSiteProject.dtos.UserDto;
import com.example.GameSiteProject.models.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDto,User> {
    UserDto toDto(User entity);
  //  @Mapping(target = "roles", ignore = true)
    User toEntity(UserDto dto);
}
