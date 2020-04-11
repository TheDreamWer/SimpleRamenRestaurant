package boundary;

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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable{

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pnlRamen.toFront();
        Node[] nodes = new Node[1];

        try {
            nodes[0] = FXMLLoader.load(getClass().getResource("Ramen.fxml"));
            pnlRamen.getChildren().add(nodes[0]);

        } catch (IOException e) {
            e.printStackTrace();
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
            pnlCart.setStyle("-fx-background-color : #464F67");
            pnlCart.toFront();
        }
        if (actionEvent.getSource() == btnStamp) {

            pnlStamp.toFront();
        }
        if(actionEvent.getSource()==btnPersonalInfo)
        {
            pnlPersonalInfo.toFront();
            Node[] nodes = new Node[1];

            try {
                nodes[0] = FXMLLoader.load(getClass().getResource("PersonalInfo.fxml"));
                pnlPersonalInfo.getChildren().add(nodes[0]);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}


