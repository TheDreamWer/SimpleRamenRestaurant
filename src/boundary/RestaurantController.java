package boundary;

import control.Business;
import control.Main;
import entities.Restaurant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import javax.xml.soap.Text;
import java.net.URL;
import java.util.ResourceBundle;

public class RestaurantController  implements Initializable {
    private Business business = Main.getBusiness();

    @FXML
    private Pane Restpln;

    @FXML
    private Button btnOK;

    @FXML
    private Button btnCancel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setRestpln();
    }

    public void setRestpln() {
        TextField restName = (TextField) Restpln.lookup("#restName");
        restName.setText(business.viewRestName());
        TextField address = (TextField) Restpln.lookup("#address");
        address.setText(business.viewRestAddress());
        TextField postal = (TextField) Restpln.lookup("#postal");
        postal.setText(business.viewRestPostalcode());
        TextField date = (TextField) Restpln.lookup("#date");
        date.setText(business.viewRestRegistrationDate());
        ScrollPane scrollPane = (ScrollPane) Restpln.lookup("#intro");
        TextArea intro = (TextArea) scrollPane.contentProperty().getValue();
        intro.setText(business.viewRestIntro());
    }

    public void saveRest(){
        TextField restName = (TextField) Restpln.lookup("#restName");
        business.modifyRestName(restName.getText());
        TextField address = (TextField) Restpln.lookup("#address");
        business.modifyRestAddress(address.getText());
        TextField postal = (TextField) Restpln.lookup("#postal");
        business.modifyRestPostalcode(postal.getText());
        TextField date = (TextField) Restpln.lookup("#date");
        business.modifyRestRegistrationDate(date.getText());
        ScrollPane scrollPane = (ScrollPane) Restpln.lookup("#intro");
        TextArea intro = (TextArea) scrollPane.contentProperty().getValue();
        business.modifyRestIntro(intro.getText());
    }

    public void handleClicks(ActionEvent actionEvent){
        if (actionEvent.getSource() == btnOK) {
            saveRest();
        }
        if (actionEvent.getSource() == btnCancel) {
            setRestpln();
        }
    }
}
