package org.monterinio.games.asteroids.internals.control;

import org.monterinio.games.asteroids.internals.entity.GameBoard;

import java.util.stream.Collectors;

import javax.inject.Inject;

public class GameService {

    @Inject
    private GameBoard gameBoard;

    public void checkForEvents() {
        gameBoard.bullets //
                .stream() //
                .flatMap(bullet -> gameBoard.enemies //
                        .stream() //
                        .filter(enemy -> bullet.isColliding(enemy))) //
                .collect(Collectors.toList()) //
                .forEach(object -> object.alive = false);
    }
}
