package org.openjfx.hellofx.screens.home;

import java.io.IOException;

import org.openjfx.hellofx.screens.dockdetails.DockDetailsScreen;
import org.openjfx.hellofx.utils.Configs;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DockPane {
    private String name, dock_img, address;
    private int capacity;
    private Stage stage;
    private Button button1;

    public DockPane(String name, String dock_img, int capacity, String address, Stage stage) {
        this.name = name;
        this.dock_img = dock_img;
        this.capacity = capacity;
        this.address = address;
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
        listView.getItems().addAll("Address:  " + this.address, "Available bikes:  " + Integer.toString(this.capacity),
                "Empty docks:  " + Integer.toString(50 - this.capacity));

        // ImageView imageView = new ImageView(new Image(this.dock_img)); // Thay thế
        // bằng đường dẫn đến hình ảnh thực tế

        // Đặt vị trí và kích thước cho các thành phần
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
        // Thêm các thành phần vào AnchorPane
        // anchorPane.getChildren().addAll(button, label, listView, imageView);
        anchorPane.getChildren().addAll(button, label, listView);
        return anchorPane;
    }

    public void addListenerToViewButton(Button button) {
        button.setOnMouseClicked(event -> {
            DockDetailsScreen dockdetails;
            try {
                dockdetails = new DockDetailsScreen(this.stage, Configs.SIXTH_PATH);
                dockdetails.show();
                dockdetails.setDock(this.name, this.capacity, this.address);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
