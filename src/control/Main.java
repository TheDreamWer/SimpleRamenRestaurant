package control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import boundary.*;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
//        primaryStage.initStyle(StageStyle.UNDECORATED);
        this.primaryStage = primaryStage;
        //showLoginView();
        showDashboard();
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
            System.out.println(loginViewController);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showDashboard() {
        try {
            // 载入登录页面
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../boundary/Home.fxml"));
            Parent root = loader.load();
            DashboardController  DashboardController = loader.getController();
            primaryStage.setScene(new Scene(root, 1050, 576));
            primaryStage.show();

            // 传递主函数
            System.out.println(DashboardController);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

