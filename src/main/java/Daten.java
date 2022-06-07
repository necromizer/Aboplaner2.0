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
    int anzahl_feiertage;
    int anzahl_gesamteinsätze;
    int Spielervarianz;
    int längste_Pause;

    public Daten(String Name, int anzahl_feiertage, int anzahl_gesamteinsätze, int Spielervarianz, int längste_Pause) {
        super();
        this.Name = Name;
        this.anzahl_feiertage = anzahl_feiertage;
        this.anzahl_gesamteinsätze = anzahl_gesamteinsätze;
        this.Spielervarianz = Spielervarianz;
        this.längste_Pause = längste_Pause;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAnzahl_feiertage() {
        return anzahl_feiertage;
    }

    public void setAnzahl_feiertage(int anzahl_feiertage) {
        this.anzahl_feiertage = anzahl_feiertage;
    }

    public int getAnzahl_gesamteinsätze() {
        return anzahl_gesamteinsätze;
    }

    public void setAnzahl_gesamteinsätze(int anzahl_gesamteinsätze) {
        this.anzahl_gesamteinsätze = anzahl_gesamteinsätze;
    }

    public int getSpielervarianz() {
        return Spielervarianz;
    }

    public void setSpielervarianz(int Spielervarianz) {
        this.Spielervarianz = Spielervarianz;
    }

    public int getLängste_Pause() {
        return längste_Pause;
    }

    public void setLängste_Pause(int längste_Pause) {
        this.längste_Pause = längste_Pause;
    }
    
}
