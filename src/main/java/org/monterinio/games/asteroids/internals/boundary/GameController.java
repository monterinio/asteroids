package org.monterinio.games.asteroids.internals.boundary;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import org.monterinio.games.asteroids.internals.control.GameService;
import org.monterinio.games.asteroids.internals.entity.GameObject;

import javax.annotation.PostConstruct;

import javax.inject.Inject;

public class GameController extends AnimationTimer {

    @Inject
    private GameService gameService;

    @FXML
    private Pane pane;

    @PostConstruct
    public void initialize() {
        this.start();
    }

    @Override
    public void handle(long now) {
        gameService.checkForEvents();
        gameService.generateEnemy(pane);
    }

}
