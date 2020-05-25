package boundary;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
import control.*;

public class DashboardController implements Initializable{
    private Customer customer = Main.getCustomer();
    @FXML
    private VBox vBoxButton;

    @FXML
    private Pane pnlPersonalInfo;

    @FXML
    private Pane pnlStamp;

    @FXML
    private Button btnSignOut;

    @FXML
    private Pane pnlRamen;

    @FXML
    private Button btnStamp;

    @FXML
    private Button btnRamen;

    @FXML
    private Button btnPersonalInfo;

    @FXML
    private Button btnCart;

    @FXML
    private Pane pnlCart;

    @FXML
    private Pane pnlWelcome;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (customer.getToPersonInfo() == 1) {
            pnlWelcome.toFront();
            Node[] nodes = new Node[1];
            try {
                nodes[0] = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
                pnlWelcome.getChildren().add(nodes[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            pnlPersonalInfo.toFront();
            Node[] nodes = new Node[1];
            try {
                nodes[0] = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
                pnlPersonalInfo.getChildren().add(nodes[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnRamen) {
            pnlRamen.toFront();
            Node[] nodes = new Node[1];
            try {
                nodes[0] = FXMLLoader.load(getClass().getResource("Ramen.fxml"));
                pnlRamen.getChildren().add(nodes[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (actionEvent.getSource() == btnCart) {
            pnlCart.toFront();
            Node[] nodes = new Node[1];

            try {
                nodes[0] = FXMLLoader.load(getClass().getResource("Cart.fxml"));
                pnlCart.getChildren().add(nodes[0]);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (actionEvent.getSource() == btnStamp) {
            pnlStamp.toFront();

            Node[] nodes = new Node[1];

            try {
                nodes[0] = FXMLLoader.load(getClass().getResource("Stamp.fxml"));
                pnlStamp.getChildren().add(nodes[0]);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(actionEvent.getSource()==btnPersonalInfo)
        {
            pnlPersonalInfo.toFront();
            for(int i = 0; i < pnlPersonalInfo.getChildren().size(); i++)
                pnlPersonalInfo.getChildren().remove(i);
            Node[] nodes = new Node[1];
            try {
                if(customer.getToPersonInfo() == 0){
                    nodes[0] = FXMLLoader.load(getClass().getResource("PersonalInfo.fxml"));
                }
                else{
                    nodes[0] = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
                }
                pnlPersonalInfo.getChildren().add(nodes[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(actionEvent.getSource()==btnSignOut)
        {
            Main.getPrimaryStage().close();
        }
    }
}


