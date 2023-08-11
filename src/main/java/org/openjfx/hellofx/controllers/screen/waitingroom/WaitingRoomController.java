package org.openjfx.hellofx.controllers.screen.waitingroom;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import org.openjfx.hellofx.controllers.screen.ScreensStateHandler;
import org.openjfx.hellofx.controllers.screen.payment.PaymentController;
import org.openjfx.hellofx.models.bike7.StandardBike;
import org.openjfx.hellofx.models.bike7.StandardE_Bike;
import org.openjfx.hellofx.models.bike7.TwinBike;
import org.openjfx.hellofx.models.bike7.TypeOfBike;
import org.openjfx.hellofx.models.timer.Time;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.openjfx.hellofx.utils.Configs;

public class WaitingRoomController extends ScreensStateHandler implements Initializable {
    Time time = new Time("0:20:0");
    Stage stage;
    TypeOfBike bike = new StandardE_Bike();
    boolean timer_pause_state = false;
    @FXML
    private Text timer;
    @FXML
    private Text total_pay;
    @FXML
    private Button pause_timer;
    @FXML
    private Button hiden_btn;
    @FXML
    private VBox vbox_test;
    @FXML
    private AnchorPane subscence_test;
    @FXML
    private ListView<String> list_view_bike_details;
    @FXML
    private Button back_btn;

    Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(1),
                    e -> {
                        this.time.oneSecondPassed();
                        timer.setText(this.time.getCurrentTime());

                        total_pay
                                .setText(Integer.toString(this.bike.calculateTotal(this.time.getTotalMinute())) + " đ");
                    }));

    public WaitingRoomController(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
        this.stage = stage;
        // StackPane subsceneRoot = (StackPane) subscence_test.getRoot();
        // subsceneRoot.getChildren().add(vbox_test);
        int bike_type = (int) ((HashMap<String, Object>) this.state.get("bike_details")).get("type");
        if (bike_type == 1) {
            this.bike = new StandardBike();
        }
        if (bike_type == 2) {
            this.bike = new StandardE_Bike();
        }
        if (bike_type == 3) {
            this.bike = new TwinBike();
        }
        System.out.println(bike_type);
        timer.setText(this.time.getCurrentTime());
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        pause_timer.setOnMouseClicked(event -> {
            if (timer_pause_state == false) {
                timeline.pause();
                this.timer_pause_state = true;
            } else {
                timeline.play();
                this.timer_pause_state = false;
            }

        });

        hiden_btn.setOnMouseClicked(event -> {
            // vbox_test.setVisible(true);
            subscence_test.setVisible(true);

        });
        back_btn.setOnMouseClicked(event -> {
            // vbox_test.setVisible(true);
            subscence_test.setVisible(false);

        });
    }
}
