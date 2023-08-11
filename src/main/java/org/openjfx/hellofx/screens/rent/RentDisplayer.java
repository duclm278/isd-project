package org.openjfx.hellofx.screens.rent;

import java.util.HashMap;

import org.openjfx.hellofx.models.bike7.TypeOfBike;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class RentDisplayer {
    public RentDisplayer() {
    }

    public void displayPayRules(TypeOfBike bike, Label deposit_amount, ListView<String> rent_rule) {
        String[] rule = { "First 10 mins: free", "First 30 mins: " + bike.first30minAmount() + " đ",
                "After 30 mins: " + bike.after30minAmount() + "đ each 15 mins" };
        rent_rule.getItems().addAll(rule);
        deposit_amount.setText(Integer.toString(bike.depositAmount()) + " đ");
    }

    public void displayBikeDetails(HashMap<String, Object> bike_details, ListView<String> bike_info) {
        String[] resultArray = new String[bike_details.size()];
        int index = 0;

        for (String key : bike_details.keySet()) {
            Object value = bike_details.get(key);
            resultArray[index] = key + ": " + value;
            index++;
        }
        bike_info.getItems().addAll(resultArray);
    }

}
