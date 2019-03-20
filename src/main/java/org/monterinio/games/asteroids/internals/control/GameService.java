package org.monterinio.games.asteroids.internals.control;

import javafx.scene.layout.Pane;
import org.monterinio.games.asteroids.internals.entity.GameBoard;
import org.monterinio.games.asteroids.internals.entity.GameObject;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

public class GameService {

    @Inject
    private GameBoard gameBoard;

    public void setUpPlayer() {
    }

    public void checkForEvents() {
        gameBoard.bullets //
                .stream() //
                .flatMap(bullet -> gameBoard.enemies //
                        .stream() //
                        .filter(enemy -> bullet.isColliding(enemy))) //
                .collect(Collectors.toList()) //
                .forEach(object -> object.alive = false);
    }

    public void generateEnemy(Pane pane) {
        if(Math.random() < 0.02) {
            var enemy = ObjectFactory.createEnemy();
            generateObject(enemy, gameBoard.enemies, pane.getPrefWidth() * Math.random(),
                    pane.getPrefHeight() * Math.random());
            pane.getChildren().add(enemy.getView());
        }
    }


    void generateObject(GameObject gameObject, List<GameObject> gameObjects, double x, double y) {
        gameObjects.add(gameObject);
        gameObject.getView().setTranslateX(x);
        gameObject.getView().setTranslateY(y);
    }
}
