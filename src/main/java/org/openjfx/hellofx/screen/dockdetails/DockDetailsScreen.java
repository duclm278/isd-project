package org.openjfx.hellofx.screen.dockdetails;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.controller.DockingController;
import org.openjfx.hellofx.model.bike.Bike;
import org.openjfx.hellofx.model.dock.Dock;
import org.openjfx.hellofx.screen.ScreensStateHandler;
import org.openjfx.hellofx.screen.barcode.BarCodeScreen;
import org.openjfx.hellofx.screen.home.HomeDisplayer;
import org.openjfx.hellofx.screen.home.HomeScreen;
import org.openjfx.hellofx.util.Configs;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class DockDetailsScreen extends ScreensStateHandler implements Initializable {
    Stage stage;
    @FXML
    private ListView<String> list_view2, list_view3;
    @FXML
    private ScrollPane scroll_pane2;
    @FXML
    private Button rent_btn;

    private DockDetailsDisplayer dockdisplayer;
    private String name;
    private int capacity, numBikes;
    private String address;
    public Dock dock;

    public DockDetailsScreen(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
        this.stage = stage;

        this.dockdisplayer = new DockDetailsDisplayer(this.stage);
        // List<Bike> bikeList = new ArrayList<>();
        // // Bike bike1 = new Bike("Xe dap don thuong", "34A 65B1423", 90, 1000000);
        // // Bike bike2 = new Bike("Xe dap don", "34A 65B1423", 90, 1000000);
        // // Bike bike3 = new Bike("Xe dap don", "34A 65B1423", 90, 1000000);
        // Bike bike1 = new Bike(new ObjectId(), "34A 65B1423", "Xe dap don thuong",
        // Optional.of(90), Optional.of(1000000),
        // 1000000, Optional.of(0.0), Optional.of(0.0));
        // Bike bike2 = new Bike(new ObjectId(), "34A 65B1423", "Xe dap don",
        // Optional.of(90), Optional.of(1000000),
        // 1000000,
        // Optional.of(0.0), Optional.of(0.0));
        // Bike bike3 = new Bike(new ObjectId(), "34A 65B1423", "Xe dap don",
        // Optional.of(90), Optional.of(1000000),
        // 1000000,
        // Optional.of(0.0), Optional.of(0.0));

        // bikeList.add(bike1);
        // bikeList.add(bike2);
        // bikeList.add(bike3);

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

        rent_btn.setOnMouseClicked(event -> {
            BarCodeScreen barcode;
            try {
                barcode = new BarCodeScreen(this.stage, Configs.FIRST_PATH);
                barcode.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void setDock(String name, int capacity, String address, ObjectId id, int numBikes) {
        this.name = name;
        this.capacity = capacity;
        this.address = address;
        this.numBikes = numBikes;
        DockDetailsDisplayer dockdisplayer = new DockDetailsDisplayer(this.stage);
        dockdisplayer.displayDockInfo(list_view2, list_view3, this.name, this.address, 50 - this.capacity,
                this.capacity, 20, this.numBikes);

        DockingController dockCon = new DockingController();
        List<Bike> bikeList = dockCon.findBikesByDockId(id);
        this.dockdisplayer.displayListOfBikes(scroll_pane2, bikeList);
    }

}