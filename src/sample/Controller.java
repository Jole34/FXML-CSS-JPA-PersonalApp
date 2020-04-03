package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Controller {
    @FXML
    private PasswordField pass;
    @FXML
    private TextField log;

    int br =0;

    public ArrayList<String> collectDataLog(){
        ++br;
        String passtext = pass.getText();
        String logname = log.getText();
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText("Неисправно корисничко име или шифра ");
        a.setTitle("Грешка!");
        a.setHeaderText("Покушај број: "+br+"!");
        if (br ==3)
            a.setHeaderText("Ако ниси Јован стоп!");
        a.show();
        return null;
    }



}
