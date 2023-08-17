package org.openjfx.hellofx.screen.payment;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.openjfx.hellofx.screen.ScreensStateHandler;
import org.openjfx.hellofx.screen.home.HomeScreen;
import org.openjfx.hellofx.screen.waitingroom.WaitingRoomScreen;
import org.openjfx.hellofx.util.Configs;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ResultScreen extends ScreensStateHandler implements Initializable {
    Stage stage;
    @FXML
    private Text resultMessage;
    @FXML
    private Button redirect_btn;
    @FXML
    private ImageView home_btn;

    public ResultScreen(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
        this.stage = stage;
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
            WaitingRoomScreen waitingRoomScreen;
            try {
                waitingRoomScreen = new WaitingRoomScreen(this.stage, Configs.FOURTH_PATH);
                waitingRoomScreen.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void display(int statusTransactionCode, String redirect) {
        if(redirect.equals("return bike")){
            redirect_btn.setText("Go to Rent Bike");
            redirect_btn.setOnMouseClicked(event -> {
                WaitingRoomScreen waitingRoomScreen;
                try {
                    waitingRoomScreen = new WaitingRoomScreen(this.stage, Configs.FOURTH_PATH);
                    waitingRoomScreen.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } else if (redirect.equals("home")) {
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
        }
        if (statusTransactionCode == 0) {
            resultMessage.setText("Payment Successfully");
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
