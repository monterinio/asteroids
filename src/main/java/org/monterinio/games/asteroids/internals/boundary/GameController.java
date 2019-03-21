package org.monterinio.games.asteroids.internals.boundary;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import org.monterinio.games.asteroids.internals.control.GameService;
import org.monterinio.games.asteroids.internals.control.ObjectFactory;
import org.monterinio.games.asteroids.internals.entity.GameBoard;

import javax.inject.Inject;

public class GameController extends AnimationTimer {

    @Inject
    private GameService gameService;

    @Inject
    private GameBoard gameBoard;

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
    }

    void displayEnemy() {
        if (Math.random() < 0.01) {
            var enemy = ObjectFactory.createEnemy();
            enemy.registerObject(gameBoard.enemies, pane.getPrefWidth() * Math.random(),
                    pane.getPrefHeight() * Math.random());
            pane.getChildren().add(enemy.getView());
        }
    }

    void displayPlayer() {
        var player = ObjectFactory.createPlayer();
        player.registerPlayer(gameBoard, pane.getPrefWidth() * 0.5, pane.getPrefHeight() * 0.5);
        pane.getChildren().add(player.getView());
    }

}
