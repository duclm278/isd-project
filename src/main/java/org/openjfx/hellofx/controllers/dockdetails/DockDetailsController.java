package org.openjfx.hellofx.controllers.dockdetails;

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

public class DockDetailsController extends ScreensStateHandler implements Initializable {
    Stage stage;

    public DockDetailsController(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
        this.stage = stage;
    }

    @FXML
    private ImageView home_btn;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
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
