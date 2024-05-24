package com.example.GameSiteProject.service.impl;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import com.example.GameSiteProject.dtos.UserActionRequest;
import com.example.GameSiteProject.models.entity.Game;
import com.example.GameSiteProject.models.entity.User;
import com.example.GameSiteProject.models.entity.UserAction;
import com.example.GameSiteProject.models.enums.ActionType;
import com.example.GameSiteProject.repasitory.GameRepository;
import com.example.GameSiteProject.repasitory.UserActionRepository;
import com.example.GameSiteProject.repasitory.UserRepository;
import com.example.GameSiteProject.service.UserActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@Slf4j
public class UserActionServiceImpl implements UserActionService {
    private final UserActionRepository userActionRepository;
    private final UserRepository userRepository;
    private final GameRepository gameRepository;

    @Autowired
    public UserActionServiceImpl(UserActionRepository userActionRepository, UserRepository userRepository, GameRepository gameRepository) {
        this.userActionRepository = userActionRepository;
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
    }

    @Transactional
    public List<Game> getActionType(Long userId , ActionType actionType){
        log.info("Get action type for user id {} and action type {}", userId , actionType);
        List<Game> games = gameRepository.findAllGamesByUserIdAndActionType(userId ,actionType);
        log.info("games {} ", games.toString());
        return games;
    }


    @Transactional
    public void createAction(UserActionRequest userActionRequest){
        log.info("Create action for user id {} and action type {}" , userActionRequest.toString());
        User user = userRepository.findById(userActionRequest.getUserId()).orElse(null);
        Game game = gameRepository.findById(userActionRequest.getGameId()).orElseThrow(() -> new RuntimeException("Game not found"));
        UserAction userAction = new UserAction();
        userAction.setActionType(userActionRequest.getActionType());
        userAction.setUser(user);
        userAction.setGame(game);
        userActionRepository.save(userAction);
    }

}
