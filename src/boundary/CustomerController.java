package boundary;

import control.Business;
import control.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerController implements Initializable{
    private Business business = Main.getBusiness();

    @FXML
    private VBox CustomerItems;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Node[] nodes = new Node[business.getUserList().size()];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("Item.fxml"));
                //System.out.println(CustomerItems);
                Label userId = (Label) nodes[i].lookup("#userId");
                userId.setText(business.getUserList().get(i).getUserID());
                Label userName = (Label) nodes[i].lookup("#userName");
                userName.setText(business.getUserList().get(i).getFirstName() + " " + business.getUserList().get(i).getSurname());
                Label email = (Label) nodes[i].lookup("#email");
                email.setText(business.getUserList().get(i).getEmail());
                Label phone = (Label) nodes[i].lookup("#phone");
                phone.setText(business.getUserList().get(i).getPhoneNum()+"");
                Label amount = (Label) nodes[i].lookup("#amount");
                amount.setText("100");

                CustomerItems.getChildren().add(nodes[i]);
                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #0A0E3F");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #02030A");
                });


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
