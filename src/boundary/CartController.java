package boundary;

import control.Customer;
import control.SaveRestInfo;
import entities.Order;
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
import entities.*;

public class CartController implements Initializable {
    private Customer customer;

    @FXML
    private Button pay; // 还没写


    public CartController(Customer customer){
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
        Node[] nodes = new Node[customer.getDraft().getRamenList().size()];
        int i = 0;
        Order draft  = this.customer.getDraft();
        for (i = 0; i < nodes.length; i++) {
            Parent p = (Parent)nodes[i];
            Ramen ramen  = (Ramen) draft.getRamenList().get(i);
            
            // Set the txture of the Amount label
            Label amount1 = (Label) p.lookup("#Amount" + i);
            double amount = 9.9;
            amount += ramen.getExtra_nori();
            amount += ramen.getExtra_boiled_egg();
            amount += ramen.getExtra_chashu() * 2.;
            amount += ramen.getBamboo_shoots();
            //amount.setText(amount);

            // Set the ramen number and the button
            Label ramenNum = (Label) p.lookup("#RamenNum" + i);// ID自取
            //ramenNum.setText(ramen.getNum());//----------------------------待定---------------------------------------
            Button plusButton = (Button) p.lookup("#PlusButton" + i); //ID自取
            Button subtractButton = (Button) p.lookup("#SubtractButton" + i); //ID自取
            plusButton.setText("+");
            subtractButton.setText("-");
        }

        // Set the total amount of the draft
        Parent p = (Parent)nodes[i];
        Label totalAmount =  (Label) p.lookup("#TotalAmount");
        totalAmount.setText("Amount: " + customer.getDraft());

    }

    public Customer handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == pay) {
            return this.customer;
        }
        return this.customer;
    }
}

