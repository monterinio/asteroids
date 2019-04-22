package org.monterinio.games.asteroids.board.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import org.monterinio.games.asteroids.bullet.model.Bullet;
import org.monterinio.games.asteroids.bullet.view.BulletView;
import org.monterinio.games.asteroids.enemy.model.Enemy;
import org.monterinio.games.asteroids.enemy.view.EnemyView;
import org.monterinio.games.asteroids.player.model.Player;
import org.monterinio.games.asteroids.player.view.PlayerView;

public class ObjectFactory {

    public static PlayerView createPlayer() {
        return new PlayerView(new Rectangle(40, 20, Color.BLACK), new Player("dummy"));
    }

    public static EnemyView createEnemy() {
        return new EnemyView(new Circle(15, Color.RED), new Enemy());
    }

    public static BulletView createBullet(Bullet bullet) {
        return new BulletView(new Circle(5, Color.YELLOWGREEN), bullet);
    }
}
