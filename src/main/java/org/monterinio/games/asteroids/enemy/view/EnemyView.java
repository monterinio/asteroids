package org.monterinio.games.asteroids.enemy.view;

import javafx.scene.Node;
import org.monterinio.games.asteroids.enemy.model.Enemy;
import org.monterinio.games.asteroids.gameobject.view.GameObjectView;

public class EnemyView extends GameObjectView {

    private Enemy enemy;

    public EnemyView(Node view, Enemy enemy) {
        super(view);
        this.enemy = enemy;
    }

    @Override
    public Enemy getGameObject() {
        return this.enemy;
    }
}
