/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sebas
 */
public class Daten {
    String Name;
    int anzahlfeiertage;
    int anzahlgesamteinsätze;
    int Spielervarianz;
    int laengstePause;

    public Daten(String Name, int anzahlfeiertage, int anzahlgesamteinsätze, int Spielervarianz, int laengstePause) {
        super();
        this.Name = Name;
        this.anzahlfeiertage = anzahlfeiertage;
        this.anzahlgesamteinsätze = anzahlgesamteinsätze;
        this.Spielervarianz = Spielervarianz;
        this.laengstePause = laengstePause;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAnzahlfeiertage() {
        return anzahlfeiertage;
    }

    public void setAnzahlfeiertage(int anzahlfeiertage) {
        this.anzahlfeiertage = anzahlfeiertage;
    }

    public int getAnzahlgesamteinsätze() {
        return anzahlgesamteinsätze;
    }

    public void setAnzahlgesamteinsätze(int anzahlgesamteinsätze) {
        this.anzahlgesamteinsätze = anzahlgesamteinsätze;
    }

    public int getSpielervarianz() {
        return Spielervarianz;
    }

    public void setSpielervarianz(int Spielervarianz) {
        this.Spielervarianz = Spielervarianz;
    }

    public int getLaengstePause() {
        return laengstePause;
    }

    public void setLaengstePause(int laengstePause) {
        this.laengstePause = laengstePause;
    }

    
}
