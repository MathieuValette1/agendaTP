package agenda;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive event that terminates after a given date, or after
 * a given number of occurrences
 */
public class FixedTerminationEvent extends RepetitiveEvent {

    LocalDate terminationInclusive;
    long numberOfOccurrences;
    
    /**
     * Constructs a fixed terminationInclusive event ending at a given date
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     * @param terminationInclusive the date when this event ends
     */
    
    
    public FixedTerminationEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency, LocalDate terminationInclusive) {
         super(title, start, duration, frequency);
         this.terminationInclusive = terminationInclusive;
    }

    /**
     * Constructs a fixed termination event ending after a number of iterations
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     * @param numberOfOccurrences the number of occurrences of this repetitive event
     */
    public FixedTerminationEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency, long numberOfOccurrences) {
        super(title, start, duration, frequency);
        this.numberOfOccurrences = numberOfOccurrences;
    }

    /**
     *
     * @return the termination date of this repetitive event
     */
    public LocalDate getTerminationDate() {
        
        // L'évènement possède soit une date de fin, soit un nombre d'occurence
        
        if (this.terminationInclusive != null){
            return this.terminationInclusive;
        }
        else {
           ChronoUnit frequency = this.getFrequency();
           if (frequency == ChronoUnit.DAYS){
               this.terminationInclusive = this.getStart().plus(this.numberOfOccurrences, ChronoUnit.DAYS).toLocalDate();
            }
           else if (frequency == ChronoUnit.WEEKS){
               this.terminationInclusive = this.getStart().plus(this.numberOfOccurrences, ChronoUnit.WEEKS).toLocalDate();
            }
           else{
               this.terminationInclusive = this.getStart().plus(this.numberOfOccurrences, ChronoUnit.MONTHS).toLocalDate();              
           }
           return this.terminationInclusive;
        }
    }

    public long getNumberOfOccurrences() {
        
        // L'évènement possède soit une date de fin, soit un nombre d'occurence
        
        if (this.terminationInclusive == null){
            return this.numberOfOccurrences;
        }
        
        else {
           ChronoUnit frequency = this.getFrequency();
           if (frequency == ChronoUnit.DAYS){
               long nbDeJours = ChronoUnit.DAYS.between(this.terminationInclusive, this.getStart());
               this.numberOfOccurrences = nbDeJours;
            }
           else if (frequency == ChronoUnit.WEEKS){
               long nbDeSemaines = ChronoUnit.WEEKS.between(terminationInclusive, this.getStart());
               this.numberOfOccurrences = nbDeSemaines;
            }
           else{
               long nbDeMois = ChronoUnit.MONTHS.between(terminationInclusive,this.getStart());
               this.numberOfOccurrences = nbDeMois;              
           }
           return this.numberOfOccurrences;
        }
    }
    
        
}
