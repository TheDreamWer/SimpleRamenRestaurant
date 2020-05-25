package boundary;

import control.Customer;
import control.Main;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class LoginViewController implements Initializable{
    Customer customer = Main.getCustomer();
    @FXML
    private TextField usernameField;

    @FXML
    private Button SignInButton;

    @FXML
    private Label DateLab;

    @FXML
    private VBox loginBox;

    @FXML
    private Button ForgetButton;

    @FXML
    private Button VisitorButton;

    @FXML
    private Button SignUpButton;

    @FXML
    private Pane InfoPane;

    @FXML
    private Label AddressLab;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label IntroLab;

    @FXML
    private Label PostalLab;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Label restName = (Label) InfoPane.lookup("#restName");
        restName.setText(customer.getRest().getRestName());

        Label restInfo = (Label) InfoPane.lookup("#restInfo");
        restInfo.setText(customer.getRest().getRestIntro());

        AddressLab.setText("Address:\t" + customer.getRest().getRestAddress());
        PostalLab.setText("Postal code:\t" + customer.getRest().getRestPostalcode());
        DateLab.setText("Registration Date:\t" + customer.getRest().getRestRegistrationDate());

        TextField userIDField = (TextField) loginBox.lookup("#userIDField");
        TextField passwordField = (TextField) loginBox.lookup("#passwordField");

        SignInButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String usrid = userIDField.getText();
                String pw = passwordField.getText();
                if (customer.loginUser(usrid, pw)){
                    showDashboard();
                }
                else{
                    showGeneralInfo("Action Failed! Please input correct id and password.");
                }
            }
        });

        VisitorButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                customer.setToPersonInfo(2);
                showDashboard();
                showGeneralInfo("Click Personal Info to register to become an affiliate! Enjoy ramen for free!");
            }
        });
        SignUpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                customer.setToPersonInfo(1);
                showDashboard();
            }
        });
    }

    public void showDashboard() {
        Stage primaryStage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../boundary/Home.fxml"));
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root, 1050, 576));
            Main.getPrimaryStage().close();
            Main.setPrimaryStage(primaryStage);
            Main.getPrimaryStage().initStyle(StageStyle.UNDECORATED);
            Main.getPrimaryStage().show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showGeneralInfo(String notice){
        Stage primaryStage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../boundary/GeneralInfo.fxml"));
            Parent root = loader.load();
            Label text = (Label) root.lookup("#GeneralLab");
            text.setText(notice);
            primaryStage.setScene(new Scene(root));
            primaryStage.initStyle(StageStyle.DECORATED);
            primaryStage.show();
            primaryStage.toFront();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
