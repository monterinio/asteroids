package org.monterinio.games.asteroids.mechanics.entity;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Point2D;
import javafx.scene.Node;

import java.util.List;

// TODO: probably better to turn it into abstract and declare subtypes
public class GameObject {

    private Node view;
    public Point2D velocity;
    public boolean alive;

    private final static Point2D LEFT = new Point2D(-1, 0);
    private final static Point2D RIGHT = new Point2D(1, 0);
    private final static Point2D UP = new Point2D(0, -1);
    private final static Point2D DOWN = new Point2D(0, 1);

    public GameObject(Node view) {
        this.view = view;
        this.velocity = new Point2D(0,0);
    }

    public Node getView() {
        return view;
    }

    public boolean isColliding(GameObject gameObject) {
        return this.view.getBoundsInParent().intersects(gameObject.view.getBoundsInParent());
    }

    public void updatePosition() {
        this.view.setTranslateX(this.view.getTranslateX() + this.velocity.getX());
        this.view.setTranslateY(this.view.getTranslateY() + this.velocity.getY());
    }

}
