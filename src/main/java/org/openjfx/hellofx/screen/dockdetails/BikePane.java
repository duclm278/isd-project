package org.openjfx.hellofx.screen.dockdetails;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BikePane {
    private String type, barcode, bike_img;
    private int battery, timeLeft, price;
    Stage stage;

    public BikePane(String type, String license_plates, String bike_img, int battery, int price, Stage stage) {
        this.type = type;
        this.barcode = license_plates;
        this.battery = battery;
        this.price = price;
        this.bike_img = bike_img;
        this.stage = stage;
    }

    public AnchorPane createBikePane() {
        AnchorPane anchorPane = new AnchorPane();

        Label label = new Label("Label");
        label.setText(this.barcode);
        ListView<String> listView = new ListView<>();
        listView.getItems().addAll("Bike type:  " + this.type, "Price:  " + Integer.toString(this.price),
                this.battery >= 0 ? "Remain battery:  " + Integer.toString(this.battery) + "%" : "No battery");

        ImageView imageView = new ImageView(new Image(this.bike_img));

        AnchorPane.setTopAnchor(label, 5.0);
        AnchorPane.setLeftAnchor(label, 40.0);

        AnchorPane.setBottomAnchor(listView, 0.0);
        AnchorPane.setLeftAnchor(listView, 5.0);
        // AnchorPane.setRightAnchor(listView, 20.0);
        // AnchorPane.setBottomAnchor(listView, 100.0);

        AnchorPane.setTopAnchor(imageView, 28.0);
        AnchorPane.setLeftAnchor(imageView, 30.0);

        listView.setPrefWidth(140.0);
        listView.setPrefHeight(90.0);
        listView.setStyle("-fx-border-color: black; ");

        imageView.setFitWidth(80.0);
        imageView.setFitHeight(60.0);
        imageView.setPickOnBounds(true);

        anchorPane.setPrefWidth(150.0);
        anchorPane.setPrefHeight(200.0);
        anchorPane.setStyle("-fx-border-color: blue; -fx-border-width: 2px;");
        anchorPane.getChildren().addAll(label, listView, imageView);
        return anchorPane;
    }
}
