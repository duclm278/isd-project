package org.openjfx.hellofx.controllers.returnbike;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.openjfx.hellofx.controllers.ScreensStateHandler;
import org.openjfx.hellofx.controllers.home.HomeController;
import org.openjfx.hellofx.utils.Configs;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ReturnController extends ScreensStateHandler implements Initializable {
    Stage stage;
    @FXML
    private ImageView home_btn;

    public ReturnController(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
        this.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        home_btn.setOnMouseClicked(event -> {
            HomeController home;
            try {
                home = new HomeController(this.stage, Configs.HOME_PATH);
                home.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
