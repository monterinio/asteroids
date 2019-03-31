package org.monterinio.games.asteroids;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import com.airhacks.afterburner.injection.Injector;
import org.monterinio.games.asteroids.commands.action.handler.BasicActionHandler;
import org.monterinio.games.asteroids.commands.action.handler.BasicActionStopHandler;
import org.monterinio.games.asteroids.commands.movement.handler.BasicMovementHandler;
import org.monterinio.games.asteroids.commands.rotation.handler.BasicRotationHandler;
import org.monterinio.games.asteroids.commands.movement.handler.BasicMovementStopHandler;
import org.monterinio.games.asteroids.commands.rotation.handler.BasicRotationStopHandler;

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

        stage.setTitle("JavaFX and Maven");
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
