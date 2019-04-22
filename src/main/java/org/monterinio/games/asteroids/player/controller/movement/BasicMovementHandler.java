package org.monterinio.games.asteroids.player.controller.movement;

import com.airhacks.afterburner.injection.Injector;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.monterinio.games.asteroids.board.controller.BoardController;

public class BasicMovementHandler implements EventHandler<KeyEvent> {

    private BoardController gameBoard = Injector.instantiateModelOrService(BoardController.class);

    @Override
    public void handle(KeyEvent e) {

        var player = gameBoard //
                .getPlayerByName("dummy") //
                .orElseThrow(() -> new IllegalStateException("Player not found"));
        var movementSignals = player.getMovementSignals();

        if (KeyCode.A == e.getCode()) {
            movementSignals.onA();
        }

        if (KeyCode.D == e.getCode()) {
            movementSignals.onD();
        }

        if (KeyCode.W == e.getCode()) {
            movementSignals.onW();
        }

        if (KeyCode.S == e.getCode()) {
            movementSignals.onS();
        }

        player.calculateVelocity();
    }
}
