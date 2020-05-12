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
import javax.swing.JOptionPane;
import entities.User;
import control.GenUser;
import control.UserOP;

public class SingUpController implements Initializable{
    @FXML
    private Button btnCancel

    @FXML
    private Button btnOK

    @FXML
    private TextField NameField

    @FXML
    private TextField PhoneField

    @FXML
    private TextField EmailField

    @FXML
    private PasswordField passwordField //这个自己加的，PersonalInfo.fxml里没有，希望做前端的能加上去

    @FXML
    private Label labUserID

    @Override
    public void initialize(URL location, ResourceBundle resources){
        btnOk.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String usrname = NameField.getText();
                String passcode = passwordField.getText();
                String phonenum = PhoneField.getText();
                String mail = EmailField.getText();

                GenUser gusr = new GenUser(usrname,passcode,phonenum,mail);
                User usr = gusr.getUser();
                String uid = usr.getUserID();
                labUserID.setText("Your ID is:"+uid)
            }
        });

    }
}