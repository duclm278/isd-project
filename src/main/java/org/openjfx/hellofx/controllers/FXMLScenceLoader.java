package org.openjfx.hellofx.controllers;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.openjfx.hellofx.App;
import org.openjfx.hellofx.views.BarCodeScreen;

public class FXMLScenceLoader {
    public Parent root;
    protected AnchorPane content;
    protected FXMLLoader loader;

    public FXMLScenceLoader(Stage stage, String screenPath) throws IOException {
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
