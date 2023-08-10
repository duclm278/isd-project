import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import utils.Configs;
import view.screen.barcode.BarCodeScreen;

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