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
        int BetweenStartAndEnd = this.getEnd().getDayOfMonth() - myStart.getDayOfMonth();
        joursDansEvent.add(myStart);
        for (int i = 0; i <= BetweenStartAndEnd; i++) {
            joursDansEvent.add(myStart.plus(i, ChronoUnit.DAYS));
            for (LocalDateTime j : joursDansEvent) {
                if (j.toLocalDate().equals(aDay)) {
                   isInDay = true ; 
                }
            }

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
        myEnd = this.getStart().plusDays(this.getDuration().toDays());
        return myEnd;
    }

}
