package view.screen.payment;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.stage.Stage;
import view.screen.ScreensStateHandler;

public class PaymentScreen extends ScreensStateHandler implements Initializable{
    Stage stage;
    
    public PaymentScreen(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
        this.stage = stage;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }
}
