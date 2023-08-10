package view.screen.rent;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import entity.bike.Bike;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import utils.Configs;
import view.screen.ScreensStateHandler;
import view.screen.payment.PaymentScreen;

public class RentScreen extends ScreensStateHandler implements Initializable{
    Stage stage;

    String[] list_info;

    TypeOfBike bike = new StandardE_Bike();
    @FXML 
    private Button pay_now;

    @FXML
    private Label deposit_amount;
    
    @FXML
    private ListView<String> rent_rule;

    @FXML
    private ListView<String> bike_info;

    public RentScreen(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
        this.stage = stage;
        System.out.println("STATE:"+this.state);
        this.displayBikeDetails((HashMap<String, Object>) this.state.get("bike_details"));
        this.displayPayRules((HashMap<String, Object>) this.state.get("bike_details"));
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
            pay_now.setOnMouseClicked(event -> {
            PaymentScreen pay_screen;
            try {
                pay_screen = new PaymentScreen(this.stage, Configs.THIRD_PATH);
                pay_screen.show();
                
            }catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void displayBikeDetails(HashMap<String, Object> bike_details){
        String[] resultArray = new String[bike_details.size()];
        int index = 0;

        for (String key : bike_details.keySet()) {
            Object value = bike_details.get(key);
            resultArray[index] = key + ": " + value;
            index++;
        }
        this.list_info = resultArray;

        bike_info.getItems().addAll(this.list_info);
    }
    public void displayPayRules(HashMap<String, Object> bike_details){
        String type =  bike_details.get("type").toString();
        if(type.equals("1")){
            this.bike = new StandardBike();
        }
        if(type.equals("2")){
            this.bike = new StandardE_Bike();
        }
        if(type.equals("3")){
            this.bike = new TwinBike();
        }

        String [] rule = {"First 10 mins: free", "First 30 mins: "+this.bike.first30minAmount()+" đ", "After 30 mins: "+ this.bike.after30minAmount()+"đ each 15 mins"};
        rent_rule.getItems().addAll(rule);
        deposit_amount.setText(Integer.toString(bike.depositAmount())+" đ");
    }

}

interface TypeOfBike{
    public int depositAmount();
    public int first30minAmount();
    public int after30minAmount();
    public int calculateTotal(int time);
}

class StandardBike implements TypeOfBike{
    public int depositAmount(){
        return 400000;
    };
    public int first30minAmount(){
        return 10000;
    };
    public int after30minAmount(){
        return 3000;
    };
    public int calculateTotal(int time){
        if(time>30){
            return this.first30minAmount() + (int) Math.ceil((time-30)/15)*this.after30minAmount();
        }
        else if(time<10){
            return 0;
        }
        else{
            return this.first30minAmount();
        }
    };

}

class StandardE_Bike implements TypeOfBike{
    public int depositAmount(){
        return 700000;
    };
    public int first30minAmount(){
        return 15000;
    };
    public int after30minAmount(){
        return 4500;
    };
    public int calculateTotal(int time){
        if(time>30){
            return this.first30minAmount() + (int) Math.ceil((time-30)/15)*this.after30minAmount();
        }
        else if(time<10){
            return 0;
        }
        else{
            return this.first30minAmount();
        }
    };
}

class TwinBike implements TypeOfBike{
    public int depositAmount(){
        return 550000;
    };
    public int first30minAmount(){
        return 15000;
    };
    public int after30minAmount(){
        return 4500;
    };
    public int calculateTotal(int time){
        if(time>30){
            return this.first30minAmount() + (int) Math.ceil((time-30)/15)*this.after30minAmount();
        }
        else if(time<10){
            return 0;
        }
        else{
            return this.first30minAmount();
        }
    };
}