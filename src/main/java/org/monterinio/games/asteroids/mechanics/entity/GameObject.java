package org.monterinio.games.asteroids.mechanics.entity;

import javafx.geometry.Point2D;
import javafx.scene.Node;

// TODO: probably better to turn it into abstract and declare subtypes
public class GameObject {

    private Node view;
    public Point2D velocity;
    public boolean alive;

    public GameObject(Node view) {
        this.view = view;
        this.velocity = new Point2D(0, 0);
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
