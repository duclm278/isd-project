package org.openjfx.hellofx.screens.payment;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import org.openjfx.hellofx.screens.ScreensStateHandler;
import org.openjfx.hellofx.screens.home.HomeScreen;
import org.openjfx.hellofx.screens.rent.RentScreen;
import org.openjfx.hellofx.screens.waitingroom.WaitingRoomScreen;
import org.openjfx.hellofx.utils.Configs;

public class PaymentScreen extends ScreensStateHandler implements Initializable {
    Stage stage;

    @FXML
    private Button start_rent;
    @FXML
    private ImageView home_btn;

    public PaymentScreen(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
        this.stage = stage;
        // int bike_type = ((HashMap<String, Object>)
        // this.state.get("bike_details")).get("type");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        start_rent.setOnMouseClicked(event -> {
            WaitingRoomScreen wait_screen;
            try {
                wait_screen = new WaitingRoomScreen(this.stage, Configs.FOURTH_PATH);
                wait_screen.show();

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