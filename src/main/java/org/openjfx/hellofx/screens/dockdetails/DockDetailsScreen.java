package org.openjfx.hellofx.screens.dockdetails;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.openjfx.hellofx.screens.ScreensStateHandler;
import org.openjfx.hellofx.screens.home.HomeScreen;
import org.openjfx.hellofx.utils.Configs;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class DockDetailsScreen extends ScreensStateHandler implements Initializable {
    Stage stage;

    public DockDetailsScreen(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
        this.stage = stage;
    }

    @FXML
    private ImageView home_btn;

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
    }

}
