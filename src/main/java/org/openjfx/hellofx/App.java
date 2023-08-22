package org.openjfx.hellofx;

import java.io.IOException;

import org.openjfx.hellofx.config.Screens;
import org.openjfx.hellofx.screen.home.HomeScreen;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {

        Parent root;
        try {
            Image iconImage = new Image("org/openjfx/hellofx/image/window_img.png");
            primaryStage.getIcons().add(iconImage);
            HomeScreen home = new HomeScreen(primaryStage, Screens.HOME_PATH);
            home.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        // launch(args);

        // DEMO
        // TestBike.run();
        // TestDock.run();
        TestDocking.run();
        // TestRenting.run();
    }

}
