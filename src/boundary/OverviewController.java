package boundary;

import control.Customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OverviewController implements Initializable {
	private Customer customer = new Customer(1);

	@FXML
	private Pane pnlOverview;

	@FXML
	private Button btnOverview;

	@FXML
	private Pane pnlCustomer;

	@FXML
	private VBox pnItems;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pnlOverview.setStyle("-fx-background-color : #02030A");
		pnlOverview.toFront();
		//setOnAction
		Label totalOrders = (Label) pnlOverview.lookup("#TotalOrders");
		totalOrders.setText("" + customer.getOrderList().getArraylist().size());

		Label totalAmount = (Label) pnlOverview.lookup("#TotalAmount");
		totalAmount.setText("" + customer.getOrderList().getArraylist().size());

		Label todayOrders = (Label) pnlOverview.lookup("#TodayOrders");
		todayOrders.setText("" + customer.getOrderList().getArraylist().size());
		Node[] nodes = new Node[customer.getOrderList().getArraylist().size()];

		int i = 0;
		for (i = 0; i < nodes.length; i++) {
			try {

				final int j = i;
				nodes[i] = FXMLLoader.load(getClass().getResource("Item.fxml"));

				Parent p = (Parent) nodes[i];
				Label id = (Label) p.lookup("#ID");
				Label name = (Label) p.lookup("#UserName");
				Label time = (Label) p.lookup("#Time");
				Button active = (Button) p.lookup("#Active");
				id.setText("" + customer.getOrderList().getArraylist().get(i).getOrderID());
				name.setText("" + customer.getOrderList().getArraylist().get(i).getCode());
				time.setText("" + customer.getOrderList().getArraylist().get(i).getGenerateTime());

				//give the items some effect
				nodes[i].setOnMouseEntered(event -> {
					nodes[j].setStyle("-fx-background-color : #0A0E3F");
				});
				nodes[i].setOnMouseExited(event -> {
					nodes[j].setStyle("-fx-background-color : #02030A");
				});
				pnItems.getChildren().add(nodes[i]);

				//System.out.println(customer.getOrderList().Getter().get(i).getOrderID());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

