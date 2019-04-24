package org.monterinio.games.asteroids.player.model.movement

import javafx.geometry.Point2D
import spock.lang.Specification


class BasicMovementSignalsTest extends Specification {

    BasicMovementSignals cut = new BasicMovementSignals()

    def "should calculate left velocity vector"() {
        given: "A pressed"
        cut.onA()

        when:
        def velocity = cut.calculateVelocity()

        then:
        new Point2D(-1, 0) == velocity
    }

    def "should calculate right velocity vector"() {
        given: "D pressed"
        cut.onD()

        when:
        def velocity = cut.calculateVelocity()

        then:
        new Point2D(1, 0) == velocity
    }

    def "should calculate up velocity vector"() {
        given: "W pressed"
        cut.onW()

        when:
        def velocity = cut.calculateVelocity()

        then:
        new Point2D(0, -1) == velocity
    }

    def "should calculate down velocity vector"() {
        given: "S pressed"
        cut.onS()

        when:
        def velocity = cut.calculateVelocity()

        then:
        new Point2D(0, 1) == velocity
    }

    def "should calculate upper-left velocity vector"() {
        given: "W pressed, A pressed"
        cut.onW()
        cut.onA()

        when:
        def velocity = cut.calculateVelocity()

        then:
        new Point2D(-1, -1).normalize() == velocity
    }

    def "should calculate upper-right velocity vector"() {
        given: "W pressed, D pressed"
        cut.onW()
        cut.onD()

        when:
        def velocity = cut.calculateVelocity()

        then:
        new Point2D(1, -1).normalize() == velocity
    }

    def "should calculate bottom-left velocity vector"() {
        given: "S pressed, A pressed"
        cut.onS()
        cut.onA()

        when:
        def velocity = cut.calculateVelocity()

        then:
        new Point2D(-1, 1).normalize() == velocity
    }

    def "should calculate bottom-right velocity vector"() {
        given: "S pressed, D pressed"
        cut.onS()
        cut.onD()

        when:
        def velocity = cut.calculateVelocity()

        then:
        new Point2D(1, 1).normalize() == velocity
    }

    def "should calculate zero velocity vector"() {
        when:
        def velocity = cut.calculateVelocity()

        then:
        Point2D.ZERO == velocity
    }
}
