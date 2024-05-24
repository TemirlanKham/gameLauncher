package com.example.GameSiteProject.repasitory;

import com.example.GameSiteProject.models.entity.Game;
import jakarta.transaction.Transactional;
import com.example.GameSiteProject.models.enums.ActionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    Page<Game> findAll(Specification<Game> specification, Pageable pageable);

    List<Game> findAllByCategory(String category);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM UserAction ua WHERE ua.game.id = :id")
    void deleteGameActions(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Game b WHERE b.id = :id")
    void deleteGame(@Param("id") Long id);


    default void deleteGameAndActions(Long id) {
        deleteGameActions(id);
        deleteGame(id);
    }

    @Transactional
    @Modifying
    @Query(value = "SELECT DISTINCT b FROM Game b JOIN UserAction ua ON b.id = ua.game.id " +
            "WHERE ua.user.id = :userId AND ua.actionType = :actionType")
    List<Game> findAllGamesByUserIdAndActionType(@Param("userId") Long userId, @Param("actionType") ActionType actionType);

}