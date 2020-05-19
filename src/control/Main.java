package control;

import control.Business;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;

public class Main extends Application {
    private double x, y;
    private static Business business = new Business(1);
    private static Stage primaryStage = new Stage();
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../boundary/Home.fxml"));
        primaryStage.setScene(new Scene(root));
        //set stage borderless
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("A Simple Ramen Restaurant");

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
    public static Business getBusiness(){
        return business;
    }
    public static void main(String[] args) {
        launch(args);
    }
    public static Stage getPrimaryStage(){
        return primaryStage;
    }
}
