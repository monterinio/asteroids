package org.monterinio.games.asteroids.player.controller.action;

import com.airhacks.afterburner.injection.Injector;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.monterinio.games.asteroids.board.controller.BoardController;

public class BasicActionHandler implements EventHandler<KeyEvent> {

    private BoardController gameBoard = Injector.instantiateModelOrService(BoardController.class);

    @Override
    public void handle(KeyEvent e) {
        var player = gameBoard //
                .getPlayerByName("dummy") //
                .orElseThrow((() -> new IllegalStateException("Player not found")));
        var attackSignals = player.getAttackSignals();

        if (e.getCode() == KeyCode.SPACE) {
            attackSignals.onSpace();
            player.shoot();
        }

        if (e.getCode() == KeyCode.SHIFT) {
            attackSignals.onShift();
        }
    }
}
