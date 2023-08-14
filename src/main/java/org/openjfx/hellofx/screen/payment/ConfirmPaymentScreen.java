package org.openjfx.hellofx.screen.payment;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import org.openjfx.hellofx.controller.transaction.TransactionController;
import org.openjfx.hellofx.model.card.CreditCard;
import org.openjfx.hellofx.model.transaction.Transaction;
import org.openjfx.hellofx.screen.ScreensStateHandler;
import org.openjfx.hellofx.screen.home.HomeScreen;
import org.openjfx.hellofx.util.Configs;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConfirmPaymentScreen extends ScreensStateHandler implements Initializable {
    Stage stage;
    private CreditCard creditCard;
    @FXML
    private Button confirm_bill_btn;
    @FXML
    private ImageView home_btn;
    @FXML
    private Text cardHolderName;
    @FXML
    private Text cardNumber;
    @FXML
    private Text cvv;
    @FXML
    private Text exprDate;
    @FXML
    private Text totalBill;

    public ConfirmPaymentScreen(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
        this.stage = stage;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        confirm_bill_btn.setOnMouseClicked(event -> {
            String command = (String) this.state.get("command");
            int deposit = (int) this.state.get("deposit");

            TransactionController transactionController = new TransactionController();
            Transaction transaction = new Transaction(
                    null,
                    command,
                    this.creditCard.getCardNumber(),
                    this.creditCard.getCardHolderName(),
                    this.creditCard.getCvv(),
                    this.creditCard.getExprDate(),
                    "rent a bike " + command,
                    deposit);
            transaction.display();
            int result = transactionController.progressTransaction(transaction);
            System.out.println(result);
            ResultScreen resultScreen;
            try {
                resultScreen = new ResultScreen(this.stage, Configs.EIGHTH_PATH);
                resultScreen.display(result);
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

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public void display(CreditCard creditCard) {
        cardHolderName.setText(creditCard.getCardHolderName());
        cardNumber.setText(creditCard.getCardNumber());
        cvv.setText(creditCard.getCvv());
        exprDate.setText(creditCard.getExprDate());
    }

    public void display() {
        cardHolderName.setText(this.creditCard.getCardHolderName());
        cardNumber.setText(this.creditCard.getCardNumber());
        cvv.setText(this.creditCard.getCvv());
        exprDate.setText(this.creditCard.getExprDate());
        totalBill.setText(this.state.get("amount") + "");
    }

}
