package org.openjfx.hellofx.controllers.screen.rent;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import org.openjfx.hellofx.controllers.screen.ScreensStateHandler;
import org.openjfx.hellofx.controllers.screen.payment.PaymentController;
import org.openjfx.hellofx.models.bike7.Bike;
import org.openjfx.hellofx.models.bike7.StandardBike;
import org.openjfx.hellofx.models.bike7.StandardE_Bike;
import org.openjfx.hellofx.models.bike7.TwinBike;
import org.openjfx.hellofx.models.bike7.TypeOfBike;
import org.openjfx.hellofx.utils.Configs;
import org.openjfx.hellofx.views.RentScreen;

public class RentController extends ScreensStateHandler implements Initializable {
    Stage stage;

    String[] list_info;

    TypeOfBike bike = new StandardE_Bike();
    @FXML
    private Button pay_now;

    @FXML
    private Label deposit_amount;

    @FXML
    private ListView<String> rent_rule;

    @FXML
    private ListView<String> bike_info;

    public RentController(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
        this.stage = stage;
        RentScreen rentscreen = new RentScreen();
        System.out.println("STATE:" + this.state);
        this.getBikeType((HashMap<String, Object>) this.state.get("bike_details"));
        rentscreen.displayBikeDetails((HashMap<String, Object>) this.state.get("bike_details"), bike_info);
        rentscreen.displayPayRules(this.bike, deposit_amount, rent_rule);
        this.setState("bikeType_object", (HashMap<String, Object>) this.state.get("bike_details"));
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        pay_now.setOnMouseClicked(event -> {
            PaymentController pay_screen;
            try {
                pay_screen = new PaymentController(this.stage, Configs.THIRD_PATH);
                pay_screen.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


    public void getBikeType(HashMap<String, Object> bike_details){
        String type = bike_details.get("type").toString();
        if (type.equals("1")) {
            this.bike = new StandardBike();
        }
        if (type.equals("2")) {
            this.bike = new StandardE_Bike();
        }
        if (type.equals("3")) {
            this.bike = new TwinBike();
        }
    }

}
