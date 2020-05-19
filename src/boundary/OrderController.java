package boundary;

import control.Business;
import control.Main;
import entities.Order;
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

public class OrderController implements Initializable{
    private Business business = Main.getBusiness();
    private static Order currentOrder = Main.getBusiness().getOrderList().getArraylist().get(0);
    @FXML
    private Pane OrderInfoPane;

    @FXML
    private VBox orderItem;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Node[] nodes = new Node[business.getOrderList().getArraylist().size()];
        for (int i = 0; i < nodes.length; i++) {
            try {
                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("OrderIDItem.fxml"));
                Button orderId = (Button) nodes[i].lookup("#orderId");
                orderId.setText(business.getOrderList().getArraylist().get(i).getOrderID() + "");
                orderId.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String id = orderId.getText();
                        for (int k = 0; k < business.getOrderList().getArraylist().size(); k++){
                            if (id.equals(business.getOrderList().getArraylist().get(k).getOrderID() + ""))
                                currentOrder = business.getOrderList().getArraylist().get(k);
                        }
                        setOrderInfoPane(currentOrder);
                    }
                });
                //System.out.println(CustomerItems);
                orderItem.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        setOrderInfoPane(currentOrder);
    }
    public void setOrderInfoPane(Order order){
        Node[] node = new Node[1];
        try {
            node[0] = FXMLLoader.load(getClass().getResource("OrderInfo.fxml"));
            if (OrderInfoPane.getChildren().size() != 0){
                int length = OrderInfoPane.getChildren().size();
                for (int k = 0; k < length; k++)
                    OrderInfoPane.getChildren().remove(k);
            }
            OrderInfoPane.getChildren().add(node[0]);
            Label userId = (Label) OrderInfoPane.lookup("#userId");
            userId.setText("12345");
            Label username = (Label) OrderInfoPane.lookup("#userName");
            username.setText("Vincent");
            Label date = (Label) OrderInfoPane.lookup("#date");
            date.setText(order.getGenerateTime());
            Label amount = (Label) OrderInfoPane.lookup("#amount");
            amount.setText(order.getOrderAmount() + "");
            Label method = (Label) OrderInfoPane.lookup("#method");
            method.setText(order.getPaymentMethod());
            Label num = (Label) OrderInfoPane.lookup("#num");
            num.setText(order.getRamenList().size() + "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Order getCurrentOrder(){
        return currentOrder;
    }
}
