package org.monterinio.games.asteroids.mechanics.entity;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Point2D;
import javafx.scene.Node;

public class Player extends GameObject {

    private String name;

    public final BooleanProperty left = new SimpleBooleanProperty(false);
    public final BooleanProperty right = new SimpleBooleanProperty(false);
    public final BooleanProperty up = new SimpleBooleanProperty(false);
    public final BooleanProperty down = new SimpleBooleanProperty(false);
    final BooleanBinding upleft = up.and(left);
    final BooleanBinding upright = up.and(right);
    final BooleanBinding downleft = down.and(left);
    final BooleanBinding downright = down.and(right);

    public Player(Node view, String name) {
        super(view);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }


    public void calculateVelocity() {
        if (left.get()) {
            this.velocity = new Point2D(-1, 0);
        }

        if (right.get()) {
            this.velocity = new Point2D(1, 0);
        }

        if (up.get()) {
            this.velocity = new Point2D(0, -1);
        }

        if (down.get()) {
            this.velocity = new Point2D(0, 1);
        }

        if (upleft.get()) {
            this.velocity = new Point2D(-1, -1);
        }

        if (upright.get()) {
            this.velocity = new Point2D(1, -1);
        }

        if (downleft.get()) {
            this.velocity = new Point2D(-1, 1);
        }

        if (downright.get()) {
            this.velocity = new Point2D(1, 1);
        }
    }
}
