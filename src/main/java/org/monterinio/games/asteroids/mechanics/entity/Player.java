package org.monterinio.games.asteroids.mechanics.entity;

import javafx.scene.Node;
import org.monterinio.games.asteroids.commands.movement.AbstractMovementSignals;
import org.monterinio.games.asteroids.commands.movement.BasicMovementSignals;
import org.monterinio.games.asteroids.commands.rotation.AbstractRotationSignals;
import org.monterinio.games.asteroids.commands.rotation.BasicRotationSignals;

public class Player extends GameObject {

    private String name;
    private double angle;
    private AbstractMovementSignals movementSignals;
    private AbstractRotationSignals rotationSignals;

    public Player(Node view, String name) {
        super(view);
        this.name = name;
        this.movementSignals = new BasicMovementSignals();
        this.rotationSignals = new BasicRotationSignals();
    }

    public String getName() {
        return this.name;
    }

    public AbstractMovementSignals getMovementSignals() {
        return movementSignals;
    }

    public AbstractRotationSignals getRotationSignals() { return rotationSignals; }

    public void calculateVelocity() {
        this.velocity = movementSignals.calculateVelocity();
    }

    public void calculateAngle() {
        this.angle = rotationSignals.calculateAngle();
    }

    // TODO: I don't like this method being in Player
    public void updateAngle() {
        this.getView().setRotate(this.angle);
    }
}
