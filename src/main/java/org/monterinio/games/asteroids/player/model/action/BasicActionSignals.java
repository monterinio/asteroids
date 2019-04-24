package org.monterinio.games.asteroids.player.model.action;

import javafx.beans.binding.BooleanBinding;

public class BasicActionSignals extends AbstractActionSignals {

    private BooleanBinding reverseShot = shot.and(reverse);

    @Override
    public double shoot(double currentAngle) {
        if (reverseShot.get()) {
            return -currentAngle;
        } else if (shot.get()) {
            return -currentAngle - 180.0;
        } else {
            throw new UnsupportedOperationException("Unable to shoot in other direction than forwards or backwards");
        }
    }
}
