package org.monterinio.games.asteroids.player.model.movement;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Point2D;

public abstract class AbstractMovementSignals {

    BooleanProperty left = new SimpleBooleanProperty(false);
    final BooleanProperty right = new SimpleBooleanProperty(false);
    final BooleanProperty up = new SimpleBooleanProperty(false);
    final BooleanProperty down = new SimpleBooleanProperty(false);

    public abstract Point2D calculateVelocity();

    public void onA() {
        this.left.set(true);
    }

    public void onD() {
        this.right.set(true);
    }

    public void onW() {
        this.up.set(true);
    }

    public void onS() {
        this.down.set(true);
    }

    public void offA() {
        this.left.set(false);
    }

    public void offD() {
        this.right.set(false);
    }

    public void offW() {
        this.up.set(false);
    }

    public void offS() {
        this.down.set(false);
    }
}
