package org.monterinio.games.asteroids.commands.action;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import org.monterinio.games.asteroids.mechanics.entity.Player;

public abstract class AbstractActionSignals {

    protected BooleanProperty shot = new SimpleBooleanProperty(false);
    protected BooleanProperty reverse = new SimpleBooleanProperty(false);

    public void onSpace() {
        this.shot.set(true);
    }

    public void onCtrl() {
        this.reverse.set(true);
    }

    public void offSpace() { this.shot.set(false); }

    public void offCtrl() { this.reverse.set(false); }

    public abstract double shoot(Player player);
}
