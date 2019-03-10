package org.monterinio.games.asteroids;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.airhacks.afterburner.injection.Injector;
import org.monterinio.games.asteroids.internals.DashboardView;

import java.util.HashMap;
import java.util.Map;


public class MainAsteroids extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Map<Object, Object> customProperties = new HashMap<>();
        customProperties.put("string", "string");
        Injector.setConfigurationSource(customProperties::get);

//        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));

        DashboardView appView = new DashboardView();
        Scene scene = new Scene(appView.getView());

//        Scene scene = new Scene(root);
//        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
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
