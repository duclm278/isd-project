package org.openjfx.hellofx;

import java.io.IOException;
import java.util.List;

import org.openjfx.hellofx.models.bike.Bike;
import org.openjfx.hellofx.models.bike.BikeService;
import org.openjfx.hellofx.screens.home.HomeScreen;
import org.openjfx.hellofx.utils.Configs;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {

        Parent root;
        try {
            HomeScreen home = new HomeScreen(primaryStage, Configs.HOME_PATH);
            home.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        // launch(args);

        // Bike: getAll
        BikeService bikeService = new BikeService();
        System.out.println("All bikes:");
        bikeService.find().forEach(bike -> System.out.println(bike + "\n"));
    }

}
