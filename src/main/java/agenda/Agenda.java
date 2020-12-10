package agenda;

import java.time.LocalDate;
import java.util.*;
import java.time.temporal.ChronoUnit;

/**
 * Description : An agenda that stores events
 */
public class Agenda {
    
    public List <Event> myEvents = new ArrayList<>();
    public List <Event> eventsInDay = new ArrayList<>(); 
    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    public void addEvent(Event e) {
        myEvents.add(e); 
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        for ( Event e : myEvents ) {
            if (e.isInDay(day)) {
                eventsInDay.add(e) ;
            }
        }   
        return eventsInDay ; 
    }
    
     /**
     * Trouver les événements de l'agenda en fonction de leur titre
     * @param title le titre à rechercher
     * @return les événements qui ont le même titre
     */
    public List<Event> findByTitle(String title) {
        List <Event> eventsWithSameName = new ArrayList<>();
        for (Event e : myEvents) {
            if (title == e.getTitle()){
                eventsWithSameName.add(e) ; 
            }
        }
        return eventsWithSameName ; 
    }
    
    /**
     * Déterminer s’il y a de la place dans l'agenda pour un événement
     * @param e L'événement à tester (on se limitera aux événements simples)
     * @return vrai s’il y a de la place dans l'agenda pour cet événement
     */
    public boolean isFreeFor(Event e) {
        boolean resultat = true;
        long durée = e.getDuration().toSeconds();
        for (Event ev: myEvents){
            if (e.getStart().isAfter(ev.getStart()) && e.getStart().plus(durée, ChronoUnit.SECONDS).isBefore(ev.getStart().plus(ev.getDuration().toSeconds(), ChronoUnit.SECONDS)))
                resultat = false;
        }
        
        return resultat;
        
    }
}