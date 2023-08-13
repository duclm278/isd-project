package org.openjfx.hellofx.screen.dockdetails;

import java.util.List;

import org.openjfx.hellofx.model.bike.Bike;
import org.openjfx.hellofx.model.dock.Dock;
import org.openjfx.hellofx.screen.home.DockPane;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DockDetailsDisplayer {
    Stage stage;

    public DockDetailsDisplayer(Stage stage) {
        this.stage = stage;
    }

    public void displayDockInfo(ListView<String> list_view2, ListView<String> list_view3, String name, String address,
            int remain_slot, int capacity, int walking_time, int numBikes) {
        list_view2.getItems().addAll("Dock's name:  " + name, "Address:  " + address,
                "Walking time:  " + Integer.toString(walking_time) + " minutes");
        list_view3.getItems().addAll("Capacity:  " + Integer.toString(capacity),
                "Available bikes:  " + Integer.toString(numBikes));
    }

    public void displayListOfBikes(ScrollPane body_pane, List<Bike> list_bikes) {
        GridPane contentGridPane = new GridPane();
        contentGridPane.setHgap(20); // Set horizontal gap between AnchorPanes
        contentGridPane.setVgap(20); // Set vertical gap between AnchorPanes
        contentGridPane.setPadding(new Insets(5));
        for (int i = 0; i < list_bikes.size(); i++) {
            String img_path = "E:/ITSS_Project/ITSS_Project/isd-project/src/main/resources/org/openjfx/hellofx/image/bike1.png";
            Bike bike = list_bikes.get(i);
            BikePane bikepane = new BikePane(bike.getType(), "034A65533", img_path, bike.getBattery().get(),
                    bike.getValue(),
                    this.stage);
            AnchorPane a = bikepane.createBikePane();

            int row = i / 3;
            int col = i % 3;
            contentGridPane.add(a, col, row);

        }

        body_pane.setContent(contentGridPane);
    }
}
