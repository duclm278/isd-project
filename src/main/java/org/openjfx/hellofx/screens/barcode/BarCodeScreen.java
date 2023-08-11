package org.openjfx.hellofx.screens.barcode;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import org.openjfx.hellofx.models.bike7.Bike;
import org.openjfx.hellofx.screens.ScreensStateHandler;
import org.openjfx.hellofx.screens.home.HomeScreen;
import org.openjfx.hellofx.screens.rent.RentScreen;
import org.openjfx.hellofx.utils.Configs;

public class BarCodeScreen extends ScreensStateHandler implements Initializable {
    Stage stage;

    public BarCodeScreen(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
        this.stage = stage;
    }

    @FXML
    private TextField title;

    @FXML
    private Button rent_btn;
    @FXML
    private ImageView home_btn;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // throw new UnsupportedOperationException("Unimplemented method 'initialize'");
        rent_btn.setOnMouseClicked(event -> {
            RentScreen rent_screen;
            try {
                Bike bike = new Bike();
                HashMap<String, Object> bike_details = bike.getBikeByBarCode(bike.dictionary, "X0S@aaa");
                if (bike_details != null) {
                    this.setState("bike_details", bike_details);
                    rent_screen = new RentScreen(this.stage, Configs.SECOND_PATH);
                    rent_screen.show();
                } else {
                    System.out.println("DATA NULL");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        home_btn.setOnMouseClicked(event -> {
            HomeScreen home;
            try {
                home = new HomeScreen(this.stage, Configs.HOME_PATH);
                home.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
