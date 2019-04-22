module asteroids {
    exports org.monterinio.games.asteroids;

    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires afterburner.fx;
    requires java.annotation;
    opens org.monterinio.games.asteroids to afterburner.fx;
    opens org.monterinio.games.asteroids.board to afterburner.fx, javafx.fxml;
    opens org.monterinio.games.asteroids.board.controller to afterburner.fx;

}
