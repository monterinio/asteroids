package org.monterinio.games.asteroids.commands.action;

import javafx.beans.binding.BooleanBinding;
import org.monterinio.games.asteroids.mechanics.entity.Player;

public class BasicActionSignals extends AbstractActionSignals {

    private BooleanBinding reverseShot = shot.and(reverse);

    @Override
    public double shoot(Player player) {
        if (reverseShot.get()) {
            return -player.getAngle();
        } else if (shot.get()) {
            return -player.getAngle() - 180.0;
        } else {
            return 0.0;
        }
    }
}
