package org.openjfx.hellofx.screen.rent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.openjfx.hellofx.model.bike.Bike;
import org.openjfx.hellofx.model.policy.StandardBike;
import org.openjfx.hellofx.model.policy.StandardE_Bike;
import org.openjfx.hellofx.model.policy.TwinBike;
import org.openjfx.hellofx.model.policy.TypeOfBike;
import org.openjfx.hellofx.screen.ScreensStateHandler;
import org.openjfx.hellofx.screen.home.HomeScreen;
import org.openjfx.hellofx.screen.payment.PaymentScreen;
import org.openjfx.hellofx.util.Configs;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class RentScreen extends ScreensStateHandler implements Initializable {
    Stage stage;

    String[] list_info;

    TypeOfBike bike = new StandardE_Bike();
    @FXML
    private Button pay_now;
    @FXML
    private ImageView home_btn;

    @FXML
    private Label deposit_amount;

    @FXML
    private ListView<String> rent_rule;

    @FXML
    private ListView<String> bike_info;

    public RentScreen(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
        this.stage = stage;
        RentDisplayer rentscreen = new RentDisplayer();
        System.out.println("STATE:" + this.state);
        this.getBikeType((Bike) this.state.get("bike_details"));

        rentscreen.displayBikeDetails((Bike) this.state.get("bike_details"), bike_info);
        rentscreen.displayPayRules(this.bike, deposit_amount, rent_rule);
        // this.setState("bikeType_object", (HashMap<String, Object>)
        // this.state.get("bike_details"));
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        pay_now.setOnMouseClicked(event -> {
            PaymentScreen pay_screen;
            try {
                this.setState("command", "pay");
                this.setState("amount", this.bike.depositAmount());
                this.setState("deposit", this.bike.depositAmount());
                System.out.println("command:" + this.state.get("command"));
                pay_screen = new PaymentScreen(this.stage, Configs.THIRD_PATH);
                pay_screen.show();

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

    public void getBikeType(Bike bike_details) {
        String type = bike_details.type;
        if (type.equals("N1")) {
            this.bike = new StandardBike();
        }
        if (type.equals("E1")) {
            this.bike = new StandardE_Bike();
        }
        if (type.equals("N2")) {
            this.bike = new TwinBike();
        }
    }

}
