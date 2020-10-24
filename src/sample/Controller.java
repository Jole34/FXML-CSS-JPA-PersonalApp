package sample;

import db.CRUD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Ispit;

import java.util.ArrayList;
import java.util.Observable;

public class Controller {

    @FXML
    private PasswordField pass;
    @FXML
    private TextField log;
    @FXML
    private Button secondBS;

    private CRUD db = new CRUD();

    int br =0;

    public ArrayList<String> collectDataLog(){
        ++br;
        String passtext = pass.getText();
        String logname = log.getText();
        Stage st = (Stage) pass.getScene().getWindow();
        Stage st2 = Main.stage2;
        Alert a = new Alert(Alert.AlertType.ERROR);

        a.setContentText("Неисправно корисничко име или шифра ");
        a.setTitle("Грешка!");
        a.setHeaderText("Покушај број: "+br+"!");

        if (!db.checkLogin(logname, passtext)){
            a.show();
            if (br ==3){
                a.setHeaderText("Ако ниси Јован стоп!");
                a.close();
            }

        }else {
            st.close();
            st2.show();
        }
        return null;
    }

    public void fakultetData(){

        Stage st2 = Main.stage3;
        Stage st = Main.stage2;

        st.close();
        st2.show();
    }
}
