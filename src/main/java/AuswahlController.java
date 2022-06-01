/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import static javafx.application.Platform.exit;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


/**
 * FXML Controller class
 *
 * @author schei
 */
public class AuswahlController implements Initializable {

    @FXML
    private RadioButton rB_Montag;
    @FXML
    private Button btn_hinzufuegen;
    @FXML
    private Button btn_loeschen;
    @FXML
    private ChoiceBox<String> cb_spielweise;
    @FXML
    private TextField tf_name;
    @FXML
    private ListView<String> list_players;
    @FXML
    private Button btn_hinzufuegen1;
    @FXML
    private Button btn_hinzufuegen_date;
    @FXML
    private Button btn_loeschen_date;
    @FXML
    private ListView<Spieltag> list_date;
    @FXML
    private TextField tf_date;
    @FXML
    private DatePicker dp_date;
    @FXML
    private Button btn_Spielplan;
    @FXML
    private Button btn_speichern;
    @FXML
    private RadioButton rb_dienstag;
    @FXML
    private RadioButton rb_mittwoch;
    @FXML
    private RadioButton rb_donnerstag;
    @FXML
    private RadioButton rb_samtag;
    @FXML
    private RadioButton rb_sonntag;
      @FXML
    private RadioButton rb_freitag;
    
    private ArrayList<RadioButton> rlist = new ArrayList();
    private ObservableList list;
    private ObservableList listd;
    private String rb_checked; //beinhaltet text des ausgewählten Radiobuttons
    
    

    /**
     * Initializes the controller class.
     */
    @Override
  
    public void initialize(URL url, ResourceBundle rb) {
      
        //Liste rlist wird mit allen Radiobuttons befüllt.

       rlist.add(rB_Montag);
       rlist.add(rb_dienstag);
       rlist.add(rb_mittwoch);
       rlist.add(rb_donnerstag);
       rlist.add(rb_freitag);
       rlist.add(rb_samtag);
       rlist.add(rb_sonntag);
       
       // Value der Combobox wird gesetzt und befüllt.
       cb_spielweise.getItems().add("Einzel");
       cb_spielweise.getItems().add("Doppel");
       cb_spielweise.setValue("Einzel");
       
    }    

    @FXML
    private void btnHinzufuegen(ActionEvent event) {
        //fügt Text von dem Textfield tf_name in die Liste list_players ein, wenn das Textfield nicht leer ist.
        if(tf_name.getText()!=null){
            list_players.getItems().add(tf_name.getText());
        }
    }

    @FXML
    private void btnLoeschen(ActionEvent event) {
        //Selektiertes Element aus der Liste list_players wird aus der Liste gelöscht.
        final int selectedID = list_players.getSelectionModel().getSelectedIndex();
        list_players.getItems().remove(selectedID);
    }

    @FXML
    private void btnHinzufuegenDate(ActionEvent event) {
        if (tf_date.getText()!=null&&dp_date.getValue()!=null){
            list_date.getItems().add(new Spieltag(tf_date.getText(),dp_date.getValue()));
        }

    }

    @FXML
    private void btnloeschenDate(ActionEvent event) {
        final int selectedID = list_date.getSelectionModel().getSelectedIndex();
        list_date.getItems().remove(selectedID);
    }

    @FXML
    private void btnEndOfEverything(ActionEvent event) throws IOException {
        //Fenster Alarm wird sichtbar.
        Parent root = FXMLLoader.load(getClass().getResource("Alarm.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        stage.setTitle("Speichern?");
    }

    @FXML
    private void btnErstellung(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Loading.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        stage.setTitle("Loading...");
    }

    @FXML
    private void btnSpeichern(ActionEvent event) {
    }

    @FXML
    private void check_montag(ActionEvent event) {
        //es wird überprüft, ob außer dem Radiobutton rb_montag noch ein anderer Radiobutton selektiert ist. Wenn dies der Fall ist, werden alle außer rb_montag nicht selektiert.
        boolean check;
        
        for(int i =0; i<=rlist.size();i++){
             if(rlist.get(i).getId().equals(rlist.get(0).getId())){
                 rb_sonntag.setSelected(true);
                 rb_checked = rlist.get(i).getText();
             }else
            rlist.get(i).setSelected(false);
        }
    }

    @FXML
    private void check_dienstag(ActionEvent event) {
         boolean check;
        for(int i =0; i<=rlist.size();i++){
             if(rlist.get(i).getId().equals(rlist.get(1).getId())){
                 rb_sonntag.setSelected(true);
                   rb_checked = rlist.get(i).getText();
             }else
            rlist.get(i).setSelected(false);
        }
    }

    @FXML
    private void check_mittwoch(ActionEvent event) {
         boolean check;
        for(int i =0; i<=rlist.size();i++){
             if(rlist.get(i).getId().equals(rlist.get(2).getId())){
                 rb_sonntag.setSelected(true);
                   rb_checked = rlist.get(i).getText();
             }else
            rlist.get(i).setSelected(false);
        }
    }

    @FXML
    private void check_donnerstag(ActionEvent event) {
         boolean check;
         for(int i =0; i<=rlist.size();i++){
             if(rlist.get(i).getId().equals(rlist.get(3).getId())){
                 rb_sonntag.setSelected(true);
                   rb_checked = rlist.get(i).getText();
             }else
            rlist.get(i).setSelected(false);
        }
    }

    @FXML
    private void check_freitag(ActionEvent event) {
         boolean check;
         for(int i =0; i<=rlist.size();i++){
             if(rlist.get(i).getId().equals(rlist.get(4).getId())){
                 rb_sonntag.setSelected(true);
                   rb_checked = rlist.get(i).getText();
             }else
            rlist.get(i).setSelected(false);
        }
    }

    @FXML
    private void check_samstag(ActionEvent event) {
         boolean check;
         for(int i =0; i<=rlist.size();i++){
             if(rlist.get(i).getId().equals(rlist.get(5).getId())){
                 rb_sonntag.setSelected(true);
                   rb_checked = rlist.get(i).getText();
             }else
            rlist.get(i).setSelected(false);
        }
    }

    @FXML
    private void check_sonntag(ActionEvent event) {
         boolean check;
         for(int i =0; i<=rlist.size();i++){
             if(rlist.get(i).getId().equals(rlist.get(6).getId())){
                 rb_sonntag.setSelected(true);
                   rb_checked = rlist.get(i).getText();
             }else
            rlist.get(i).setSelected(false);
        }
       
    }
    
}
