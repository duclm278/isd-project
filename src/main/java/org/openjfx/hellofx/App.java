package org.openjfx.hellofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.openjfx.hellofx.utils.Configs;
import java.io.IOException;
import org.openjfx.hellofx.view.screen.barcode.BarCodeScreen;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {

            Parent root;
            try {
                BarCodeScreen homeHandler = new BarCodeScreen(primaryStage, Configs.FIRST_PATH);
                homeHandler.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    public static void main(String[] args) {
        launch(args);
    }

}