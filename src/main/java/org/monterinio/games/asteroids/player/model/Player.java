package org.monterinio.games.asteroids.player.model;

import javafx.geometry.Point2D;
import org.monterinio.games.asteroids.bullet.model.Bullet;
import org.monterinio.games.asteroids.gameobject.model.GameObject;
import org.monterinio.games.asteroids.player.model.action.AbstractActionSignals;
import org.monterinio.games.asteroids.player.model.action.BasicActionSignals;
import org.monterinio.games.asteroids.player.model.movement.AbstractMovementSignals;
import org.monterinio.games.asteroids.player.model.movement.BasicMovementSignals;
import org.monterinio.games.asteroids.player.model.rotation.AbstractRotationSignals;
import org.monterinio.games.asteroids.player.model.rotation.BasicRotationSignals;

import java.util.ArrayList;
import java.util.List;

public class Player extends GameObject {

    private String name;
    private double angle;
    private List<Bullet> bullets;
    private AbstractMovementSignals movementSignals;
    private AbstractRotationSignals rotationSignals;
    private AbstractActionSignals actionSignals;

    public Player(String name) {
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
        Point2D vector = new Point2D(sin * 1, cos * 1).multiply(5);
        var bullet = new Bullet();
        bullet.velocity = vector;
        this.bullets.add(bullet);
    }

    public double getAngle() {
        return this.angle;
    }

    public List<Bullet> getBullets() {
        return bullets;
    }
}
