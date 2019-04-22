package org.monterinio.games.asteroids.gameobject.model;

import javafx.geometry.Point2D;

public abstract class GameObject {

    public Point2D velocity;
    private boolean alive;

    public GameObject() {
        this.velocity = new Point2D(0, 0);
        this.alive = true;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isDead() {
        return !alive;
    }

    public void setAlive() {
        this.alive = true;
    }

    public void setDead() {
        this.alive = false;
    }
}
