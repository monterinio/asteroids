package org.monterinio.games.asteroids.internals.control;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import org.monterinio.games.asteroids.internals.entity.GameObject;

public class ObjectFactory {

    public static GameObject createPlayer() {
        return new GameObject(new Rectangle(40, 20, Color.AQUA));
    }

    public static GameObject createEnemy() {
        return new GameObject(new Circle(15, Color.RED));
    }

    public static GameObject createBullet() {
        return new GameObject(new Circle(5, Color.YELLOWGREEN));
    }

}
