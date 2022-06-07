/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author schei, sebas
 */
public class SpielplanUIController implements Initializable {


    @FXML
    public TableView<Daten> tv_statistik;
    @FXML
    private TableColumn<Daten, String> tcName_statistik;
    //name, selbsterklärend
    @FXML
    private TableColumn<Daten, String> tcFt_statistik;
    //Anzahl der Einsätze an Feiertage, selbsterklärend
    @FXML
    private TableColumn<Daten, String> tcAE_Statistik;
    //Anzahl der gesamten Einsätze, selbsterklärend
    @FXML
    private TableColumn<Daten, String> tcSv_statistik;
    //Spielervarianz, kan plan
    @FXML
    private TableColumn<Daten, String> tcLP_statistik;
    //Längste Pause, umsetzung fraghaft
    @FXML
    private Button btn_speichern;
    @FXML
    private Button btn_zurueck;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tcName_statistik.setCellValueFactory(new PropertyValueFactory<Daten, String>("name"));
        tcFt_statistik.setCellValueFactory(new PropertyValueFactory<Daten, String>("anzahlfeiertage"));
        tcAE_Statistik.setCellValueFactory(new PropertyValueFactory<Daten, String>("anzahlgesamteinsätze"));
        tcSv_statistik.setCellValueFactory(new PropertyValueFactory<Daten, String>("spielervarianz"));
        tcLP_statistik.setCellValueFactory(new PropertyValueFactory<>("laengstePause"));
        tv_statistik.setItems(getDataList());
    }
ObservableList<Daten> getDataList()
{
    ObservableList<Daten> data = FXCollections.observableArrayList();
    data.add(new Daten("Basti",3,14,0,0));
    data.add(new Daten("Valenwood",3,14,0,0));
    return data;
}

public void Addrow(String name, int anzahlfeiertage, int anzahlgesamteinsätze )
{
    
}



public void btnZurueck(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Auswahl.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Auswahl");
        stage =(Stage) btn_speichern.getScene().getWindow();
    }

    public void btnSpeichern(ActionEvent actionEvent) {
        
    }
}
