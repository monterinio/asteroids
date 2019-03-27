package org.monterinio.games.asteroids.mechanics.control;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import org.monterinio.games.asteroids.mechanics.entity.GameObject;
import org.monterinio.games.asteroids.mechanics.entity.Player;

public class ObjectFactory {

    public static Player createPlayer() {
        return new Player(new Rectangle(40, 20, Color.AQUA), "dummy");
    }

    public static GameObject createEnemy() {
        return new GameObject(new Circle(15, Color.RED));
    }

    public static GameObject createBullet() {
        return new GameObject(new Circle(5, Color.YELLOWGREEN));
    }

}
