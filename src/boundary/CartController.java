package boundary;

import control.Customer;
import control.Main;
import entities.Ramen;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CartController implements Initializable{
    private Customer customer = Main.getCustomer();

    @FXML
    private VBox ramenItems;


    @FXML
    private AnchorPane CartPnl;

    @FXML
    private Button btnPay;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnPay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showPayPage();
            }
        });

        Node[] RamenNodes = new Node[customer.getDraft().getRamenList().size()];//多少碗拉面
        for (int i = 0; i < RamenNodes.length; i++) {
            try {
                final int j = i;
                Ramen ramen =customer.getDraft().getRamenList().get(i);
                RamenNodes[i] = FXMLLoader.load(getClass().getResource("RamenItem.fxml"));
                Label amount = (Label) RamenNodes[i].lookup("#amount");
                amount.setText(ramen.calcRamenAmount() + "");
                Button btnDeletRamen = (Button) RamenNodes[i].lookup("#btnDeletRamen");
                btnDeletRamen.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        for (int k = 0; k < RamenNodes.length; k++){
                            if (k == j){
                                ramenItems.getChildren().remove(k);
                                customer.getDraft().getRamenList().remove(k);
                            }
                        }
                    }
                });
                Label soup = (Label) RamenNodes[i].lookup("#soup");
                soup.setText("Soup: " + ramen.getSoup());
                Label noddles = (Label) RamenNodes[i].lookup("#noddles");
                noddles.setText("Noddels: " + ramen.getNoodles());
                Label onion = (Label) RamenNodes[i].lookup("#onion");
                onion.setText("Spring onion: " + ramen.getOnion_level());
                Label Nori = (Label) RamenNodes[i].lookup("#Nori");
                Nori.setText("Nori: " + ramen.getNori());
                Label Chashu = (Label) RamenNodes[i].lookup("#Chashu");
                Chashu.setText("Chashu: " + ramen.getChashu());
                Label egg = (Label) RamenNodes[i].lookup("#egg");
                egg.setText("Boiled egg: " + ramen.getBoiled_egg());
                Label spiciness = (Label) RamenNodes[i].lookup("#spiciness");
                spiciness.setText("Spiciness: " + ramen.getSpiciness());
                Label extraNori = (Label) RamenNodes[i].lookup("#extraNori");
                extraNori.setText("Extra Nori: " + ramen.getExtra_nori());
                Label extraEgg = (Label) RamenNodes[i].lookup("#extraEgg");
                extraEgg.setText("Extra boiled egg: " + ramen.getExtra_boiled_egg());
                Label extraChashu = (Label) RamenNodes[i].lookup("#extraChashu");
                extraChashu.setText("Extra Chashu: " + ramen.getExtra_chashu());
                Label bamboo = (Label) RamenNodes[i].lookup("#bamboo");
                bamboo.setText("Bamboo shoots: " + ramen.getBamboo_shoots());

                ramenItems.getChildren().add(RamenNodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void showPayPage(){
        Stage primaryStage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../boundary/Pay.fxml"));
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
            primaryStage.initStyle(StageStyle.DECORATED);
            primaryStage.show();
            primaryStage.toFront();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
