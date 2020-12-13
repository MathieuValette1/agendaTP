package agenda;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

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

    private LocalDateTime myEnd;
    public List<LocalDateTime> joursDansEvent = new ArrayList<>();
    public boolean isInDay ; 
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
        this.myDuration = duration;/// En secondes
    }

    /**
     * Tests if an event occurs on a given day
     *
     * @param aDay the day to test
     * @return true if the event occurs on that day, false otherwise
     */
    public boolean isInDay(LocalDate aDay) {
        if (aDay.isBefore(this.getStart().toLocalDate())){
            return false;
        }
        ///int BetweenStartAndEnd = this.getEnd().getDayOfMonth() - myStart.getDayOfMonth();
        long betweenStartAndEnd = ChronoUnit.DAYS.between(this.getStart(), this.getEnd());
        //joursDansEvent.add(myStart);
        for (int i = 0; i <= betweenStartAndEnd; i++) {
            joursDansEvent.add(this.getStart().plus(i, ChronoUnit.DAYS));
            for (LocalDateTime j : joursDansEvent) {
                if (j.toLocalDate().equals(aDay)) {
                   isInDay = true ; 
                }
            }

        }
        if (aDay.equals(this.getEnd().toLocalDate())){
            return true;
        }
        return isInDay ;

    }

    /**
     * @return the myTitle
     */
    public String getTitle() {
        return myTitle;
    }

    @Override
    public String toString() {
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

    public LocalDateTime getEnd() {
        long duree = this.getDuration().toSeconds();
        myEnd = this.getStart().plus(duree, ChronoUnit.SECONDS);
        return myEnd;
    }

}
