package control;

import entities.Restaurant;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.w3c.dom.Node;

public class Main extends Application {
    private double x, y;
    private static Stage primaryStage = new Stage();
    
    private static Customer customer = new Customer(1); // set "1" as the default restaurant
    private UserList userList = new UserList();

    public static void setPrimaryStage(Stage primaryStage) {
        Main.primaryStage = primaryStage;
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../boundary/LoginView.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        //set stage borderless
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setTitle("A Small Ramen Restaurant");
        primaryStage.getIcons().add(new Image(getClass().getResource("../resources/ramen.png").toURI().toString()));

        //drag it here
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {

            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);

        });
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);

    }
    
    @Override
    public void stop(){
        // Save Order List
        this.customer.saveOrderList();

        // Save User registed
        // The User information is saved while registration

        // Log out all users
        UserOP op = new UserOP();
        // For user in userlist
        // op.Logout(user.getUserID());

        // Save user information
        // 还没有Save类
    }
}
