package boundary;

import control.Customer;
import control.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class PersonalInfoController implements Initializable {
    private Customer customer = Main.getCustomer();

    @FXML
    private Label labUserID;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnOK;

    @FXML
    private TextField NameField;

    @FXML
    private TextField EmailField;

    @FXML
    private TextField PhoneField;

    @FXML
    private TextField NameField1;

    @FXML
    private AnchorPane InfoPnl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setBtnCancel();
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

    public void setBtnCancel() {
        labUserID.setText(customer.getUser().getUserID());
        NameField.setText(customer.getUser().getFirstName());
        NameField1.setText(customer.getUser().getSurname());
        PhoneField.setText(customer.getUser().getPhoneNum());
        EmailField.setText(customer.getUser().getEmail());
    }

    public void setBtnOK() {
        customer.getUser().setFirstName(NameField.getText());
        customer.getUser().setSurname(NameField1.getText());
        customer.getUser().setPhoneNum(PhoneField.getText());
        customer.getUser().setEmail(EmailField.getText());
        customer.saveUser();
    }
}
