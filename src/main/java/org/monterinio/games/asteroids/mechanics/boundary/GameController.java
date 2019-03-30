package org.monterinio.games.asteroids.mechanics.boundary;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import org.monterinio.games.asteroids.mechanics.control.GameService;
import org.monterinio.games.asteroids.mechanics.control.ObjectFactory;

import javax.inject.Inject;

public class GameController extends AnimationTimer {

    @Inject
    private GameService gameService;

    @FXML
    private Pane pane;

    @FXML
    void initialize() {
        displayPlayer();
        this.start();
    }

    @Override
    public void handle(long now) {
        gameService.checkForEvents();
        displayEnemy();
        gameService.updatePlayerPosition();
    }

    void displayEnemy() {
        if (Math.random() < 0.01) {
            var enemy = ObjectFactory.createEnemy();
            gameService.getBoard()
                    .registerEnemy(enemy, pane.getPrefWidth() * Math.random(), pane.getPrefHeight() * Math.random());
            pane.getChildren().add(enemy.getView());
        }
    }

    void displayPlayer() {
        var player = ObjectFactory.createPlayer();
        gameService.getBoard().registerPlayer(player, pane.getPrefWidth() * 0.5, pane.getPrefHeight() * 0.5);
        pane.getChildren().add(player.getView());
    }

}
