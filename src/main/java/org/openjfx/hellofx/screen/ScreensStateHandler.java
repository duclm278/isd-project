package org.openjfx.hellofx.screen;

import java.io.IOException;
import java.util.HashMap;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreensStateHandler extends FXMLSceneLoader {
    protected final Stage stage;
    private Scene scene;
    public static HashMap<String, Object> state = new HashMap<>();

    public ScreensStateHandler(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
        this.stage = stage;
    }

    public void show() {
        this.scene = new Scene(this.root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void setState(String key, Object value) {
        ScreensStateHandler.state.put(key, value);
    }
}
