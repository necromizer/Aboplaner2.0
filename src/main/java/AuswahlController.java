/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import static javafx.application.Platform.exit;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
import sun.rmi.runtime.Log;


/**
 * FXML Controller class
 *
 * @author schei, sebas
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
    //liste mit spielern
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
      @FXML
    private DatePicker dp_startdate;
      @FXML
    private DatePicker dp_enddate;
    
    private ArrayList<RadioButton> rlist = new ArrayList();
    private ObservableList list;
    private ObservableList listd;
    private String rb_checked; //beinhaltet text des ausgewÃ¤hlten Radiobuttons
    public ArrayList spielerarray = new ArrayList();
    public int spieleranzahl = 0;
    public int wochentag;
    LocalDate startdatum;
    LocalDate enddatum;
    Date enddatumdate;
    Date startdatumdate;
    String spielweise = "Einzel";
    int feiertage = 0;
    private Stage stage;
    private Scene scene;
    private Parent root;
    ZoneId defaultZoneId = ZoneId.systemDefault();
    private ArrayList<String> saveplayers = new ArrayList();
    private ArrayList<Spieltag> savedates = new ArrayList<>();
    

    
    public ArrayList getSpielerarray() {
        return spielerarray;
    }

    public int getSpieleranzahl() {
        return spieleranzahl;
    }
    public String getSpielweise() { return spielweise; }
    public Date getStartdatumdate(){return startdatumdate;}
    public Date getEnddatumdate(){return enddatumdate;}
    public int getWochentag(){return wochentag;}
    public int getFeiertage(){return feiertage;}
    public Button getBtn_hinzufuegen(){return btn_hinzufuegen;}
    

    /**
     * Initializes the controller class.
     */
    @Override
  
    public void initialize(URL url, ResourceBundle rb) {
      
        //Liste rlist wird mit allen Radiobuttons befÃ¼llt.

       rlist.add(rB_Montag);
       rlist.add(rb_dienstag);
       rlist.add(rb_mittwoch);
       rlist.add(rb_donnerstag);
       rlist.add(rb_freitag);
       rlist.add(rb_samtag);
       rlist.add(rb_sonntag);
       
       // Value der Combobox wird gesetzt und befÃ¼llt.
       cb_spielweise.getItems().add("Einzel");
       cb_spielweise.getItems().add("Doppel");
       cb_spielweise.setValue("Einzel");
        setKomponenten();


    }

    private void setKomponenten() {

        try {
            InputStream p = new FileInputStream("save.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(p));
            String s = reader.readLine();
            if (s != null) {
                String[] sk = s.split(";"); //Alle elemente im String werden getrennt in einem array gespeichert
                for (int i = 0; i < rlist.size(); i++) {
                    if (sk[2].equals(rlist.get(i).getText())) { //prüft, welcher radiobuttontext mit der des Strings, identisch ist und selektiert diesen.
                        rlist.get(i).setSelected(true);
                    }
                }
                if (sk[3].equals("null")) {
                    //nichst wird ausgewählt
                } else {
                    dp_startdate.setValue(LocalDate.parse(sk[3]));//datum wird im datepicker gesetzt
                }
                if (sk[4].equals("null")) {
                    //nichts wird ausgewaehlt
                } else {
                    dp_enddate.setValue(LocalDate.parse(sk[4])); //datum wird im datepicker gesetzt
                }
                for (int i = 0; i < Integer.parseInt(sk[0]); i++) {
                    list_players.getItems().add(sk[i+5]); // mithilfe von sk[0] (anzahl der Namen in Liste rlist) werden dieselbe anzahl an namen vom array wieder in die liste rlist gespeichert
                }
                int i = Integer.parseInt(sk[0]);
                if (sk[6+i].equals("null")){
                    //nichts wird ausgewaehlt
                }
                else{
                    cb_spielweise.setValue(sk[6+i]); //text wird in combobox gesetzt
                }
                for (int j = 0; j<Integer.parseInt(sk[1]);i+=2){
                    list_date.getItems().add(new Spieltag(sk[i+7],LocalDate.parse(sk[i+8]))); // mithilfe von sk[1] (anzahl der Daten in Liste listdate) werden dieselbe anzahl an Daten vom array wieder in die liste listdate gespeichert
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void dp_startaction()
    {
        startdatum = dp_startdate.getValue();
        startdatumdate = Date.from(startdatum.atStartOfDay(defaultZoneId).toInstant());
    }
    public void dp_endaction()
    {
        enddatum = dp_enddate.getValue();
        enddatumdate = Date.from(enddatum.atStartOfDay(defaultZoneId).toInstant());
    }

    @FXML
    private void btnHinzufuegen(ActionEvent event) {
        //fÃ¼gt Text von dem Textfield tf_name in die Liste list_players ein, wenn das Textfield nicht leer ist.
        // s/ Fügt Spieler zu einem Spielerarray hinzu, zählt Spieleranzahl 1 hoch
        
            
            spielerarray.add(tf_name.getText());
            spieleranzahl ++;
            saveplayers.add(tf_name.getText());
            
            
            
        if(tf_name.getText()!=null){
            
            list_players.getItems().add(tf_name.getText());
            
            
        }
        
    }




    @FXML
    private void btnLoeschen(ActionEvent event) {
        //Selektiertes Element aus der Liste list_players wird  gelÃ¶scht.
        final int selectedID = list_players.getSelectionModel().getSelectedIndex();
        list_players.getItems().remove(selectedID);
    }

    @FXML
    private void btnHinzufuegenDate(ActionEvent event) {
        feiertage++;

        if (tf_date.getText()!=null&&dp_date.getValue()!=null){
            savedates.add(new Spieltag(tf_date.getText(),dp_date.getValue()));
            list_date.getItems().add(new Spieltag(tf_date.getText(),dp_date.getValue()));

            list_date.setCellFactory(param -> new DatumCell());
            //linkt die liste mit der cellfactory
        }


    }

    @FXML
    private void btnloeschenDate(ActionEvent event) {
        //löscht selektiertes element aus der listview gelöscht.
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

    //lädt das Fenster Loading und schließt Auswahl
    @FXML
    private void btnErstellung(ActionEvent event) throws IOException {

        
        Parent root = FXMLLoader.load(getClass().getResource("SpielplanUI.fxml"));
       // stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        stage.setTitle("SpielplanUI");
        stage = (Stage)btn_hinzufuegen.getScene().getWindow();
        stage.close();
    }
    // speichert den text des gerade ausgewählten radiobuttons in einen string
    private String getradiobtns(){
        String radiobtn = "";
        for (int i = 0; i< rlist.size();i++ ){
            if (rlist.get(i).isSelected())
            {
                radiobtn = rlist.get(i).getText();
            }
        }

        return radiobtn;
    }
    public void speichern() throws IOException {
        //Alle Werte der KOmponenten einlesen und in einem String speichern; jedes Element soll mit einem ";" getrennt sein.
        //Der String wird unverschlüsselt in einer CSV-Datei gespeichert
        String save = "";
        save += saveplayers.size() +";";
        save += savedates.size() + ";";
        save += getradiobtns()+";";
        save += dp_startdate.getValue()+ ";";
        save += dp_enddate.getValue()+";";
        for (int i =0;i<saveplayers.size();i++){
            save += saveplayers.get(i) + ";";
        }
        save += cb_spielweise.getValue() + ";";
        for (int i = 0;i<savedates.size();i++){
            save+= savedates.get(i).getnameSpieltag() +";" + savedates.get(i).getLocalDate().toString();
        }

        FileWriter fw = new FileWriter(" save.csv");
        fw.write(save);
        fw.close();

    }

    @FXML
    private void btnSpeichern(ActionEvent event) throws IOException {
       speichern();
    }

    @FXML
    private void check_montag(ActionEvent event) {
        //es wird Ã¼berprÃ¼ft, ob auÃŸer dem Radiobutton rb_montag noch ein anderer Radiobutton selektiert ist. Wenn dies der Fall ist, werden alle auÃŸer rb_montag nicht selektiert.
        boolean check;
        wochentag = 2;
        for(int i =0; i<rlist.size();i++){
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
         wochentag = 3;
        for(int i =0; i<rlist.size();i++){
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
         wochentag = 4;
        for(int i =0; i<rlist.size();i++){
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
         wochentag = 5;
         for(int i =0; i<rlist.size();i++){
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
         wochentag = 6;
         for(int i =0; i<rlist.size();i++){
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
         wochentag = 7;
         for(int i =0; i<rlist.size();i++){
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
         wochentag = 1;
         for(int i =0; i<rlist.size();i++){
             if(rlist.get(i).getId().equals(rlist.get(6).getId())){
                 rb_sonntag.setSelected(true);
                   rb_checked = rlist.get(i).getText();
             }else
            rlist.get(i).setSelected(false);
        }
       
    }
    
}
