package org.openjfx.hellofx.screen.rent;

import java.util.Objects;

import org.openjfx.hellofx.model.bike.Bike;
import org.openjfx.hellofx.model.policy.TypeOfBike;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class RentDisplayer {
    public RentDisplayer() {
    }

    public void displayPayRules(TypeOfBike bike, Label deposit_amount, ListView<String> rent_rule) {
        String[] rule = { "First 10 mins: free", "First 30 mins: " + bike.first30minAmount() + "đ",
                "After 30 mins: " + bike.after30minAmount() + "đ each 15 mins" };
        rent_rule.getItems().addAll(rule);
        deposit_amount.setText(Integer.toString(bike.depositAmount()) + "đ");
    }

    public void displayBikeDetails(Bike bike, ListView<String> bike_info) {
        int battery;
        try {
            battery = bike.getBattery().get();
        } catch (Exception e) {
            battery = -1;
        }

        String batteryString = battery == -1 ? "No battery" : battery + "%";
        bike_info.getItems().addAll("Barcode: " + bike.getBarcode(), "Battery: " + batteryString,
                "Type: " + bike.getType());
    }
}
