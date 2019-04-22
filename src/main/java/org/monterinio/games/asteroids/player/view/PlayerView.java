package org.monterinio.games.asteroids.player.view;

import javafx.scene.Node;
import org.monterinio.games.asteroids.gameobject.view.GameObjectView;
import org.monterinio.games.asteroids.player.model.Player;

public class PlayerView extends GameObjectView {

    private Player player;

    public PlayerView(Node view, Player gameObject) {
        super(view);
        this.player = gameObject;
    }

    public void updateAngle() {
        this.view.setRotate(this.player.getAngle());
    }

    @Override
    public Player getGameObject() {
        return player;
    }
}
