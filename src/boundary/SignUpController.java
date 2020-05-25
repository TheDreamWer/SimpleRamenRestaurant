package boundary;

import control.Customer;
import control.Main;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ChoiceBox;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;

public class SignUpController implements Initializable {
    private Customer customer = Main.getCustomer();

    private String preNum = "";

    @FXML
    private Button btnCancel;

    @FXML
    private AnchorPane SignUpPnl;

    @FXML
    private Button btnOK;

    @FXML
    private TextField NameField;

    @FXML
    private TextField EmailField;

    @FXML
    private TextField PhoneField;

    @FXML
    private TextField SurnameField;

    @FXML
    private ChoiceBox<String> phoneChoicebox;

    private ObservableList<String> phoneData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> choiceItems = FXCollections.observableArrayList();
        choiceItems.add(0, "+86");//初始化选择框内选项
        choiceItems.add(1, "+44");//初始化选择框内选项
        phoneChoicebox.setItems(choiceItems);
        phoneChoicebox.setValue("1");
        phoneChoicebox.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) ->{
            if (new_val.intValue() == 0){
                preNum = "+86";
            }
            else{
                preNum = "+44";
            }
        });
        btnCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setBtnCancel();
            }
        });
        btnOK.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setBtnOK();
            }
        });
    }
    public void setBtnCancel(){
        NameField.setText("");
        SurnameField.setText("");
        PhoneField.setText("");
        EmailField.setText("");
        PasswordField passwordField = (PasswordField) SignUpPnl.lookup("#password");
        passwordField.setText("");
    }
    public void setBtnOK(){
        PasswordField passwordField = (PasswordField) SignUpPnl.lookup("#password");
        String id = customer.registUser(NameField.getText(), SurnameField.getText(), passwordField.getText(), preNum + PhoneField.getText(), EmailField.getText());
        customer.setToPersonInfo(0);
        customer.loginUser(id, passwordField.getText());
    }
}
