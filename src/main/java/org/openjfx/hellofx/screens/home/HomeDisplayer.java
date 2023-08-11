package org.openjfx.hellofx.screens.home;

import java.io.IOException;
import java.util.List;

import org.openjfx.hellofx.models.dock.Dock;
import org.openjfx.hellofx.screens.dockdetails.DockDetailsScreen;
import org.openjfx.hellofx.utils.Configs;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HomeDisplayer {
    Stage stage;

    public HomeDisplayer(Stage stage) {
        this.stage = stage;
    }

    public void displayListOfDocks(ScrollPane body_pane, List<Dock> list_dock) {
        GridPane contentGridPane = new GridPane();
        contentGridPane.setHgap(20); // Set horizontal gap between AnchorPanes
        contentGridPane.setVgap(20); // Set vertical gap between AnchorPanes
        contentGridPane.setPadding(new Insets(5));
        for (int i = 0; i < list_dock.size(); i++) {
            String img_path = "/home/duc/Pictures/Wallpapers/09.jpg";
            Dock dock = list_dock.get(i);
            DockPane dockpane = new DockPane(dock.getName(), img_path, dock.getCapacity(), dock.getAddress(),
                    this.stage);
            AnchorPane a = dockpane.createDockPane();

            int row = i / 2;
            int col = i % 2;
            contentGridPane.add(a, col, row);

        }

        body_pane.setContent(contentGridPane);
    }

}
