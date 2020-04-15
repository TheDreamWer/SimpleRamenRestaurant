package control;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import boundary.*;

import java.io.IOException;

public class Main extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
//        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage = stage;
        showLoginView();
        //showDashboard();
    }

    public void showLoginView() {
        try {
            // 载入登录页面
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../boundary/LoginView.fxml"));
            Parent root = loader.load();
            LoginViewController loginViewController = loader.getController();
            primaryStage.setScene(new Scene(root, 1280, 800));
            primaryStage.show();
            // 传递主函数
            //System.out.println(loginViewController);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    public void showDashboard() {
        Stage primaryStage = new Stage();
        try {
            // 载入登录页面
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../boundary/Home.fxml"));
            Parent root = loader.load();
            DashboardController  DashboardController = loader.getController();
            primaryStage.setScene(new Scene(root, 1050, 576));
            primaryStage.show();

            // 传递主函数
            //System.out.println(DashboardController);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

