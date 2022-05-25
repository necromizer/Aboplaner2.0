
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.Person;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sebas
 */

public class Spieltag {
   String spieltag;

    public Spieltag(String spieltag) {
        this.spieltag = spieltag;
    }
    
    public void spielerZuteilenEinzel(Person person1, Person person2, Person person3, Person person4 ){
    
    }
    
    
    public String getSpieltag() {
        return spieltag;
    }

    public void setSpieltag(String spieltag) {
        this.spieltag = spieltag;
    }
   
    //Diese Klasse gibt aus einem Startdatum, einem Enddatum und einem Spieltag die Anzahl der Spieltage zurück
   public void meiendeisnahe(String Startdatum, String Enddatum, String Spieltag)
   {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
        Startdatum = "23 01 1997";
        Enddatum = "27 04 1997";
       
        LocalDate date1 = LocalDate.parse(Startdatum, dtf);
        LocalDate date2 = LocalDate.parse(Enddatum, dtf);
        long daysBetween = Duration.between(date1, date2).toDays();
        System.out.println ("Days: " + daysBetween);
   }
   
   
   
   
}

