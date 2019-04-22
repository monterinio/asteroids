package org.monterinio.games.asteroids.gameobject.view;

import javafx.scene.Node;
import org.monterinio.games.asteroids.gameobject.model.GameObject;

public abstract class GameObjectView {

    protected Node view;

    public GameObjectView(Node view) {
        this.view = view;
    }

    public Node getView() {
        return view;
    }

    public boolean isColliding(GameObjectView gameObjectView) {
        return this.view.getBoundsInParent().intersects(gameObjectView.view.getBoundsInParent());
    }

    public void updatePosition() {
        this.view.setTranslateX(this.view.getTranslateX() + getGameObject().velocity.getX());
        this.view.setTranslateY(this.view.getTranslateY() + getGameObject().velocity.getY());
    }

    public void registerPosition(double x, double y) {
        this.view.setTranslateX(x);
        this.view.setTranslateY(y);
    }

    public abstract GameObject getGameObject();
}
