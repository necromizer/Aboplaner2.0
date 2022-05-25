import javafx.scene.control.TableColumn;

// @author Sebastian

public class Statistik
{
    int anzahlEinsätze;
    int anzahlFeiertage;
    String [] VarianzSpieler;
    int laengstePause;
    
    

    public Statistik(int anzahlEinsätze, int anzahlFeiertage, String[] VarianzSpieler, int laengstePause) {
        this.anzahlEinsätze = anzahlEinsätze;
        this.anzahlFeiertage = anzahlFeiertage;
        this.VarianzSpieler = VarianzSpieler;
        this.laengstePause = laengstePause;
    }

    Statistik() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    public int getAnzahlEinsätze() {
        return anzahlEinsätze;
    }

    public void setAnzahlEinsätze(int anzahlEinsätze) {
        this.anzahlEinsätze = anzahlEinsätze;
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
    
        public void einfärben(Statistik [] list)
    {
        //färbt beim Spielplan die jeweiligen Kästen ein, damit man leichter erkennen kann, welche Spieler mit wem spielen, so irgendwie
        // = Color.BLACK;
    }
     
        
        public void einfärbetest()
    {
        //färbt beim Spielplan die jeweiligen Kästen ein, damit man leichter erkennen kann, welche Spieler mit wem spielen, so irgendwie
        // = Color.BLACK;
        TableColumn tcName_statistik = new TableColumn();
        tcName_statistik.setText("test123");
       
    }
        
        
    public void varianz()
    {
        //rechnet aus wer mit wem wie oft gespielt hat, so irgendwie
    }
}