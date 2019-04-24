package org.monterinio.games.asteroids.player.model.action;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import org.monterinio.games.asteroids.player.model.Player;

public abstract class AbstractActionSignals {

    BooleanProperty shot = new SimpleBooleanProperty(false);
    BooleanProperty reverse = new SimpleBooleanProperty(false);

    public void onSpace() {
        this.shot.set(true);
    }

    public void onShift() {
        this.reverse.set(true);
    }

    public void offSpace() {
        this.shot.set(false);
    }

    public void offShift() {
        this.reverse.set(false);
    }

    public abstract double shoot(double currentAngle);
}
