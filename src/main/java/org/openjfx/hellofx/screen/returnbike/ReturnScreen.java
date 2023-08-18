package org.openjfx.hellofx.screen.returnbike;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import org.openjfx.hellofx.controller.DockController;
import org.openjfx.hellofx.controller.RentingController;
import org.openjfx.hellofx.controller.TransactionController;
import org.openjfx.hellofx.model.dock.Dock;
import org.openjfx.hellofx.model.transaction.Transaction;
import org.openjfx.hellofx.screen.ScreensStateHandler;
import org.openjfx.hellofx.screen.home.HomeScreen;
import org.openjfx.hellofx.screen.payment.ResultScreen;
import org.openjfx.hellofx.screen.payment.ReturnBikePaymentScreen;
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
    private Text amount, choosedDock;
    @FXML
    private ListView listDock;
    @FXML
    private Button chooseDockBtn, viewBillBtn;
    String selectedDockID;
    public ReturnScreen(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
        this.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        submitBtn.setVisible(false);
        viewBillBtn.setVisible(false);
        displayListOfDocks();
        listDock.setVisible(false);
        submitBtn.setOnMouseClicked(event -> {
            this.setState("Dock name", choosedDock.getText());
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
            ReturnBikePaymentScreen resultScreen;
            try {
                resultScreen = new ReturnBikePaymentScreen(this.stage, Configs.EIGHTH_PATH);
                resultScreen.display(result);
                resultScreen.show();

                new RentingController().rentBike(selectedDockID);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        chooseDockBtn.setOnMouseClicked(event -> {
            listDock.setVisible(true);
            chooseDockBtn.setVisible(false);
            viewBillBtn.setVisible(true);
        });
        viewBillBtn.setOnMouseClicked(event -> {
            viewBillBtn.setVisible(false);
            chooseDockBtn.setVisible(true);
            listDock.setVisible(false);
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

    public void displayListOfDocks(){
        DockController dockController = new DockController();
        List<Dock> docks = dockController.find();
        for(Dock dock : docks) {
            if(dock.getCapacity() - dock.getNumBikes() > 0){
                listDock.getItems().add(dock.getName());
            }
        }
        listDock.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String temp = listDock.getSelectionModel().getSelectedItems().toString();
                for(Dock dock : docks) {
                    if(temp.equals(dock.getName())){
                        selectedDockID = dock.getId().toString();
                        break;
                    };
                }
                choosedDock.setText(temp);
                if(submitBtn.isVisible() == false){
                    submitBtn.setVisible(true);
                }

            }
        });
    }
}
