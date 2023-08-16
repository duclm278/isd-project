package org.openjfx.hellofx.screen.returnbike;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.text.Text;
import org.openjfx.hellofx.controller.TransactionController;
import org.openjfx.hellofx.model.transaction.Transaction;
import org.openjfx.hellofx.screen.ScreensStateHandler;
import org.openjfx.hellofx.screen.home.HomeScreen;
import org.openjfx.hellofx.screen.payment.ResultScreen;
import org.openjfx.hellofx.util.Configs;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ReturnScreen extends ScreensStateHandler implements Initializable {
    Stage stage;
    @FXML
    private ImageView home_btn;
    @FXML
    private Text cardHolderName;
    @FXML
    private Text cardNumber;
    @FXML
    private Text rentTime;
    @FXML
    private Text deposit;
    @FXML
    private Text exprDate;
    @FXML
    private Button submitBtn;
    @FXML
    private Text command;
    @FXML
    private Text amount;
    public ReturnScreen(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
        this.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        submitBtn.setOnMouseClicked(event -> {
            TransactionController transactionController = new TransactionController();
            Transaction transaction = new Transaction(
                    null,
                    this.state.get("command")+"",
                    this.state.get("cardNumber")+"",
                    this.state.get("cardHolderName")+"",
                    this.state.get("cvv")+"",
                    this.state.get("exprDate")+"",
                    "rent a bike " + this.state.get("command"),
                    (int) this.state.get("amount"));
            transaction.display();
            int result = transactionController.progressTransaction(transaction);
            System.out.println(result);
            ResultScreen resultScreen;
            try {
                resultScreen = new ResultScreen(this.stage, Configs.EIGHTH_PATH);
                resultScreen.display(result, "home");
                resultScreen.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        home_btn.setOnMouseClicked(event -> {
            HomeScreen home;
            try {
                home = new HomeScreen(this.stage, Configs.HOME_PATH);
                home.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    public void display(){
        cardHolderName.setText(this.state.get("cardHolderName")+"");
        cardNumber.setText(this.state.get("cardNumber")+"");
        exprDate.setText(this.state.get("exprDate")+"");
        command.setText(this.state.get("command")+"");
        amount.setText(this.state.get("amount")+"");
        rentTime.setText(this.state.get("rent_time")+"");
        deposit.setText(this.state.get("deposit")+"");
    }

}
