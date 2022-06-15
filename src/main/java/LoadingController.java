/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Platform.exit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author schei
 */
public class LoadingController implements Initializable {

    @FXML
    private Button btn_abbruch;
    @FXML
    private ImageView iv;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        AuswahlController ac = new AuswahlController();
        ac.spielweise = ac.getSpielweise();
        SpielplanUIController spuic = new SpielplanUIController();
        spuic.getInputData(ac.getSpielerarray(), ac.getSpieleranzahl(), ac.getStartdatumdate(), ac.getEnddatumdate(), ac.getWochentag(), ac.getSpielweise(), ac.getFeiertage());

    }    

    @FXML
    private void abbruch(ActionEvent event) throws IOException {
        /**
      Stage s=(Stage)btn_abbruch.getScene().getWindow();
      s.close();
         */
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/SpielplanUI.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Loading");
        stage=(Stage)btn_abbruch.getScene().getWindow();
        stage.close();
    }
    @FXML
    void clicked(MouseEvent event) throws IOException {

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("SpielplanUI.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Spielplan");
        stage.show();
        stage = (Stage)btn_abbruch.getScene().getWindow();
        stage.close();
        AuswahlController ac = new AuswahlController();

    }
    
}
