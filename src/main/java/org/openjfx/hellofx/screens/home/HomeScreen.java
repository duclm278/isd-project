package org.openjfx.hellofx.screens.home;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.openjfx.hellofx.screens.ScreensStateHandler;
import org.openjfx.hellofx.screens.barcode.BarCodeScreen;
import org.openjfx.hellofx.screens.dockdetails.DockDetailsScreen;
import org.openjfx.hellofx.screens.payment.PaymentScreen;
import org.openjfx.hellofx.screens.returnbike.ReturnScreen;
import org.openjfx.hellofx.screens.waitingroom.WaitingRoomScreen;
import org.openjfx.hellofx.utils.Configs;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HomeScreen extends ScreensStateHandler implements Initializable {
    Stage stage;
    @FXML
    private Button return_btn, rent_bike_btn, payment_btn, search_btn, view_bike_btn1, view_bike_btn2;
    @FXML
    private TextField search_bar;

    public HomeScreen(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
        this.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rent_bike_btn.setOnMouseClicked(event -> {
            BarCodeScreen barcode;
            try {
                barcode = new BarCodeScreen(this.stage, Configs.FIRST_PATH);
                barcode.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        payment_btn.setOnMouseClicked(event -> {
            PaymentScreen payment;
            try {
                payment = new PaymentScreen(this.stage, Configs.THIRD_PATH);
                payment.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return_btn.setOnMouseClicked(event -> {
            ReturnScreen returnbike;
            try {
                returnbike = new ReturnScreen(this.stage, Configs.FIFTH_PATH);
                returnbike.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        view_bike_btn1.setOnMouseClicked(event -> {
            DockDetailsScreen dockdetails;
            try {
                dockdetails = new DockDetailsScreen(this.stage, Configs.SIXTH_PATH);
                dockdetails.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
