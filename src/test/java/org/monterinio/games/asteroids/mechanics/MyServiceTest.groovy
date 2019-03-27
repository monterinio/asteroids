package org.monterinio.games.asteroids.mechanics

import org.monterinio.games.asteroids.mechanics.control.GameServiceTest
import spock.lang.Specification


class MyServiceTest extends Specification {

    def sus = new GameServiceTest()

    def "should calculate surface"() {
        expect:
        sus.calculateSurface(a, b) == result

        where:
        a | b | result
        0 | 1 | 0
        1 | 1 | 1
        2 | 2 | 4
        10| 5 | 50
    }
}
