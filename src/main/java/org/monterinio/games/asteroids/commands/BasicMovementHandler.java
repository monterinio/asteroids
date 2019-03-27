package org.monterinio.games.asteroids.commands;

import com.airhacks.afterburner.injection.Injector;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.monterinio.games.asteroids.mechanics.entity.GameBoard;


public class BasicMovementHandler implements EventHandler<KeyEvent> {

    private GameBoard gameBoard = Injector.instantiateModelOrService(GameBoard.class);

    @Override
    public void handle(KeyEvent e) {

        var player = gameBoard //
                .getPlayerByName("dummy") //
                .orElseThrow(() -> new IllegalStateException("Player not found"));

        if (KeyCode.A == e.getCode()) {
            player.left.setValue(true);
        }

        if (KeyCode.D == e.getCode()) {
            player.right.setValue(true);
        }

        if (KeyCode.W == e.getCode()) {
            player.up.setValue(true);
        }

        if (KeyCode.S == e.getCode()) {
            player.down.setValue(true);
        }

        player.calculateVelocity();
    }
}
