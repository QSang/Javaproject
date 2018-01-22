package Parkeersimulator;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public final class Reservations {
    private static HashMap<String, ArrayList<Location>> reservations;
    private static HashMap<String, Color> colors;
    /*
    Constructor die de hashmaps aanmaakt.
     */
    public Reservations() {
        reservations = new HashMap<>();
        colors = new HashMap<>();
    }

    /*
    Methode om een reservering toe te voegen voor een klant.
     */
    public void addReservation(String klantNaam, Color color){
        colors.put(klantNaam, color);
    }

    /*
    Methode om de kleur van een klant te returnen op basis van zijn naam.
     */
    public Color getColor(String klantNaam){
        return colors.get(klantNaam);
    }
    public ArrayList<Location> getKlantReserveringen(String klantNaam){
        return reservations.get(klantNaam);
    }
    /*
    Methode om de reserveringen te returnen.
     */
    public HashMap<String, ArrayList<Location>> getReservations() {
        return reservations;
    }

}
