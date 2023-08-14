package org.openjfx.hellofx.screen.home;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.openjfx.hellofx.controller.DockController;
import org.openjfx.hellofx.screen.ScreensStateHandler;
import org.openjfx.hellofx.screen.barcode.BarCodeScreen;
import org.openjfx.hellofx.screen.payment.PaymentScreen;
import org.openjfx.hellofx.screen.returnbike.ReturnScreen;
import org.openjfx.hellofx.util.Configs;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
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
        // List<Dock> dockList = new ArrayList<>();
        // Dock dock1 = new Dock(new ObjectId(), "Hoan Kiem", "So 3 Hoan Kiem", 22, 0,
        // 0.0, 0.0);
        // Dock dock2 = new Dock(new ObjectId(), "Long Bien", "So 10 Nguyen Van Cu", 22,
        // 0, 0.0, 0.0);
        // Dock dock3 = new Dock(new ObjectId(), "Thanh Xuan", "So 2 Truong Chinh", 22,
        // 0, 0.0, 0.0);
        // dockList.add(dock1);
        // dockList.add(dock2);
        // dockList.add(dock3);
        DockController dockcontroller = new DockController();
        homedisplayer.displayListOfDocks(body_pane, dockcontroller);
        search_btn.setOnMouseClicked(event -> {
            String search_text = search_bar.getText();
            homedisplayer.displayListOfDocksByQuery(body_pane, dockcontroller, search_text);
        });
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
