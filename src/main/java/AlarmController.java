/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Platform.exit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author schei
 */
public class AlarmController implements Initializable {

    @FXML
    private Button btn_close;
   
    

    /**
     * Initializes the controller class.
     * @param url
     * @throws Exception
     */
   
    public void initialize(URL url, ResourceBundle rb){
    }

    @FXML
    private void close(ActionEvent event) {
        exit();
    }

    public void btnSpeichern(ActionEvent actionEvent) throws IOException { // wirft noch fehlermeldung, muss noch behoben werden [21.6.2022]
       AuswahlController ac = new AuswahlController();
       ac.speichern();


    }
}
