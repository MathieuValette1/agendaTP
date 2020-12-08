package agenda;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Event {

    /**
     * The myTitle of this event
     */
    private String myTitle;
    
    /**
     * The starting time of the event
     */
    private LocalDateTime myStart;

    /**
     * The durarion of the event 
     */
    private Duration myDuration;


    /**
     * Constructs an event
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     */
    public Event(String title, LocalDateTime start, Duration duration) {
        this.myTitle = title;
        this.myStart = start;
        this.myDuration = duration;
    }

    /**
     * Tests if an event occurs on a given day
     *
     * @param aDay the day to test
     * @return true if the event occurs on that day, false otherwise
     */
    public boolean isInDay(LocalDate aDay) {
  
        if (this.getStart().toLocalDate().equals(aDay)){
            return true;
        }
        else{
            // On calcule le nombre de jours entre le début et la fin et on test chaque jour
            double durée = this.getDuration().toDays(); // La durée est en seconde donc on la passe en jour
            long nbDeJours = ChronoUnit.DAYS.between(this.getStart().toLocalDate(), this.getStart().toLocalDate().plus((long)durée, ChronoUnit.DAYS));
            for (long i = 0; i < nbDeJours; i++){
                if (this.getStart().toLocalDate().plus(i, ChronoUnit.DAYS).equals(aDay)){
                    return true;
                    //// C'EST PAS LA BONNE ID2E BORDEL DE MERDE
                }
            }
            return false;
        } 
    }
   
    /**
     * @return the myTitle
     */
    public String getTitle() {
        return myTitle;
    }
    
    @Override
    public String toString(){
        return this.getTitle();
    }

    /**
     * @return the myStart
     */
    public LocalDateTime getStart() {
        return myStart;
    }


    /**
     * @return the myDuration
     */
    public Duration getDuration() {
        return myDuration;
    }

   
    
}
