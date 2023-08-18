package org.openjfx.hellofx.screen.payment;

import javafx.stage.Stage;

import org.openjfx.hellofx.controller.RentingController;
import org.openjfx.hellofx.model.bike.Bike;
import org.openjfx.hellofx.screen.home.HomeScreen;
import org.openjfx.hellofx.screen.returnbike.ReturnScreen;
import org.openjfx.hellofx.screen.waitingroom.WaitingRoomScreen;
import org.openjfx.hellofx.util.Configs;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReturnBikePaymentScreen extends ResultScreen {
    public ReturnBikePaymentScreen(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        home_btn.setOnMouseClicked(event -> {
            HomeScreen home;
            try {
                home = new HomeScreen(this.stage, Configs.HOME_PATH);
                home.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        redirect_btn.setOnMouseClicked(event -> {
            HomeScreen home;
            try {
                home = new HomeScreen(this.stage, Configs.HOME_PATH);
                home.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void display(int statusTransactionCode) {
        redirect_btn.setText("Back Home");
        redirect_btn.setOnMouseClicked(event -> {
            HomeScreen home;
            try {
                home = new HomeScreen(this.stage, Configs.HOME_PATH);
                home.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        if (statusTransactionCode == 0) {
            resultMessage.setText("Payment Successfully");

            Bike rentedBike = (Bike) WaitingRoomScreen.state.get("bike_details");
            String dockId = (String) ReturnScreen.state.get("Dock id");
            System.out.println("Dock id: " + dockId + " Bike id: " + rentedBike.getId().toString());
            new RentingController().returnBike(rentedBike.getId().toString(), dockId);

            // TODO: Remove all state belong to previous transaction
        } else if (statusTransactionCode == 1) {
            resultMessage.setText("Your card information is incorrect");
            redirect_btn.setText("Back to card information");
            redirect_btn.setOnMouseClicked(event -> {
                PaymentScreen paymentScreen;
                try {
                    paymentScreen = new PaymentScreen(this.stage, Configs.THIRD_PATH);
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
                    paymentScreen = new PaymentScreen(this.stage, Configs.THIRD_PATH);
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
