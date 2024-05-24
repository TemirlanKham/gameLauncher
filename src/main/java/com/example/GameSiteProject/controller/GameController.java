package com.example.GameSiteProject.controller;

import com.example.GameSiteProject.dtos.GameSearchDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.GameSiteProject.dtos.GameDto;
import com.example.GameSiteProject.mapper.GameMapper;
import com.example.GameSiteProject.models.entity.Game;
import com.example.GameSiteProject.models.enums.ActionType;
import com.example.GameSiteProject.service.GameService;
import com.example.GameSiteProject.service.UserActionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;
    private final GameMapper gameMapper;
    private final UserActionService userActionService;

    @GetMapping("/get/{id}")
    @Operation(summary = "get Game")
    public GameDto getGame(@PathVariable Long id) {
        Game game = gameService.getGameById(id);
        return gameMapper.toDto(game);
    }

    @PostMapping("/create")
    @Operation(summary = "Create game")
    public void createGame(@Valid @RequestBody GameDto gameDto) {
        Game game = gameMapper.toEntity(gameDto);
        gameService.createGame(game);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete")
    public void deleteGame(@PathVariable Long id) {
        log.info(" id {}", id);
        gameService.deleteGame(id);
    }

    @GetMapping("/games")
    @Operation(summary = "Get all Game")
    public List<GameDto> getAllGames() {
        return gameMapper.toDto(gameService.getAllGames());
    }

    @GetMapping("/search")
    @Operation(summary = "search Game")
    public List<GameDto> searchGames(@RequestBody GameSearchDto searchDto) {
        List<Game> filteredBooks = gameService.searchGamesByCriteria(searchDto);
        return filteredBooks.stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/games/category/{category}")
    @Operation(summary = "search Cate")
    public List<GameDto> getAllByCategory(@PathVariable  String category) {
        var findAllCategory = gameService.getAllByCategory(category);
        List<GameDto> gameDtos = (List<GameDto>) gameMapper.toDto(findAllCategory);
        return gameDtos;
    }

    @GetMapping("/games/likes")
    public List<GameDto> getActionLikeBooks(@RequestParam Long userId, @RequestParam ActionType actionType) {
        List<Game> game = (List<Game>) userActionService.getActionType(userId, actionType);
        return gameMapper.toDto(game);
    }

    @PutMapping("/update")
    public void updateGame(@Valid @RequestBody GameDto gameDto) {
        gameService.updateGame(gameMapper.toEntity(gameDto));
    }
}
