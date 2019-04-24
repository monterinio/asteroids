package org.monterinio.games.asteroids.player.model.rotation


import spock.lang.Specification

class BasicRotationSignalsTest extends Specification {

    BasicRotationSignals cut = new BasicRotationSignals()

    def "should rotate anticlockwise"() {

        given: "Q pressed"
        cut.onQ()

        when:
        def angle = cut.calculateAngle()

        then:
        angle == -45.0d
    }

    def "should rotate clockwise"() {

        given: "E pressed"
        cut.onE()

        when:
        def angle = cut.calculateAngle()

        then:
        angle == 45.0d
    }
}
