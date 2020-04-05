package boundary;

import control.Customer;
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

public class Controller implements Initializable {
    private Customer customer = new Customer(1);

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
        Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("Item.fxml"));

                //give the items some effect

                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #0A0E3F");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #02030A");
                });
                pnItems.getChildren().add(nodes[i]);
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
            Label l = (Label)pnlOverview.lookup("#TotalOrders");
            l.setText("24");
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
                tf.setText(customer.getRest().getRestName());
                tf.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                    }
                });

                TextArea ta = (TextArea) pnlRestaurant.lookup("#RestIntro");

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
