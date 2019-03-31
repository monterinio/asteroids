package org.monterinio.games.asteroids.commands.movement.handler;

import com.airhacks.afterburner.injection.Injector;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.monterinio.games.asteroids.mechanics.entity.GameBoard;

public class BasicMovementStopHandler implements EventHandler<KeyEvent> {

    private GameBoard gameBoard = Injector.instantiateModelOrService(GameBoard.class);

    @Override
    public void handle(KeyEvent e) {

        var player = this.gameBoard //
                .getPlayerByName("dummy") //
                .orElseThrow(() -> new IllegalStateException("Player not found"));
        var signals = player.getMovementSignals();

        if (KeyCode.A == e.getCode()) {
            signals.offA();
        }

        if (KeyCode.D == e.getCode()) {
            signals.offD();
        }

        if (KeyCode.W == e.getCode()) {
            signals.offW();
        }

        if (KeyCode.S == e.getCode()) {
            signals.offS();
        }

        player.calculateVelocity();
    }
}
