package com.example.javafxproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Driver to launch the Window for the main application.
 *
 * @author Ishani Mhatre
 * @author Keerthana Talla
 */

public class MainPizzaApplication extends Application {

    /**
     * Load the MainView and show the window.
     *
     * @param stage that the main scene is going to show.
     * @throws IOException when the fxml file is not found.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 800);
        stage.setTitle("RU Pizza");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main class to launch the application.
     *
     * @param args that are not supposed to exist.
     */
    public static void main(String[] args) {
        launch(args);
    }
}