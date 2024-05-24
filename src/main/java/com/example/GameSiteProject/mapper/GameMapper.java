package com.example.GameSiteProject.mapper;

import com.example.GameSiteProject.dtos.GameDto;
import com.example.GameSiteProject.models.entity.Game;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GameMapper extends EntityMapper<GameDto, Game>{
    GameDto toDto(Game entity);
    Game toEntity(GameDto dto);
    List<Game> toEntity(List<GameDto> dtoList);
    List<GameDto> toDto(List<Game> entityList);
}