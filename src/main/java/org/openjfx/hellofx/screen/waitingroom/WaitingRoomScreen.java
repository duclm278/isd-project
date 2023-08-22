package org.openjfx.hellofx.screen.waitingroom;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import org.openjfx.hellofx.config.Screens;
import org.openjfx.hellofx.model.bike.Bike;
import org.openjfx.hellofx.model.policy.StandardBike;
import org.openjfx.hellofx.model.policy.StandardE_Bike;
import org.openjfx.hellofx.model.policy.TwinBike;
import org.openjfx.hellofx.model.policy.TypeOfBike;
import org.openjfx.hellofx.model.timer.Time;
import org.openjfx.hellofx.screen.ScreensStateHandler;
import org.openjfx.hellofx.screen.payment.ReturnBikePaymentScreen;
import org.openjfx.hellofx.screen.returnbike.ReturnScreen;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class WaitingRoomScreen extends ScreensStateHandler implements Initializable {
    Time time = new Time("0:20:0");
    Stage stage;
    TypeOfBike bike = new StandardE_Bike();
    boolean timer_pause_state = false;
    @FXML
    private Text timer;
    @FXML
    private Text total_pay;
    @FXML
    private Button pause_timer, return_btn;
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
    private int total;
    Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(1),
                    e -> {
                        this.time.oneSecondPassed();
                        timer.setText(this.time.getCurrentTime());
                        this.total = this.bike.calculateTotal(this.time.getTotalMinute());
                        total_pay
                                .setText(Integer.toString(this.bike.calculateTotal(this.time.getTotalMinute())) + "đ");
                    }));

    public WaitingRoomScreen(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
        this.stage = stage;
        // StackPane subsceneRoot = (StackPane) subscence_test.getRoot();
        // subsceneRoot.getChildren().add(vbox_test);
        String bike_type = (String) ((Bike) this.state.get("bike_details")).type;
        if (bike_type == "N1") {
            this.bike = new StandardBike();
        }
        if (bike_type == "E1") {
            this.bike = new StandardE_Bike();
        }
        if (bike_type == "N2") {
            this.bike = new TwinBike();
        }
        System.out.println(bike_type);

        LocalDateTime currentTime = LocalDateTime.now(); // Định dạng chuỗi thời gian
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss yyyy-MM-dd");
        String formattedTime = currentTime.format(formatter);
        this.setState("start_time", formattedTime);

        timer.setText(this.time.getCurrentTime());
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        return_btn.setOnMouseClicked(event -> {
            ReturnScreen returnbike;
            try {

                if (((int) this.state.get("deposit") - this.total) > 0) {
                    this.setState("command", "refund");
                    this.setState("amount", (int) this.state.get("deposit") - this.total);
                    System.out.println("COMMand:" + this.state);
                } else {
                    this.setState("command", "pay");
                    this.setState("amount", this.total - (int) this.state.get("deposit"));
                    System.out.println("COMMand:" + this.state);

                }

                // End time
                LocalDateTime currentTime = LocalDateTime.now(); // Định dạng chuỗi thời gian
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss yyyy-MM-dd");
                String formattedTime = currentTime.format(formatter);
                this.setState("end_time", formattedTime);

                // Total rent time
                this.setState("rent_time", this.time.getCurrentTime());
                System.out.println("STATE:" + this.state.get("rent_time"));

                this.setState(formattedTime, arg1);
                returnbike = new ReturnScreen(this.stage, Screens.FIFTH_PATH);
                returnbike.display();
                returnbike.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

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
