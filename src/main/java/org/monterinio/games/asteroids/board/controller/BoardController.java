package org.monterinio.games.asteroids.board.controller;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import org.monterinio.games.asteroids.board.model.ObjectFactory;
import org.monterinio.games.asteroids.bullet.view.BulletView;
import org.monterinio.games.asteroids.enemy.view.EnemyView;
import org.monterinio.games.asteroids.gameobject.view.GameObjectView;
import org.monterinio.games.asteroids.player.model.Player;
import org.monterinio.games.asteroids.player.view.PlayerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BoardController {

    private Pane pane;
    private List<BulletView> bullets = new ArrayList<>();
    private List<EnemyView> enemies = new ArrayList<>();
    private List<PlayerView> players = new ArrayList<>();

    public void registerPlayer() {
        var player = ObjectFactory.createPlayer();
        player.registerPosition(pane.getPrefWidth() * 0.5, pane.getPrefHeight() * 0.5);
        players.add(player);
        pane.getChildren().add(player.getView());
    }

    public void registerEnemy() {
        var enemy = ObjectFactory.createEnemy();
        enemy.registerPosition(pane.getPrefWidth() * Math.random(), pane.getPrefHeight() * Math.random());
        enemies.add(enemy);
        pane.getChildren().add(enemy.getView());
    }

    private void registerBullet(BulletView bullet, double x, double y) {
        bullet.getView().setTranslateX(x);
        bullet.getView().setTranslateY(y);
        bullets.add(bullet);
    }

    // consider creating separate model with lists related to model and moving logic there
    public Optional<Player> getPlayerByName(String name) {
        return players.stream() //
                .map(PlayerView::getGameObject) //
                .filter(player -> name.equals(player.getName())) //
                .findAny();
    }

    public void checkForCollision() {
        List<Node> objects = new ArrayList<>();
        for (var bul : bullets) {
            for (var en : enemies) {
                if (bul.isColliding(en)) {
                    bul.getGameObject().setDead();
                    en.getGameObject().setDead();
                    objects.add(bul.getView());
                    objects.add(en.getView());
                }
            }
        }

        bullets.removeIf(bullet -> bullet.getGameObject().isDead());
        enemies.removeIf(enemy -> enemy.getGameObject().isDead());

        pane.getChildren().removeAll(objects);
    }

    public void updatePlayersPosition() {
        players.forEach(GameObjectView::updatePosition);
        players.forEach(PlayerView::updateAngle);
    }

    public void updateBulletsPosition() {
        bullets.forEach(GameObjectView::updatePosition);
    }

    public void displayBullets() {
        for (PlayerView player : players) {
            var bulletsIter = player.getGameObject().getBullets().listIterator();

            while (bulletsIter.hasNext()) {
                var bul = bulletsIter.next();
                var bulView = ObjectFactory.createBullet(bul);
                registerBullet(bulView, player.getView().getBoundsInParent().getCenterX(),
                        player.getView().getBoundsInParent().getCenterY());
                this.pane.getChildren().add(bulView.getView());
                bulletsIter.remove();
            }
        }
    }

    public void limitPlayersMovement() {
        for (var player : players) {
            if (player.getView().getTranslateX() < 0) {
                player.getView().setTranslateX(0);
            } else if (player.getView().getTranslateX() >= getMaxDistanceAxisX(player)) {
                player.getView().setTranslateX(getMaxDistanceAxisX(player));
            }

            if (player.getView().getTranslateY() < 0) {
                player.getView().setTranslateY(0);
            } else if (player.getView().getTranslateY() >= getMaxDistanceAxisY(player)) {
                player.getView().setTranslateY(getMaxDistanceAxisY(player));
            }
        }
    }

    private double getMaxDistanceAxisY(PlayerView player) {
        return pane.getPrefHeight() - player.getView().getBoundsInParent().getHeight();
    }

    private double getMaxDistanceAxisX(PlayerView player) {
        return pane.getPrefWidth() - player.getView().getBoundsInParent().getWidth();
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }

}
