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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CartController implements Initializable {
    private Customer customer;

    @FXML
    private Button pay; // 还没写

    @FXML
    private Label totalAmount;

    @FXML
    private ArrayList<Button> plusButton;

    @FXML
    private ArrayList<Button> subtractButton;

    @FXML
    private ArrayList<Label> ramenNumLabel;


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
            Parent p = (Parent)nodes[i]; //展示所有拉面的面板
            Ramen ramen  = (Ramen) draft.getRamenList().get(i);
            
            // Set the txture of the Amount label
            Label amount = (Label) p.lookup("#Amount" + i);
            float ramenAmount = 9.9;
            ramenAmount += ramen.getExtra_nori();
            ramenAmount += ramen.getExtra_boiled_egg();
            ramenAmount += ramen.getExtra_chashu() * 2.;
            ramenAmount += ramen.getBamboo_shoots();
            amount.setText(ramenAmount);

            // Set the ramen number and the button
            Label ramenNum = (Label) p.lookup("#RamenNum" + i);// ID自取
            ramenNum.setText(ramen.getNum());//
            Button plusButton = (Button) p.lookup("#PlusButton" + i) //ID自取
            Button subtractButton = (Button) p.lookup("#SubtractButton" + i) //ID自取
            Label ramenNumLabel = (Label) p.lookup("#RamenNumLabel" + i) //ID自取
            this.plusButton.add(plusButton);
            this.subtractButton.add(subtractButton);
            this.ramenNumLabel.add(ramenNumLabel);
        }

        // Set the total amount of the draft
        Parent p = (Parent)nodes; //最大的那个面板
        totalAmount =  (Label) p.lookup("#TotalAmount");
        totalAmount.setText("Amount: " + customer.getDraft().getOrderAmount());
    }

    public Customer handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == pay) {
            return this.customer;
        }

        // 点击加减号（需要除触发修改订单总价格）
        if (this.plusButton.Contains(actionEvent.getSource())){
            int index = this.plusButton.indexOf(actionEvent.getSource());
            Parent p = (Parent)nodes[index]; // 单个拉面的pane
            int ramenNum = ((Ramen) customer.getDraft().getRamenList().get(i)).getNum();
            ((Ramen) customer.getDraft().getRamenList().get(i)).setNum(ramenNum+1);
            this.updateTotalAmount();
        }
        if (this.subtractButton.Contains(actionEvent.getSource())){
            int index = this.plusButton.indexOf(actionEvent.getSource());
            Parent p = (Parent)nodes[index]; // 单个拉面的pane
            int ramenNum = ((Ramen) customer.getDraft().getRamenList().get(i)).getNum();
            ((Ramen) customer.getDraft().getRamenList().get(i)).setNum(ramenNum-1);
            this.updateTotalAmount();
        }
    }

    public void updateTotalAmount(){
        FillOrderInfo fillOrderInfo = new FillOrderInfo();
        fillOrderInfo.setOrder(this.customer.getDraft());
        float ramentAmount = fillOrderInfo.calcOrderAmount(fillOrderInfo.getOrder.getRamenList());
        fillOrderInfo.getOrder().setOrderAmount(ramenAmount);
        this.customer.setDraft(fillOrderInfo.getOrder());

        Parent p = (Parent)nodes; //最大的那个面板
        totalAmount =  (Label) p.lookup("#TotalAmount");
        totalAmount.setText("Amount: " + customer.getDraft().getOrderAmount());
    }
}

