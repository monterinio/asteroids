package org.monterinio.games.asteroids.commands.rotation.handler;

import com.airhacks.afterburner.injection.Injector;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.monterinio.games.asteroids.mechanics.entity.GameBoard;

public class BasicRotationStopHandler implements EventHandler<KeyEvent> {

    private GameBoard gameBoard = Injector.instantiateModelOrService(GameBoard.class);

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
