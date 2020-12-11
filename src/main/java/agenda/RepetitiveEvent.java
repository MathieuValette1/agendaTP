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
        /* MARCHE PAS 
        ChronoUnit f = this.getFrequency();
        LocalDateTime d = date.atStartOfDay();
        if (f == ChronoUnit.DAYS) { 
            long nbOccurences = (ChronoUnit.DAYS.between(this.getStart(), d));
            Event evenementAvant = new FixedTerminationEvent (this.getTitle(), this.getStart(),this.getDuration() ,this.getFrequency(), nbOccurences);
            Event evenementApres = new RepetitiveEvent(this.getTitle(), (d.plusDays(1)) ,this.getDuration() ,this.getFrequency()); }
        else if (f == ChronoUnit.MONTHS) { 
            long nbOccurences = (ChronoUnit.MONTHS.between(this.getStart(), d)); 
            Event evenementAvant = new FixedTerminationEvent (this.getTitle(), this.getStart(),this.getDuration() ,this.getFrequency(), nbOccurences);
            Event evenementApres = new RepetitiveEvent(this.getTitle(), (d.plusMonths(1)) ,this.getDuration() ,this.getFrequency()); }
        
        else {
            long nbOccurences = (ChronoUnit.WEEKS.between(this.getStart(), d)); 
            Event evenementAvant = new FixedTerminationEvent (this.getTitle(), this.getStart(),this.getDuration() ,this.getFrequency(), nbOccurences);
            Event evenementApres = new RepetitiveEvent(this.getTitle(), (d.plusWeeks(1)) ,this.getDuration() ,this.getFrequency()); }
        */
        this.exceptionDate = date;
        } 
    
    public boolean testExceptionDate(LocalDate date){
        if (date.equals(exceptionDate)){
            aLieu = false;
        }
        else{
            aLieu = true;
        }
        return aLieu;
    }
    
    @Override
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
    /**
     *
     * @return the type of repetition
     */
    public ChronoUnit getFrequency() {
        return this.frequency;    
    }

}
