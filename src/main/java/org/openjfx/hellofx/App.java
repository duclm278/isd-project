package org.openjfx.hellofx;

import java.io.IOException;

import org.openjfx.hellofx.controllers.screen.barcode.BarCodeController;
import org.openjfx.hellofx.controllers.screen.home.HomeController;
import org.openjfx.hellofx.models.movie.MovieService;
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
            HomeController home = new HomeController(primaryStage, Configs.HOME_PATH);
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
