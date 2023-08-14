package org.openjfx.hellofx.screen.payment;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.openjfx.hellofx.model.card.CreditCard;
import org.openjfx.hellofx.screen.ScreensStateHandler;
import org.openjfx.hellofx.screen.home.HomeScreen;
import org.openjfx.hellofx.util.Configs;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class PaymentScreen extends ScreensStateHandler implements Initializable {
    Stage stage;
    private int amount;
    @FXML
    private Button confirm_cardInfo;
    @FXML
    private ImageView home_btn;
    @FXML
    private TextField cardHolderNameInput;
    @FXML
    private TextField cardNumberInput;
    @FXML
    private TextField CVVInput;
    @FXML
    private TextField exprMonthInput;
    @FXML
    private TextField exprYearInput;

    public PaymentScreen(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
        this.stage = stage;
    }

    public PaymentScreen(Stage stage, String screenPath, int amount) throws IOException {
        super(stage, screenPath);
        this.stage = stage;
        this.amount = amount;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        confirm_cardInfo.setOnMouseClicked(event -> {
            ConfirmPaymentScreen confirm_payment_screen;
            String cardNumber = cardNumberInput.getText();
            String cardHolderName = cardHolderNameInput.getText();
            String cvv = CVVInput.getText();
            String exprDate = exprMonthInput.getText() + "/" + exprYearInput.getText();

            CreditCard creditCard = new CreditCard(cardNumber, cardHolderName, cvv, exprDate);
            try {
                confirm_payment_screen = new ConfirmPaymentScreen(this.stage, Configs.SEVENTH_PATH);
                confirm_payment_screen.setCreditCard(creditCard);
                confirm_payment_screen.display();
                confirm_payment_screen.show();
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
}
