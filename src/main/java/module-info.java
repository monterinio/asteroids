module asteroids {
    exports org.monterinio.games.asteroids;

    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires afterburner.fx;
    requires java.annotation;
    opens org.monterinio.games.asteroids to afterburner.fx;
    opens org.monterinio.games.asteroids.internals.control;
    opens org.monterinio.games.asteroids.internals.entity;
    opens org.monterinio.games.asteroids.internals.boundary;
}
