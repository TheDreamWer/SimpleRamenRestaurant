package boundary;

import control.Customer;
import control.SaveRestInfo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PaymentController implements Initializable {
    private Customer customer;

    //private RadioButton[3] payment;// 还没有定义

    private Button finish;

    public PaymentController(Customer customer){
        this.customer = customer;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    public Customer getCustomer() {
        return customer;
    }


    //    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


//    public void handleClicks(ActionEvent actionEvent) {
//        if (actionEvent.getSource() == payment[0]) {
//            String paymentString = payment[0].getSource();
//            this.customer.getDraft().setPaymentMethod();
//        }
//        if (actionEvent.getSource() == payment[1]) {
//            String paymentString = payment[1].getSource();
//            this.customer.getDraft().setPaymentMethod();
//        }
//        if (actionEvent.getSource() == payment[2]) {
//            String paymentString = payment[2].getSource();
//            this.customer.getDraft().setPaymentMethod();
//        }
//        if (actionEvent.getSource() == finish) {
//            this.customer.formOrder();
//        }
//
//
//    }
}
