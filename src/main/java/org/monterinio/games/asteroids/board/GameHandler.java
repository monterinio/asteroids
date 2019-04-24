package org.monterinio.games.asteroids.board;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import org.monterinio.games.asteroids.board.controller.BoardController;

import javax.inject.Inject;

public class GameHandler extends AnimationTimer {

    @Inject
    private BoardController boardController;

    @FXML
    private Pane pane;

    @FXML
    void initialize() {
        boardController.setPane(pane);
        boardController.registerPlayer();
        this.start();
    }

    @Override
    public void handle(long now) {
        boardController.checkForCollision();

        if (Math.random() < 0.01) {
            boardController.registerEnemy();
        }

        boardController.updatePlayersPosition();
        boardController.limitPlayersMovement();
        boardController.displayBullets();
        boardController.updateBulletsPosition();
    }
}
