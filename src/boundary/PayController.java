package boundary;

import control.Customer;
import control.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class PayController implements Initializable {
    private Customer customer = Main.getCustomer();

    private String choice = "";

    @FXML
    private Button btnOK;

    @FXML
    private AnchorPane PayPnl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup groupPay = new ToggleGroup();
        RadioButton credit = (RadioButton) PayPnl.lookup("#credit");
        credit.setToggleGroup(groupPay);
        credit.setUserData("credit");
        RadioButton paypal = (RadioButton) PayPnl.lookup("#paypal");
        paypal.setToggleGroup(groupPay);
        paypal.setUserData("paypal");
        RadioButton stamps = (RadioButton) PayPnl.lookup("#stamps");
        stamps.setToggleGroup(groupPay);
        stamps.setUserData("stamps");
        Label notice = (Label) PayPnl.lookup("#notice");
        if(customer.getUser() == null || customer.viewUserStamps() - customer.viewUserUsedStamps() < 10){
            notice.setText("(Do not have enough stamps)");
            stamps.setDisable(true);
        }
        else{
            notice.setText("Use 10 stamps to pay ramens for free!");
            stamps.setDisable(false);
        }
        groupPay.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> changed,
                                Toggle oldVal, Toggle newVal) {
                choice = groupPay.getSelectedToggle().getUserData().toString();
            }
        });
        btnOK.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                customer.formOrder(choice);
                if(customer.getUser() != null){
                    if(choice == "stamps"){
                        customer.refreshUserWithStamps();
                    }
                    else{
                        customer.refreshUserWithoutStamps();
                    }
                }
            }
        });
    }
}

