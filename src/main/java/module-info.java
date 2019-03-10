module asteroids {
    exports org.monterinio.games.asteroids;

    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires afterburner.fx;
    opens org.monterinio.games.asteroids to afterburner.fx;
    opens org.monterinio.games.asteroids.internals to afterburner.fx, javafx.fxml;
}
