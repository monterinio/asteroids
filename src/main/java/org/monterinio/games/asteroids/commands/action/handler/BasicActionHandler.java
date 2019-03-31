package org.monterinio.games.asteroids.commands.action.handler;

import com.airhacks.afterburner.injection.Injector;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.monterinio.games.asteroids.mechanics.entity.GameBoard;


public class BasicActionHandler implements EventHandler<KeyEvent> {

    private GameBoard gameBoard = Injector.instantiateModelOrService(GameBoard.class);

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

        if (e.getCode() == KeyCode.CONTROL) {
            attackSignals.onCtrl();
        }

//        player.shoot();
    }
}
