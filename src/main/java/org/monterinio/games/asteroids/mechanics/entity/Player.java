package org.monterinio.games.asteroids.mechanics.entity;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import org.monterinio.games.asteroids.commands.action.AbstractActionSignals;
import org.monterinio.games.asteroids.commands.action.BasicActionSignals;
import org.monterinio.games.asteroids.commands.movement.AbstractMovementSignals;
import org.monterinio.games.asteroids.commands.movement.BasicMovementSignals;
import org.monterinio.games.asteroids.commands.rotation.AbstractRotationSignals;
import org.monterinio.games.asteroids.commands.rotation.BasicRotationSignals;
import org.monterinio.games.asteroids.mechanics.control.ObjectFactory;

import java.util.ArrayList;
import java.util.List;

public class Player extends GameObject {

    private String name;
    private double angle;
    private List<GameObject> bullets;
    private AbstractMovementSignals movementSignals;
    private AbstractRotationSignals rotationSignals;
    private AbstractActionSignals actionSignals;

    public Player(Node view, String name) {
        super(view);
        this.name = name;
        this.movementSignals = new BasicMovementSignals();
        this.rotationSignals = new BasicRotationSignals();
        this.actionSignals = new BasicActionSignals();
        this.bullets = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public AbstractMovementSignals getMovementSignals() {
        return movementSignals;
    }

    public AbstractRotationSignals getRotationSignals() {
        return rotationSignals;
    }

    public AbstractActionSignals getAttackSignals() {
        return actionSignals;
    }

    public void calculateVelocity() {
        this.velocity = movementSignals.calculateVelocity();
    }

    public void calculateAngle() {
        this.angle = rotationSignals.calculateAngle();
    }

    public void shoot() {
        double angle = actionSignals.shoot(this);
        double rad = Math.toRadians(angle);
        var sin = Math.sin(rad);
        var cos = Math.cos(rad);
        var bullet = ObjectFactory.createBullet();
        Point2D vector = new Point2D(sin * 1, cos * 1).multiply(5);
        bullet.velocity = vector;
        this.bullets.add(bullet);
    }

    public double getAngle() {
        return this.angle;
    }

    public List<GameObject> getBullets() {
        return bullets;
    }

    // TODO: I don't like this method being in Player
    public void updateAngle() {
        this.getView().setRotate(this.angle);
    }
}
