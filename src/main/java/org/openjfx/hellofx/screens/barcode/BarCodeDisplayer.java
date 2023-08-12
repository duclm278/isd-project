package org.openjfx.hellofx.screens.barcode;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BarCodeDisplayer {
    public BarCodeDisplayer() {
    }

    public void displayErrorMessage(Text error_msg) {
        error_msg.setVisible(true);
        error_msg.setText("Invalid barcode");
    }
    public void displayBikeIsRented(Text error_msg) {
        error_msg.setVisible(true);
        error_msg.setText("Bike is already rented");
    }
}
