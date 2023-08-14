package org.openjfx.hellofx.screen.home;

import java.io.IOException;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.screen.dockdetails.DockDetailsScreen;
import org.openjfx.hellofx.util.Configs;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
// import javafx.scene.image.Image;
// import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DockPane {
    private String name, dock_img, address;
    private int capacity, numBikes;
    private Stage stage;
    private ObjectId dock_id;

    public DockPane(String name, String dock_img, int capacity, String address, Stage stage, ObjectId dock_id,
            int numBikes) {
        this.name = name;
        this.dock_img = dock_img;
        this.capacity = capacity;
        this.numBikes = numBikes;
        this.address = address;
        this.dock_id = dock_id;
        this.stage = stage;
    }

    public AnchorPane createDockPane() {
        AnchorPane anchorPane = new AnchorPane();

        Button button = new Button("Button");
        button.setText("View");
        this.addListenerToViewButton(button);
        Label label = new Label("Label");
        label.setText(this.name);
        ListView<String> listView = new ListView<>();
        listView.getItems().addAll("Address:  " + this.address, "Available bikes:  " + Integer.toString(this.numBikes),
                "Capacity:  " + Integer.toString(this.capacity));

        // ImageView imageView = new ImageView(new Image(this.dock_img));

        AnchorPane.setTopAnchor(button, 5.0);
        AnchorPane.setRightAnchor(button, 25.0);

        AnchorPane.setTopAnchor(label, 5.0);
        AnchorPane.setLeftAnchor(label, 20.0);

        AnchorPane.setTopAnchor(listView, 31.0);
        AnchorPane.setLeftAnchor(listView, 2.0);
        // AnchorPane.setRightAnchor(listView, 20.0);
        // AnchorPane.setBottomAnchor(listView, 100.0);

        // AnchorPane.setBottomAnchor(imageView, 10.0);
        // AnchorPane.setRightAnchor(imageView, 5.0);

        listView.setPrefWidth(157.0);
        listView.setPrefHeight(96.0);
        listView.setStyle("-fx-border-color: black; ");

        // imageView.setFitWidth(110.0);
        // imageView.setFitHeight(78.0);
        // imageView.setPickOnBounds(true);

        anchorPane.setPrefWidth(281.0);
        anchorPane.setPrefHeight(131.0);
        anchorPane.setStyle("-fx-border-color: blue; -fx-border-width: 2px;");
        // anchorPane.getChildren().addAll(button, label, listView, imageView);
        anchorPane.getChildren().addAll(button, label, listView);
        return anchorPane;
    }

    public void addListenerToViewButton(Button button) {
        button.setOnMouseClicked(event -> {
            DockDetailsScreen dockDetails;
            try {
                dockDetails = new DockDetailsScreen(this.stage, Configs.SIXTH_PATH);
                dockDetails.show();
                dockDetails.setDock(this.name, this.capacity, this.address, this.dock_id, this.numBikes);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
