package org.openjfx.hellofx.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BarCodeScreen {
    public BarCodeScreen(){}
    public void displayErrorMessage(Text error_msg){
        error_msg.setVisible(true);
    }
}
