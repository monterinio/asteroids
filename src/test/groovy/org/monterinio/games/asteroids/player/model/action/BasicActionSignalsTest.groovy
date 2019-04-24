package org.monterinio.games.asteroids.player.model.action


import spock.lang.Specification

class BasicActionSignalsTest extends Specification {

    BasicActionSignals cut = new BasicActionSignals()
    def EPSILON = 1E-6

    def "should shoot ahead"() {

        given: "Space pressed"
        cut.onSpace()

        and: "player's current angle"
        def currentAngle = 0.0

        when:
        def angle = cut.shoot(currentAngle)

        then:
        Math.abs(angle) <= 180.0 + EPSILON
    }

    def "should shoot behind"() {

        given: "Space pressed, Shift pressed"
        cut.onSpace()
        cut.onShift()

        and: "player's current angle"
        def currentAngle = 0.0

        when:
        def angle = cut.shoot(currentAngle)

        then:
        Math.abs(angle) <= EPSILON
    }

    def "should detect unsupported action"() {

        given: "player's current angle"
        def currentAngle = 0.0

        when:
        cut.shoot(currentAngle)

        then:
        thrown(UnsupportedOperationException)
    }
}
