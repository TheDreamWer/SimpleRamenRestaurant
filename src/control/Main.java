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

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../boundary/Home.fxml"));
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
}
