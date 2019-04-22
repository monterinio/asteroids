package org.monterinio.games.asteroids.player.model.movement;

import static javafx.geometry.Point2D.ZERO;

import javafx.beans.binding.BooleanBinding;
import javafx.geometry.Point2D;

public class BasicMovementSignals extends AbstractMovementSignals {

    private final static Point2D LEFT = new Point2D(-1, 0);
    private final static Point2D RIGHT = new Point2D(1, 0);
    private final static Point2D UP = new Point2D(0, -1);
    private final static Point2D DOWN = new Point2D(0, 1);

    private final BooleanBinding upleft = up.and(left);
    private final BooleanBinding upright = up.and(right);
    private final BooleanBinding downleft = down.and(left);
    private final BooleanBinding downright = down.and(right);

    public Point2D calculateVelocity() {
        Point2D vel = null;

        if (left.get()) {
            vel = LEFT;
        }

        if (right.get()) {
            vel = RIGHT;
        }

        if (up.get()) {
            vel = UP;
        }

        if (down.get()) {
            vel = DOWN;
        }

        if (upleft.get()) {
            vel = UP.add(LEFT).normalize();
        }

        if (upright.get()) {
            vel = UP.add(RIGHT).normalize();
        }

        if (downleft.get()) {
            vel = DOWN.add(LEFT).normalize();
        }

        if (downright.get()) {
            vel = DOWN.add(RIGHT).normalize();
        }

        return vel != null ? vel : ZERO;
    }
}

