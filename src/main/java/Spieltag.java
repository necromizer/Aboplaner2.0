
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

    public Spieltag(String spieltag, LocalDate date) {
        this.spieltag = spieltag;
        localDate=date;
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
   public void meiendeisnahe(String Startdatum, String Enddatum, int Wochentag)
   {    
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
        //String Startdatum = "06 05 2022";
        //String Enddatum = "27 05 2022";
        //Wochentag 1 = Sonntag
        //Wochentag 6 = Freitag
        //int Wochentag = 6;
        Date date1;
        Date date2;
        Date zwischendate;
        ArrayList datearray = new ArrayList();
        int i = 0;
        
            try {
                date1 = myFormat.parse(Startdatum);
                zwischendate = date1;
                date2 = myFormat.parse(Enddatum);
                
                
                long diff = date2.getTime() - date1.getTime();
                int tage = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
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
                

            } catch (ParseException ex) {
                Logger.getLogger(Spieltag.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
    }
   }   
   
   
   
   


