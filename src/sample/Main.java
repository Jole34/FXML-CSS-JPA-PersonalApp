package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Parent root2 = FXMLLoader.load(getClass().getResource("sample2.fxml"));

        Scene scene = new Scene(root, 800, 500);
        primaryStage.setTitle("Распоред");
        scene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

        Stage stage2 = new Stage();
        Scene scene2 = new Scene(root2, 800, 500);
        scene2.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
        stage2.setScene(scene2);
        stage2.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
