package boundary;

import control.Customer;
import control.Main;
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

public class LoginViewController implements Initializable{
    private Customer customer = new Customer(1);
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

        SignInButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                System.out.println(1);
                showDashboard();
            }
        });
    }

    public void showDashboard() {
        Stage primaryStage = new Stage();
        try {
            // 载入登录页面
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../boundary/Home.fxml"));
            Parent root = loader.load();
            DashboardController  DashboardController = loader.getController();
            primaryStage.setScene(new Scene(root, 1050, 576));
            Main.getPrimaryStage().close();
            Main.setPrimaryStage(primaryStage);
            Main.getPrimaryStage().show();

            // 传递主函数
            //System.out.println(DashboardController);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
