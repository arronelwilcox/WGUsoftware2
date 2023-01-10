package model;

import DAO.DBConnection;
import controller.UserLogInController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;


public class Main extends Application {

//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("userForm.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
//    }


    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(UserLogInController.class.getResource("/model/userForm.fxml"));
            Parent root = fxmlLoader.load();
            primaryStage.setTitle("Appointment Management System");
            primaryStage.setScene(new Scene(root, 1100, 1100));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cant load Main");
        }
    }
        public static void main(String[] args) throws SQLException {

            DBConnection.startConnection();
            launch(args);
            DBConnection.closeConnection();
    }
}
