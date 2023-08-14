package org.openjfx.hellofx.screen.home;

import java.util.List;

import org.openjfx.hellofx.controller.DockController;
import org.openjfx.hellofx.model.dock.Dock;

import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomeDisplayer {
    Stage stage;
    GridPane contentGridPane;

    public HomeDisplayer(Stage stage) {
        this.stage = stage;
    }

    public void displayListOfDocks(ScrollPane body_pane, DockController dockcontroller) {
        List<Dock> list_dock = dockcontroller.find();

        body_pane.setContent(null);

        Text query_text = new Text();
        query_text.setText("Search for All");
        Text result_text = new Text();
        result_text.setText(Integer.toString(list_dock.size()) + " results");

        contentGridPane = new GridPane();
        contentGridPane.setHgap(20); // Set horizontal gap between AnchorPanes
        contentGridPane.setVgap(20); // Set vertical gap between AnchorPanes
        contentGridPane.setPadding(new Insets(5));
        for (int i = 0; i < list_dock.size(); i++) {
            String img_path = "/home/duc/Pictures/Wallpapers/09.jpg";
            Dock dock = list_dock.get(i);
            DockPane dockpane = new DockPane(dock.getName(), img_path, dock.getCapacity(), dock.getAddress(),
                    this.stage, dock.id, dock.getNumBikes());
            AnchorPane a = dockpane.createDockPane();

            int row = i / 2;
            int col = i % 2;
            contentGridPane.add(a, col, row);

        }

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(query_text, result_text, contentGridPane);
        AnchorPane.setTopAnchor(query_text, 2.0);
        AnchorPane.setLeftAnchor(query_text, 5.0);
        AnchorPane.setTopAnchor(result_text, 17.0);
        AnchorPane.setLeftAnchor(result_text, 5.0);
        AnchorPane.setTopAnchor(contentGridPane, 40.0);
        body_pane.setContent(anchorPane);
    }

    public void displayListOfDocksByQuery(ScrollPane body_pane, DockController dockcontroller, String query) {
        List<Dock> list_dock = dockcontroller.findByNameOrAddress(query);
        body_pane.setContent(null);

        Text query_text = new Text();
        query_text.setText("Search for " + query);
        Text result_text = new Text();
        result_text.setText(Integer.toString(list_dock.size()) + " results");

        contentGridPane = new GridPane();
        contentGridPane.setHgap(20); // Set horizontal gap between AnchorPanes
        contentGridPane.setVgap(20); // Set vertical gap between AnchorPanes
        contentGridPane.setPadding(new Insets(5));
        for (int i = 0; i < list_dock.size(); i++) {
            String img_path = "/home/duc/Pictures/Wallpapers/09.jpg";
            Dock dock = list_dock.get(i);
            DockPane dockpane = new DockPane(dock.getName(), img_path, dock.getCapacity(), dock.getAddress(),
                    this.stage, dock.id, dock.getNumBikes());
            AnchorPane a = dockpane.createDockPane();

            int row = i / 2;
            int col = i % 2;
            contentGridPane.add(a, col, row);

        }
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(query_text, result_text, contentGridPane);
        AnchorPane.setTopAnchor(query_text, 2.0);
        AnchorPane.setLeftAnchor(query_text, 5.0);
        AnchorPane.setTopAnchor(result_text, 17.0);
        AnchorPane.setLeftAnchor(result_text, 5.0);
        AnchorPane.setTopAnchor(contentGridPane, 40.0);
        body_pane.setContent(anchorPane);
    }

}
