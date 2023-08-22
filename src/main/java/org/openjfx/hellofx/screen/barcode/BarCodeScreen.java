package org.openjfx.hellofx.screen.barcode;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.openjfx.hellofx.config.Screens;
import org.openjfx.hellofx.controller.BikeController;
import org.openjfx.hellofx.controller.DockingController;
import org.openjfx.hellofx.model.bike.Bike;
import org.openjfx.hellofx.model.docking.Docking;
import org.openjfx.hellofx.screen.ScreensStateHandler;
import org.openjfx.hellofx.screen.home.HomeScreen;
import org.openjfx.hellofx.screen.rent.RentScreen;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
    @FXML
    private Text error_message;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // throw new UnsupportedOperationException("Unimplemented method 'initialize'");
        rent_btn.setOnMouseClicked(event -> {
            RentScreen rent_screen;
            try {
                String inputValue = title.getText();
                BikeController bikeController = new BikeController();
                Bike bike = bikeController.findByBarcode(inputValue);
                DockingController dockingController = new DockingController();
                Docking docking = dockingController.findByBikeBarcode(inputValue);
                BarCodeDisplayer error = new BarCodeDisplayer();
                if (bike == null) {
                    error.displayErrorMessage(error_message);
                } else {
                    if (docking == null) {
                        error.displayBikeIsRented(error_message);
                    } else {
                        this.setState("bike_details", bike);
                        rent_screen = new RentScreen(this.stage, Screens.SECOND_PATH);
                        rent_screen.show();
                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        home_btn.setOnMouseClicked(event -> {
            HomeScreen home;
            try {
                home = new HomeScreen(this.stage, Screens.HOME_PATH);
                home.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
