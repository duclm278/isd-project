package org.openjfx.hellofx;

import java.io.IOException;

import org.openjfx.hellofx.models.movie.MovieService;
import org.openjfx.hellofx.screens.barcode.BarCodeScreen;
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
        launch(args);

        // DEMO
        MovieService movieService = new MovieService();
        System.out.println("All movies:");
        movieService.find().forEach(movie -> System.out.println(movie + "\n"));
    }

}
