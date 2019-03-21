package org.monterinio.games.asteroids.internals.entity;

import javafx.geometry.Point2D;
import javafx.scene.Node;

import java.util.List;

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

    public void registerObject(List<GameObject> gameObjects, double x, double y) {
        this.getView().setTranslateX(x);
        this.getView().setTranslateY(y);
        gameObjects.add(this);
    }

    public void registerPlayer(GameBoard gameBoard, double x, double y) {
        this.getView().setTranslateX(x);
        this.getView().setTranslateY(y);
        gameBoard.player = this;
    }
}
