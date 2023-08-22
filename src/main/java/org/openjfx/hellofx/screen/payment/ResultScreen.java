package org.openjfx.hellofx.screen.payment;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.openjfx.hellofx.config.Screens;
import org.openjfx.hellofx.screen.ScreensStateHandler;
import org.openjfx.hellofx.screen.home.HomeScreen;
import org.openjfx.hellofx.screen.waitingroom.WaitingRoomScreen;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ResultScreen extends ScreensStateHandler implements Initializable {
    Stage stage;
    @FXML
    protected Text resultMessage;
    @FXML
    protected Button redirect_btn;
    @FXML
    protected ImageView home_btn;

    public ResultScreen(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
        this.stage = stage;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

    public void display(int statusTransactionCode) {

    }
}
