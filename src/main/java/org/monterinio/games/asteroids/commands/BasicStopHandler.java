package org.monterinio.games.asteroids.commands;

import static javafx.scene.input.KeyCode.A;
import static javafx.scene.input.KeyCode.D;
import static javafx.scene.input.KeyCode.S;
import static javafx.scene.input.KeyCode.W;

import com.airhacks.afterburner.injection.Injector;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.monterinio.games.asteroids.mechanics.entity.GameBoard;

public class BasicStopHandler implements EventHandler<KeyEvent> {

    private GameBoard gameBoard = Injector.instantiateModelOrService(GameBoard.class);

    @Override
    public void handle(KeyEvent e) {

        var player = this.gameBoard //
                .getPlayerByName("dummy") //
                .orElseThrow(() -> new IllegalStateException("Player not found"));

        if (KeyCode.A == e.getCode()) {
            player.left.setValue(false);
            player.velocity = player.velocity.subtract(new Point2D(-1, 0));
        }

        if (KeyCode.D == e.getCode()) {
            player.right.setValue(false);
            player.velocity = player.velocity.subtract(new Point2D(1, 0));
        }

        if (KeyCode.W == e.getCode()) {
            player.up.setValue(false);
            player.velocity = player.velocity.subtract(new Point2D(0, -1));
        }

        if (KeyCode.S == e.getCode()) {
            player.down.setValue(false);
            player.velocity = player.velocity.subtract(new Point2D(0, 1));
        }

        player.calculateVelocity();
    }
}
