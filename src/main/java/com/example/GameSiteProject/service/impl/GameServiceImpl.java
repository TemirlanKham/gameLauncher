package com.example.GameSiteProject.service.impl;

import lombok.RequiredArgsConstructor;
import com.example.GameSiteProject.dtos.GameSearchDto;
import com.example.GameSiteProject.models.entity.Game;
import com.example.GameSiteProject.repasitory.GameRepository;
import com.example.GameSiteProject.service.GameService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    @Override
    public Game getGameById(Long gameId) {
        return gameRepository.findById(gameId).orElseThrow();

    }

    @Override
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public void createGame(Game game) {
        gameRepository.save(game);
    }

    @Override
    @Transactional
    public void deleteGame(Long id) {
        if(id != null) {
            gameRepository.deleteGameAndActions(id);
        }else {
            gameRepository.deleteAll();
        }
    }


    @Override
    public List<Game> searchGamesByCriteria(GameSearchDto searchDto) {
        String author = searchDto.getAuthor();
        String title = searchDto.getTitle();
        String category = searchDto.getCategory();
        String year = searchDto.getYear();

        Specification<Game> specification = Specification.where(null);

        if (author != null && !author.isEmpty()) {
            specification = specification.and((root, query, builder) ->
                    builder.like(root.get("author"), "%" + author + "%"));
        }

        if (title != null && !title.isEmpty()) {
            specification = specification.and((root, query, builder) ->
                    builder.like(root.get("title"), "%" + title + "%"));
        }
        if (year != null && !year.describeConstable().isEmpty()) {
            specification = specification.and((root, query, builder) ->
                    builder.like(root.get("year"), "%" + year + "%"));
        }
        if (category != null && !category.isEmpty()) {
            specification = specification.and((root, query, builder) ->
                    builder.like(root.get("category"), "%" + category + "%"));
        }

        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "views"));
        Page<Game> resultPage = gameRepository.findAll(specification, pageable);
        return resultPage.getContent();
    }


    @Transactional(readOnly = true)
    public List<Game> getAllByCategory(String category){
        return  gameRepository.findAllByCategory(category);

    }

    @Override
    public void updateGame(Game game) {
        Long bookUpdatedId = game.getId();
        if(bookUpdatedId != null) {
            Game gameToUpdate = gameRepository.findById(game.getId()).orElseThrow();
            gameToUpdate.setName(game.getName());
            gameToUpdate.setDescription(game.getDescription());
            gameToUpdate.setAuthor(game.getAuthor());
            gameToUpdate.setCategory(game.getCategory());
            gameToUpdate.setYear(game.getYear());
            gameRepository.save(gameToUpdate);
        }
        else {
            new NullPointerException("Game id is null");
        }
    }


}
