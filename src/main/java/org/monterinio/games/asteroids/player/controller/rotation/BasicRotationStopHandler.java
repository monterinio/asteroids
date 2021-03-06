package org.monterinio.games.asteroids.player.controller.rotation;

import com.airhacks.afterburner.injection.Injector;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.monterinio.games.asteroids.board.controller.BoardController;

public class BasicRotationStopHandler implements EventHandler<KeyEvent> {

    private BoardController gameBoard = Injector.instantiateModelOrService(BoardController.class);

    @Override
    public void handle(KeyEvent e) {

        var player = this.gameBoard //
                .getPlayerByName("dummy") //
                .orElseThrow(() -> new IllegalStateException("Player not found"));
        var signals = player.getRotationSignals();

        if (KeyCode.E == e.getCode()) {
            signals.offE();
        }

        if (KeyCode.Q == e.getCode()) {
            signals.offQ();
        }

        player.calculateAngle();
    }
}
