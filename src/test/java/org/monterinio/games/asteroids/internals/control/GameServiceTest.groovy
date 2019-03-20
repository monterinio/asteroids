package org.monterinio.games.asteroids.internals.control

import javafx.geometry.Point2D
import org.monterinio.games.asteroids.internals.entity.GameBoard
import spock.lang.Specification


class GameServiceTest extends Specification {

    def GameService sus = new GameService()
    def GameBoard gameBoard = new GameBoard()

    def setup() {
        sus.gameBoard = gameBoard
    }

    def "should update board after each cycle"() {
        def bullet1 = ObjectFactory.createBullet()
    }

}
