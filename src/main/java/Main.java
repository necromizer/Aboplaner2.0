import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
        System.out.println("hello");
    }

    @Override
    public void start(Stage primaryStage) throws IOException {


      InputStream p = new FileInputStream("NutzungsbedingungenVorhanden.txt");

        BufferedReader reader = new BufferedReader(new InputStreamReader(p));
        String s = reader.readLine();

        FileWriter fw = new FileWriter("NutzungsbedingungenVorhanden.txt");
        Stage stage = new Stage();
        if (s==null)
        {
            fw.write("false");
            fw.close();

            Parent root = FXMLLoader.load(getClass().getResource("/Nutzungsbedingungen.fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource("/SpielplanUI.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.setTitle("Nutzungsbedingungen");

        }
        else{
            if (s.equals("false")){
                Parent root = FXMLLoader.load(getClass().getResource("/Nutzungsbedingungen.fxml"));
                //Parent root = FXMLLoader.load(getClass().getResource("/SpielplanUI.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                stage.setTitle("Nutzungsbedingungen");
                
            }
            else if (s.equals("true")){
                Parent root = FXMLLoader.load(getClass().getResource("/Auswahl.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                stage.setTitle("Auswahl");
            }
        }




    }
}
