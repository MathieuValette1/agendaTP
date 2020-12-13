package agenda;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive Event
 */
public class RepetitiveEvent extends Event {
    /**
     * Constructs a repetitive event
     *
     * @param title the title of this event
     * @param start the start of this event
     * @param duration myDuration in seconds
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     */
    
    ChronoUnit frequency;
    boolean aLieu = true;
    LocalDate exceptionDate;
    public List<LocalDate> myExceptions = new ArrayList<>();

    
    
    public RepetitiveEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency) {
        super(title, start, duration);
        this.frequency = frequency;
    }

    /**
     * Adds an exception to the occurrence of this repetitive event
     *
     * @param date the event will not occur at this date
     */
    public void addException(LocalDate date) {
        myExceptions.add(date) ; }
    
  /*  public boolean testExceptionDate(LocalDate date){
        if (date.equals(exceptionDate)){
            aLieu = false;
        }
        else{
            aLieu = true;
        }
        return aLieu;
    } /*
    
   
  /*  @Override
    public boolean isInDay(LocalDate aDay) {
        
        this.aLieu = this.testExceptionDate(aDay);
        
        if (aLieu){
            long durée = this.getDuration().getSeconds();
            if (!aDay.isBefore(this.getStart().toLocalDate()) && !aDay.isAfter(this.getStart().plus(durée,  ChronoUnit.SECONDS).toLocalDate())){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
    
    */
    /**
     *
     * @return the type of repetition
     */
   
    public ChronoUnit getFrequency() {
        return this.frequency; 
    }   
    
    @Override
    public boolean isInDay (LocalDate aDay) {
        if (myExceptions.contains(aDay)) {
            return false ;
        }
        return true ; 
    }  
    

}
