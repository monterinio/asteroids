package org.monterinio.games.asteroids;

import com.airhacks.afterburner.injection.Injector;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.monterinio.games.asteroids.player.controller.action.BasicActionHandler;
import org.monterinio.games.asteroids.player.controller.action.BasicActionStopHandler;
import org.monterinio.games.asteroids.player.controller.movement.BasicMovementHandler;
import org.monterinio.games.asteroids.player.controller.movement.BasicMovementStopHandler;
import org.monterinio.games.asteroids.player.controller.rotation.BasicRotationHandler;
import org.monterinio.games.asteroids.player.controller.rotation.BasicRotationStopHandler;

import java.util.HashMap;
import java.util.Map;

public class MainAsteroids extends Application {

    @Override
    public void start(Stage stage) {
        Map<Object, Object> customProperties = new HashMap<>();
        Injector.setConfigurationSource(customProperties::get);

        DashboardView appView = new DashboardView();
        Scene scene = new Scene(appView.getView());

        scene.addEventFilter(KeyEvent.KEY_PRESSED, new BasicMovementHandler());
        scene.addEventFilter(KeyEvent.KEY_RELEASED, new BasicMovementStopHandler());

        scene.addEventFilter(KeyEvent.KEY_PRESSED, new BasicRotationHandler());
        scene.addEventFilter(KeyEvent.KEY_RELEASED, new BasicRotationStopHandler());

        scene.addEventFilter(KeyEvent.KEY_PRESSED, new BasicActionHandler());
        scene.addEventFilter(KeyEvent.KEY_RELEASED, new BasicActionStopHandler());

        stage.setTitle("Asteroids");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void stop() {
        Injector.forgetAll();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
