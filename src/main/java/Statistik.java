import java.awt.Component;
import javafx.scene.control.TableColumn;
import javax.swing.table.TableCellRenderer;

// @author Sebastian

public class Statistik
{
    int anzahlEinsaetze;
    int anzahlFeiertage;
    String [] VarianzSpieler;
    int laengstePause;
    
    

    public Statistik(int anzahlEinsaetze, int anzahlFeiertage, String[] VarianzSpieler, int laengstePause) {
        this.anzahlEinsaetze = anzahlEinsaetze;
        this.anzahlFeiertage = anzahlFeiertage;
        this.VarianzSpieler = VarianzSpieler;
        this.laengstePause = laengstePause;
    }

    Statistik() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public int getAnzahlEinsaetze() {
        return anzahlEinsaetze;
    }

    public void setAnzahlEinsaetze(int anzahlEinsaetze) {
        this.anzahlEinsaetze = anzahlEinsaetze;
    }

    public int getAnzahlFeiertage() {
        return anzahlFeiertage;
    }

    public void setAnzahlFeiertage(int anzahlFeiertage) {
        this.anzahlFeiertage = anzahlFeiertage;
    }

    public String[] getVarianzSpieler() {
        return VarianzSpieler;
    }

    public void setVarianzSpieler(String[] VarianzSpieler) {
        this.VarianzSpieler = VarianzSpieler;
    }

    public int getLaengstePause() {
        return laengstePause;
    }

    public void setLaengstePause(int laengstePause) {
        this.laengstePause = laengstePause;
    }
    
        public void einfaerben(Statistik [] list)
    {
        //faerbt beim Spielplan die jeweiligen Kaesten ein, damit man leichter erkennen kann, welche Spieler mit wem spielen, so irgendwie
        // = Color.BLACK;
    }
     
        
        public void einfaerbetest()
    {
        //faerbt beim Spielplan die jeweiligen Kästen ein, damit man leichter erkennen kann, welche Spieler mit wem spielen, so irgendwie
        // = Color.BLACK;
        TableColumn tcName_statistik = new TableColumn();
        
        
        int player_id = 1;
        if (player_id == 1)
        {
            
        }
        
       
    }
     
        


 

        
        
    public void varianz()
    {
        //Was soll varianz alles ausrechnen?
        //Spieler 1 spielte so oft mit spieler 2, mit spieler 3, mit spieler 4
        //h�chste Spielpause
        //meiste Tage hintereinander
        //Eins�tze Feiertage
        //Eins�tze insgesamt
        
        
    }
}