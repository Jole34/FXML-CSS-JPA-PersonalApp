package sample;

import db.CRUD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Ispit;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller2 implements Initializable {
    @FXML
    private TableView listaIspita;
    @FXML
    private TextField prosekT;
    @FXML
    private TextField bodovi;

    private ArrayList<Ispit> lista;


    public void goBack(){
        Stage st2 = Main.stage3;
        Stage st = Main.stage2;

        st.show();
        st2.close();
    }

    public void fakultetData(){
        CRUD db = new CRUD();

        lista = db.sviIspiti();

        ObservableList<Ispit> is = FXCollections.observableArrayList();
        is.addAll(lista);

        TableColumn<String, Ispit> column1 = new TableColumn<>("Предмет");
        column1.setCellValueFactory(new PropertyValueFactory<>("naziv"));


        TableColumn<Integer, Ispit> column2 = new TableColumn<>("Оцена");
        column2.setCellValueFactory(new PropertyValueFactory<>("ocena"));

        TableColumn<Integer, Ispit> column3 = new TableColumn<>("ЕСПБ");
        column3.setCellValueFactory(new PropertyValueFactory<>("espb"));

        listaIspita.getColumns().add(column1);
        listaIspita.getColumns().add(column2);
        listaIspita.getColumns().add(column3);

        listaIspita.getItems().addAll(lista);


        float prosek = 0;
        int bodoviA = 0;
        int broj = 0;

        for(Ispit i: lista){
            prosek += i.getOcena();
            bodoviA += i.getEspb();
            ++broj;
        }

        prosek = prosek/broj;
        String formattedString = "Укупан просек: ";
        formattedString += String.format("%.02f", prosek);

        prosekT.setText(formattedString);
        String bodoviS = "Укупан број остварених бодова: "+String.valueOf(bodoviA);
        bodovi.setText(bodoviS);

    }


    public void dodaj(){
        Stage st = Main.stage4;
        st.show();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fakultetData();
    }

    public void delete(){
        CRUD db = new CRUD();
        Ispit i = (Ispit) listaIspita.getSelectionModel().getSelectedItem();
        db.deletePredmet(i.getNaziv());
    }
}
