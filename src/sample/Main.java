package sample;

import db.CRUD;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Ispit;

import java.net.CacheRequest;
import java.util.ArrayList;

import static javafx.fxml.FXMLLoader.*;

public class Main extends Application {
    public static Stage stage2 = new Stage();
    public static Stage stage3 = new Stage();
    public static Stage stage4 = new Stage();



    @Override
    public void start(Stage primaryStage) throws Exception{
        CRUD db = new CRUD();
        //roots for fxml files
        Parent root = load(getClass().getResource("sample.fxml"));
        Parent root2 = load(getClass().getResource("sample2.fxml"));
        Parent root3 = load(getClass().getResource("ispiti.fxml"));
        Parent root4 = FXMLLoader.load(getClass().getResource("dodajIspit.fxml"));



        //first page
        Scene scene = new Scene(root, 800, 500);
        primaryStage.setTitle("Главоњић АПП");
        scene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //second page

        Scene scene2 = new Scene(root2, 800, 500);
        scene2.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
        stage2.setScene(scene2);

        //thid page

        Scene scene3 = new Scene(root3, 800, 500);
        scene3.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
        stage3.setScene(scene3);

        //fpage
        Scene scene4 = new Scene(root4, 400, 300);
        scene4.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
        stage4.setScene(scene4);



    }

    public static void main(String[] args) {
        launch(args);
    }
}
