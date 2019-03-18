package org.monterinio.games.asteroids.internals

import spock.lang.Specification


class MyServiceTest extends Specification {

    def sus = new MyService()

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
