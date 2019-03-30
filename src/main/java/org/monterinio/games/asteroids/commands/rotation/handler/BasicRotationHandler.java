package org.monterinio.games.asteroids.commands.rotation.handler;

import com.airhacks.afterburner.injection.Injector;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.monterinio.games.asteroids.mechanics.entity.GameBoard;

public class BasicRotationHandler implements EventHandler<KeyEvent> {

    private GameBoard gameBoard = Injector.instantiateModelOrService(GameBoard.class);

    @Override
    public void handle(KeyEvent e) {

        var player = gameBoard //
                .getPlayerByName("dummy") //
                .orElseThrow(() -> new IllegalStateException("Player not found"));
        var rotationSignals = player.getRotationSignals();

        if (KeyCode.E == e.getCode()) {
            rotationSignals.onE();
        }

        if (KeyCode.Q == e.getCode()) {
            rotationSignals.onQ();
        }

        player.calculateAngle();
    }
}