package org.openjfx.hellofx.screens.home;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.models.dock.Dock;
import org.openjfx.hellofx.screens.ScreensStateHandler;
import org.openjfx.hellofx.screens.barcode.BarCodeScreen;
import org.openjfx.hellofx.screens.dockdetails.DockDetailsScreen;
import org.openjfx.hellofx.screens.payment.PaymentScreen;
import org.openjfx.hellofx.screens.returnbike.ReturnScreen;
import org.openjfx.hellofx.screens.waitingroom.WaitingRoomScreen;
import org.openjfx.hellofx.utils.Configs;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeScreen extends ScreensStateHandler implements Initializable {
    Stage stage;
    HomeDisplayer homedisplayer;
    @FXML
    private Button return_btn, rent_bike_btn, payment_btn, search_btn, view_bike_btn1, view_bike_btn2;
    @FXML
    private TextField search_bar;
    @FXML
    private ScrollPane body_pane;

    public HomeScreen(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
        this.stage = stage;

        this.homedisplayer = new HomeDisplayer(this.stage);
        List<Dock> dockList = new ArrayList<>();
        Dock dock1 = new Dock(new ObjectId(), "Hoan Kiem", "So 3 Hoan Kiem", 22, 0, 0.0, 0.0);
        Dock dock2 = new Dock(new ObjectId(), "Long Bien", "So 10 Nguyen Van Cu", 22, 0, 0.0, 0.0);
        Dock dock3 = new Dock(new ObjectId(), "Thanh Xuan", "So 2 Truong Chinh", 22, 0, 0.0, 0.0);

        dockList.add(dock1);
        dockList.add(dock2);
        dockList.add(dock3);
        homedisplayer.displayListOfDocks(body_pane, dockList);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        rent_bike_btn.setOnMouseClicked(event -> {
            BarCodeScreen barcode;
            try {
                barcode = new BarCodeScreen(this.stage, Configs.FIRST_PATH);
                barcode.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        payment_btn.setOnMouseClicked(event -> {
            PaymentScreen payment;
            try {
                payment = new PaymentScreen(this.stage, Configs.THIRD_PATH);
                payment.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return_btn.setOnMouseClicked(event -> {
            ReturnScreen returnbike;
            try {
                returnbike = new ReturnScreen(this.stage, Configs.FIFTH_PATH);
                returnbike.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // view_bike_btn1.setOnMouseClicked(event -> {
        // DockDetailsScreen dockdetails;
        // try {
        // dockdetails = new DockDetailsScreen(this.stage, Configs.SIXTH_PATH);
        // dockdetails.show();

        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        // });

    }
}
