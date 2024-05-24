package com.example.GameSiteProject.service;

import com.example.GameSiteProject.dtos.GameSearchDto;
import com.example.GameSiteProject.models.entity.Game;


import java.util.List;

public interface GameService {
    Game getGameById(Long gameId);
    List<Game> getAllGames();
    void createGame(Game game);
    void deleteGame(Long id);
    List<Game> searchGamesByCriteria(GameSearchDto searchDto);
    List<Game> getAllByCategory(String category);
    void  updateGame(Game game);
}
