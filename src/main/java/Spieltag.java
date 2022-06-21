
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

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
   LocalDate localDate;
   ArrayList datearray;
   int tageausgabe;

    public int getTageausgabe() {
        return tageausgabe;
    }

    public Spieltag(String spieltag, LocalDate date) {
        this.spieltag = spieltag;
        localDate=date;
    }
    public ArrayList getDateArray()
    {
        return datearray;
    }
    public Spieltag() {
    }

    //getter methoden

   
    
    //public void spielerZuteilenEinzel(Person person1, Person person2){
      
    //}
    //public void spielerZuteilenDoppel(Person person1, Person person2, Person person3, Person person4 ){
        
    //}
    
    
    public String getSpieltag() {
        return spieltag;
    }
    
    public void setSpieltag(String spieltag) {
        this.spieltag = spieltag;
    }
   
    //Diese Klasse gibt aus einem Startdatum, einem Enddatum und dem Wochentag an dem gespielt wird alle Tage an denen gespielt wird zurück
   public void arrayausrechnen(Date Startdatum, Date Enddatum, int Wochentag)
   {    
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
        //String Startdatum = "06 05 2022";
        //String Enddatum = "27 05 2022";
        //Wochentag 1 = Sonntag
        //Wochentag 6 = Freitag
        //int Wochentag = 6;
        Date date1 = Startdatum;
        Date date2 = Enddatum;
        Date zwischendate;
        datearray = new ArrayList();
        int i = 0;
        
        //date1 = myFormat.parse(Startdatum);
        zwischendate = date1;
        //date2 = myFormat.parse(Enddatum); nur benötigt bei String statt date
        long diff = date2.getTime() - date1.getTime();
        int tage = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        tageausgabe = tage;
        Calendar c = Calendar.getInstance();
        while (tage != 0)
        {
            c.setTime(zwischendate);
            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            if(dayOfWeek == Wochentag)
            {
                datearray.add(zwischendate) ;
                i++;
                
                
            }
            c.add(Calendar.DATE, 1);
            zwischendate = c.getTime();
            tage --;
            
            
        }
        System.out.println(datearray);
            
            
    }


    public LocalDate getLocalDate() {
        return localDate;
    }
    public String getnameSpieltag(){
        return spieltag;
    }
}
   
   
   
   


