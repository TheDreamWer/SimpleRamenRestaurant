package boundary;

import control.Customer;
import control.SaveRestInfo;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

import entities.*;

public class Controller implements Initializable {
    private Customer business = new Customer(1);

    @FXML
    private Pane pnlOrders;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSignout;

    @FXML
    private Button btnCustomers;

    @FXML
    private Pane pnlOverview;

    @FXML
    private Button btnOverview;

    @FXML
    private Pane pnlCustomer;

    @FXML
    private VBox pnItems;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnRestaurant;

    @FXML
    private Pane pnlRestaurant;

    @FXML
    private VBox rest;

    @FXML
    private Button btnMenus;

    @FXML
    private Pane pnlMenus;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Label totalOrders = (Label)pnlOverview.lookup("#TotalOrders");
        totalOrders.setText("" + business.getOrderList().getArraylist().size());

        Label totalAmount = (Label)pnlOverview.lookup("#TotalAmount");
        totalAmount.setText("" + business.getOrderList().getSumAmount());

        Label todayOrders = (Label)pnlOverview.lookup("#TodayOrders");
        todayOrders.setText("" + business.getOrderList().getArraylist().size());
        Node[] nodes = new Node[business.getOrderList().getArraylist().size()];
        int i = 0;
        for (i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("Item.fxml"));

                Parent p = (Parent)nodes[i];
                Label id = (Label) p.lookup("#ID");
                Label name = (Label) p.lookup("#UserName");
                Label time = (Label) p.lookup("#Time");
                Button active = (Button) p.lookup("#Active");
                id.setText("" + business.getOrderList().getArraylist().get(i).getOrderID());
                name.setText("" + business.getOrderList().getArraylist().get(i).getCode());
                time.setText("" + business.getOrderList().getArraylist().get(i).getGenerateTime());

                //give the items some effect
                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #0A0E3F");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #02030A");
                });
                pnItems.getChildren().add(nodes[i]);

                //System.out.println(customer.getOrderList().getArraylist().get(i).getOrderID());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnCustomers) {
            pnlCustomer.setStyle("-fx-background-color : #1620A1");
            pnlCustomer.toFront();
        }
        if (actionEvent.getSource() == btnMenus) {
            pnlMenus.setStyle("-fx-background-color : #53639F");
            pnlMenus.toFront();
        }
        if (actionEvent.getSource() == btnOverview) {
            pnlOverview.setStyle("-fx-background-color : #02030A");
            pnlOverview.toFront();
            //setOnAction
//            Label totalOrders = (Label)pnlOverview.lookup("#TotalOrders");
//            totalOrders.setText("" + customer.getOrderList().getArraylist().size());
//
//            Label totalAmount = (Label)pnlOverview.lookup("#TotalAmount");
//            totalAmount.setText("" + customer.getOrderList().getArraylist().size());
//
//            Label todayOrders = (Label)pnlOverview.lookup("#TodayOrders");
//            todayOrders.setText("" + customer.getOrderList().getArraylist().size());
        }
        if(actionEvent.getSource()==btnOrders)
        {
            pnlOrders.setStyle("-fx-background-color : #464F67");
            pnlOrders.toFront();

        }
        if(actionEvent.getSource()==btnRestaurant)
        {
            pnlRestaurant.setStyle("-fx-background-color : #464F67");
            pnlRestaurant.toFront();
            Node[] nodes = new Node[1];

            try {
                nodes[0] = FXMLLoader.load(getClass().getResource("Restaurant.fxml"));

                //nodes[0].setStyle("-fx-background-color : #3f5967");
                pnlRestaurant.getChildren().add(nodes[0]);

                TextField tf = (TextField) pnlRestaurant.lookup("#RestName");
                tf.setText(business.getRest().getRestName());
                tf.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        business.getRest().setRestName(tf.getText().trim());
                    }
                });

                ScrollPane sp = (ScrollPane) pnlRestaurant.lookup("#RestIntro");
                TextArea ta = (TextArea) sp.contentProperty().getValue();
                ta.setText(business.getRest().getRestIntro());

                Button ok = (Button) pnlRestaurant.lookup("#OK");
                ok.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        //System.out.println(ta.getText());
                        business.getRest().setRestIntro(ta.getText());
                        new SaveRestInfo(business.getRest());
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(actionEvent.getSource()==btnMenus)
        {

        }
    }
}
