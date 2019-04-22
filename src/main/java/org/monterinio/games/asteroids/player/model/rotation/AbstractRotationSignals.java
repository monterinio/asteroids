package org.monterinio.games.asteroids.player.model.rotation;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public abstract class AbstractRotationSignals {

    final BooleanProperty clockwise = new SimpleBooleanProperty(false);
    final BooleanProperty antiClockwise = new SimpleBooleanProperty(false);

    public abstract double calculateAngle();

    public void onE() {
        this.clockwise.set(true);
    }

    public void onQ() {
        this.antiClockwise.set(true);
    }

    public void offE() {
        this.clockwise.set(false);
    }

    public void offQ() {
        this.antiClockwise.set(false);
    }
}
