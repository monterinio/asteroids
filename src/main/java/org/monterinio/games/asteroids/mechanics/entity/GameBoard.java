package org.monterinio.games.asteroids.mechanics.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GameBoard {

    public List<GameObject> bullets;
    public List<GameObject> enemies;
    public List<Player> players;

    public GameBoard() {
        bullets = new ArrayList<>();
        enemies = new ArrayList<>();
        players = new ArrayList<>();
    }

    public void registerPlayer(Player player, double x, double y) {
        player.getView().setTranslateX(x);
        player.getView().setTranslateY(y);
        players.add(player);
    }

    public void registerEnemy(GameObject enemy, double x, double y) {
        enemy.getView().setTranslateX(x);
        enemy.getView().setTranslateY(y);
        enemies.add(enemy);
    }

    public Optional<Player> getPlayerByName(String name) {
        return players.stream() //
                .filter(player -> name.equals(player.getName())) //
                .findAny();
    }


    public void registerBullet(GameObject bullet, double x, double y) {
        bullet.getView().setTranslateX(x);
        bullet.getView().setTranslateY(y);
        bullets.add(bullet);
    }
}
