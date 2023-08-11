package org.openjfx.hellofx.controllers.screen.home;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.openjfx.hellofx.controllers.screen.ScreensStateHandler;
import org.openjfx.hellofx.controllers.screen.barcode.BarCodeController;
import org.openjfx.hellofx.controllers.screen.dockdetails.DockDetailsController;
import org.openjfx.hellofx.controllers.screen.payment.PaymentController;
import org.openjfx.hellofx.controllers.screen.returnbike.ReturnController;
import org.openjfx.hellofx.controllers.screen.waitingroom.WaitingRoomController;
import org.openjfx.hellofx.utils.Configs;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HomeController extends ScreensStateHandler implements Initializable{
        Stage stage;
        @FXML
        private Button return_btn, rent_bike_btn, payment_btn, search_btn, view_bike_btn1, view_bike_btn2;
        @FXML
        private TextField search_bar; 

        public HomeController(Stage stage, String screenPath) throws IOException {
            super(stage, screenPath);
            this.stage = stage;
         }

        @Override
        public void initialize(URL location, ResourceBundle resources) {
            rent_bike_btn.setOnMouseClicked(event -> {
                BarCodeController barcode;
                try {
                    barcode = new BarCodeController(this.stage, Configs.FIRST_PATH);
                    barcode.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            payment_btn.setOnMouseClicked(event -> {
                PaymentController payment;
                try {
                    payment = new PaymentController(this.stage, Configs.THIRD_PATH);
                    payment.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            return_btn.setOnMouseClicked(event -> {
                ReturnController returnbike;
                try {
                    returnbike = new ReturnController(this.stage, Configs.FIFTH_PATH);
                    returnbike.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            
            view_bike_btn1.setOnMouseClicked(event -> {
                DockDetailsController dockdetails;
                try {
                    dockdetails = new DockDetailsController(this.stage, Configs.SIXTH_PATH);
                    dockdetails.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        }
}
