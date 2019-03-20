package org.monterinio.games.asteroids.internals.entity;

import javafx.geometry.Point2D;
import javafx.scene.Node;

public class GameObject {

    private Node view;
    public Point2D velocity;
    public boolean alive;

    public GameObject(Node view) {
        this.view = view;
    }

    public Node getView() {
        return view;
    }

    public boolean isColliding(GameObject gameObject) {
        return this.view.getBoundsInParent().intersects(gameObject.view.getBoundsInParent());
    }
}
