package kernel.boundary;

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
        /*phoneChoicebox.getSelectionModel().selectedItemProperty().addListener(
        //这里应该是选择哪个的监听
        );*/
    }

}
