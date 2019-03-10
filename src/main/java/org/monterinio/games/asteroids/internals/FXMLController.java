package org.monterinio.games.asteroids.internals;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.inject.Inject;

public class FXMLController {

    @Inject
    private String string;

    @Inject
    private MyService myService;

    @FXML
    private Label label;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        System.out.println(string);
        myService.doStuff();
        label.setText("Hello World!");
    }

    public void initialize() {
        // TODO
    }
}
