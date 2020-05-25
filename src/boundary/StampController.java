package boundary;

import control.Customer;
import control.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class StampController implements Initializable {
    private Customer customer = Main.getCustomer();

    @FXML
    private Label StampLab;

    @FXML
    private AnchorPane StampPnl;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StampLab.setText(customer.viewUserStamps() - customer.viewUserUsedStamps() + "");
    }
}
