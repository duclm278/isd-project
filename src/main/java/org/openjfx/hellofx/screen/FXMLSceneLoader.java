package org.openjfx.hellofx.screen;

import java.io.IOException;

import org.openjfx.hellofx.App;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLSceneLoader {
    public Parent root;
    protected AnchorPane content;
    protected FXMLLoader loader;

    public FXMLSceneLoader(Stage stage, String screenPath) throws IOException {
        this.loader = new FXMLLoader();
        this.loader.setController(this);
        this.loader.setLocation(App.class.getResource(screenPath));
        this.root = loader.load();
    }

    public Parent getLoader() {
        return this.root;
    }

    public AnchorPane getContent() {
        return this.content;
    }
}
