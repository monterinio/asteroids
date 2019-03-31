package org.monterinio.games.asteroids.mechanics.control;

import javafx.scene.Node;
import org.monterinio.games.asteroids.mechanics.entity.GameBoard;
import org.monterinio.games.asteroids.mechanics.entity.GameObject;
import org.monterinio.games.asteroids.mechanics.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

public class GameService {

    @Inject
    private GameBoard gameBoard;

    public List<Node> checkForCollision() {
        List<Node> objects = new ArrayList<>();
        for(var bul : gameBoard.bullets) {
            for (var en: gameBoard.enemies) {
                if(bul.isColliding(en)) {
                    bul.alive = false;
                    en.alive = false;
                    objects.add(bul.getView());
                    objects.add(en.getView());
                }
            }
        }

        gameBoard.bullets.removeIf(bullet -> !bullet.alive);
        gameBoard.enemies.removeIf(enemy -> !enemy.alive);

        return objects;
    }

    public GameBoard getBoard() {
        return gameBoard;
    }

    public void updatePlayersPosition() {
        this.gameBoard.players.forEach(player -> player.updatePosition());
        this.gameBoard.players.forEach(player -> player.updateAngle());
    }

    public void updateBulletsPosition() {
        this.gameBoard.bullets.forEach(bullet -> bullet.updatePosition());
    }
}
