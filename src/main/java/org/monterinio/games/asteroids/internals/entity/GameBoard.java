package org.monterinio.games.asteroids.internals.entity;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {

    public List<GameObject> bullets;
    public List<GameObject> enemies;

    public GameObject player;

    public GameBoard() {
        bullets = new ArrayList<>();
        enemies = new ArrayList<>();
    }


}
