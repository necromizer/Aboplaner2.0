/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author schei
 */
public class SpielplanUIController implements Initializable {


    @FXML
    private TableView<?> tv_statistik;
    @FXML
    private TableColumn<?, ?> tcName_statistik;
    @FXML
    private TableColumn<?, ?> tcFt_statistik;
    @FXML
    private TableColumn<?, ?> tcAE_Statistik;
    @FXML
    private TableColumn<?, ?> tcSv_statistik;
    @FXML
    private TableColumn<?, ?> tcLP_statistik;
    @FXML
    private TableColumn tc_p1;
    @FXML
    private TableView tv_datum;
    @FXML
    private TableColumn tc_p3;
    @FXML
    private TableColumn tc_p2;
    @FXML
    private TableColumn tc_p4;
    @FXML
    private TableColumn tc_Datum;
    @FXML
    private Button btn_speichern;
    @FXML
    private Button btn_zurueck;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void btnZurueck(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Auswahl.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Auswahl");
        stage =(Stage) btn_speichern.getScene().getWindow();
        stage.close();
    }

    public void btnSpeichern(ActionEvent actionEvent) {
    }
}
