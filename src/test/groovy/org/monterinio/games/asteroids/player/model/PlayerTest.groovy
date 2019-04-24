package org.monterinio.games.asteroids.player.model

import spock.lang.Specification

class PlayerTest extends Specification {

    def EPSILON = 10E-6

    def "should shoot"() {

        given: "Player object"
        Player player = new Player('test')

        and: "shoot signal on"
        player.attackSignals.onSpace()

        when:
        player.shoot()

        then:
        player.bullets.size() == 1

        Math.abs(player.bullets.get(0).velocity.x) <= EPSILON
        player.bullets.get(0).velocity.y == -5
    }
}
