package kernel.views;

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

public class CartController implements Initializable{

    @FXML
    private VBox ramenItems;


    @FXML
    private AnchorPane CartPnl;

    @FXML
    private Button btnPay;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Node[] RamenNodes = new Node[5];//多少碗拉面
        for (int i = 0; i < RamenNodes.length; i++) {
            try {

                final int j = i;
                RamenNodes[i] = FXMLLoader.load(getClass().getResource("RamenItem.fxml"));
                ramenItems.getChildren().add(RamenNodes[i]);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
