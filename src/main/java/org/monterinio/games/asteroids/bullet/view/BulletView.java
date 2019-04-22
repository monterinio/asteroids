package org.monterinio.games.asteroids.bullet.view;

import javafx.scene.Node;
import org.monterinio.games.asteroids.bullet.model.Bullet;
import org.monterinio.games.asteroids.gameobject.view.GameObjectView;

public class BulletView extends GameObjectView {

    private Bullet bullet;

    public BulletView(Node view, Bullet bullet) {
        super(view);
        this.bullet = bullet;
    }

    @Override
    public Bullet getGameObject() {
        return bullet;
    }
}
