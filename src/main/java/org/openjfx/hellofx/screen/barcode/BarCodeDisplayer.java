package org.openjfx.hellofx.screen.barcode;

import javafx.scene.text.Text;

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
