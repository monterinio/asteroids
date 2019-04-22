package org.monterinio.games.asteroids.player.model.rotation;

public class BasicRotationSignals extends AbstractRotationSignals {

    @Override
    public double calculateAngle() {
        double angle = 0.0;

        if (clockwise.get()) {
            angle = 45.0;
        }

        if (antiClockwise.get()) {
            angle = -45.0;
        }

        return angle;
    }
}
