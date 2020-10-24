package sample;

import db.CRUD;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import javafx.scene.control.TextField;

public class Controller3 {

    @FXML
    public Pane panelD;

    @FXML
    private TextField nazivT;
    @FXML
    private TextField ocenaTT;
    @FXML
    private TextField espbTT;

    public void savePredmet(){
        String naziv = nazivT.getText();
        int ocena = Integer.parseInt(ocenaTT.getText());
        int espb = Integer.parseInt(espbTT.getText());
        CRUD db = new CRUD();
        db.addPredmet(naziv, ocena, espb);
    }

}
