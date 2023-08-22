package org.openjfx.hellofx.screen.payment;

import javafx.stage.Stage;

import org.openjfx.hellofx.config.Screens;
import org.openjfx.hellofx.controller.RentingController;
import org.openjfx.hellofx.model.bike.Bike;
import org.openjfx.hellofx.screen.home.HomeScreen;
import org.openjfx.hellofx.screen.rent.RentScreen;
import org.openjfx.hellofx.screen.waitingroom.WaitingRoomScreen;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DepositResultScreen extends ResultScreen {

    public DepositResultScreen(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        redirect_btn.setText("Go to Waiting Screen");
        home_btn.setOnMouseClicked(event -> {
            HomeScreen home;
            try {
                home = new HomeScreen(this.stage, Screens.HOME_PATH);
                home.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        redirect_btn.setOnMouseClicked(event -> {
            WaitingRoomScreen waitingRoomScreen;
            try {
                waitingRoomScreen = new WaitingRoomScreen(this.stage, Screens.FOURTH_PATH);
                waitingRoomScreen.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void display(int statusTransactionCode) {
        redirect_btn.setText("Go to Rent Bike");
        redirect_btn.setOnMouseClicked(event -> {
            WaitingRoomScreen waitingRoomScreen;
            try {
                waitingRoomScreen = new WaitingRoomScreen(this.stage, Screens.FOURTH_PATH);
                waitingRoomScreen.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        if (statusTransactionCode == 0) {
            resultMessage.setText("Payment Successfully");
            Bike rentedBike = (Bike) RentScreen.state.get("bike_details");
            new RentingController().rentBike(rentedBike.getId());
        } else if (statusTransactionCode == 1) {
            resultMessage.setText("Your card information is incorrect");
            redirect_btn.setText("Back to card information");
            redirect_btn.setOnMouseClicked(event -> {
                PaymentScreen paymentScreen;
                try {
                    paymentScreen = new PaymentScreen(this.stage, Screens.THIRD_PATH);
                    paymentScreen.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } else if (statusTransactionCode == 2) {
            resultMessage.setText("Your account's balance is not enough");
            redirect_btn.setOnMouseClicked(event -> {
                PaymentScreen paymentScreen;
                try {
                    paymentScreen = new PaymentScreen(this.stage, Screens.THIRD_PATH);
                    paymentScreen.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } else {
            resultMessage.setText("Something Error!!");
        }
    }
}
