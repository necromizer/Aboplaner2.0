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
    int anzahl_gesamteins�tze;
    int Spielervarianz;
    int l�ngste_Pause;

    public Daten(String Name, int anzahl_feiertage, int anzahl_gesamteins�tze, int Spielervarianz, int l�ngste_Pause) {
        super();
        this.Name = Name;
        this.anzahl_feiertage = anzahl_feiertage;
        this.anzahl_gesamteins�tze = anzahl_gesamteins�tze;
        this.Spielervarianz = Spielervarianz;
        this.l�ngste_Pause = l�ngste_Pause;
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

    public int getAnzahl_gesamteins�tze() {
        return anzahl_gesamteins�tze;
    }

    public void setAnzahl_gesamteins�tze(int anzahl_gesamteins�tze) {
        this.anzahl_gesamteins�tze = anzahl_gesamteins�tze;
    }

    public int getSpielervarianz() {
        return Spielervarianz;
    }

    public void setSpielervarianz(int Spielervarianz) {
        this.Spielervarianz = Spielervarianz;
    }

    public int getL�ngste_Pause() {
        return l�ngste_Pause;
    }

    public void setL�ngste_Pause(int l�ngste_Pause) {
        this.l�ngste_Pause = l�ngste_Pause;
    }
    
}
