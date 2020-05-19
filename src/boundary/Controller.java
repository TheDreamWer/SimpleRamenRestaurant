package boundary;

import control.Business;
import control.Main;
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
    private Business business = Main.getBusiness();
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
        setPnlOverview();
    }
    public void setPnlOverview(){
        // total orders
        Label totalOrders = (Label) pnlOverview.lookup("#totalOrder");
        totalOrders.setText(business.viewTotalOrder() + "");

        //total amount
        Label totalAmount = (Label) pnlOverview.lookup("#totalAmount");
        totalAmount.setText(business.viewTotalAmount() + "");

        //today order
        Label todayOrder = (Label) pnlOverview.lookup("#todayOrder");
        todayOrder.setText(business.viewTodayOrder() + "");

        //soup_tonkotsu
        Label soupT = (Label) pnlOverview.lookup("#soup_t");
        soupT.setText(business.getSoupCount("Tonkotsu") + "");

        //soup_shoyu
        Label soupShoyu = (Label) pnlOverview.lookup("#soup_shoyu");
        soupShoyu.setText(business.getSoupCount("Shoyu") + "");

        //soup_shio
        Label soupShio = (Label) pnlOverview.lookup("#soup_shio");
        soupShio.setText(business.getSoupCount("Shio") + "");

        //Noodle soft
        Label soft = (Label) pnlOverview.lookup("#soft");
        soft.setText(business.getNoodleCount("Soft") + "");

        //Noodle medium
        Label medium = (Label) pnlOverview.lookup("#medium");
        medium.setText(business.getNoodleCount("Medium") + "");

        //Noodle firm
        Label firm = (Label) pnlOverview.lookup("#firm");
        firm.setText(business.getNoodleCount("Firm") + "");

        //Nori
        Label Nori = (Label) pnlOverview.lookup("#Nori");
        Nori.setText(business.getNoriCount() + "");

        //Chashu
        Label Chashu = (Label) pnlOverview.lookup("#Chashu");
        Chashu.setText(business.getChashuCount() + "");

        //egg
        Label egg = (Label) pnlOverview.lookup("#egg");
        egg.setText(business.getEggCount() + "");

        //bamboo
        Label bamboo = (Label) pnlOverview.lookup("#bamboo");
        bamboo.setText(business.getBambooCount() + "");

        //onion_level
        Label onionLevel = (Label) pnlOverview.lookup("#onion_level");
        onionLevel.setText(business.getPopularOnion());

        //spiciness_level
        Label spicinessLevel = (Label) pnlOverview.lookup("#spiciness_level");
        spicinessLevel.setText(business.getPopularSpic());
    }
    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnCustomers) {
            pnlCustomer.setStyle("-fx-background-color : #1620A1");
            pnlCustomer.toFront();
            Node[] nodes = new Node[1];
            try {
                nodes[0] = FXMLLoader.load(getClass().getResource("Customer.fxml"));
                //nodes[0].setStyle("-fx-background-color : #3f5967");
                pnlCustomer.getChildren().add(nodes[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (actionEvent.getSource() == btnMenus) {
            pnlMenus.setStyle("-fx-background-color : #53639F");
            pnlMenus.toFront();
            Node[] nodes = new Node[1];
            try {
                nodes[0] = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                //nodes[0].setStyle("-fx-background-color : #3f5967");
                pnlMenus.getChildren().add(nodes[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (actionEvent.getSource() == btnOverview) {
            pnlOverview.setStyle("-fx-background-color : #02030A");
            pnlOverview.toFront();
            setPnlOverview();
        }
        if(actionEvent.getSource()==btnOrders)
        {
            pnlOrders.setStyle("-fx-background-color : #464F67");
            pnlOrders.toFront();
            Node[] nodes = new Node[1];
            try {
                nodes[0] = FXMLLoader.load(getClass().getResource("Order.fxml"));
                //nodes[0].setStyle("-fx-background-color : #3f5967");
                pnlOrders.getChildren().add(nodes[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(actionEvent.getSource()==btnSignout)
        {
            Main.getBusiness().saveRestInfo();
            Main.getPrimaryStage().close();
        }
    }
}
