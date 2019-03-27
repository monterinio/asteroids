package org.monterinio.games.asteroids.mechanics.control;

import org.monterinio.games.asteroids.mechanics.entity.GameBoard;
import org.monterinio.games.asteroids.mechanics.entity.GameObject;
import org.monterinio.games.asteroids.mechanics.entity.Player;

import java.util.List;
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

    public GameBoard getBoard() {
        return gameBoard;
    }

    public void updatePlayerPosition() {
        this.gameBoard.players.forEach(player -> player.updatePosition());
    }
}
