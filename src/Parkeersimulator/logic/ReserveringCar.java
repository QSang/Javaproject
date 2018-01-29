package Parkeersimulator.logic;
import java.awt.Color;
import java.util.Random;

public class ReserveringCar extends Car {
    private static final Color COLOR=Color.GREEN;

    /*
    Hier wordt een reservering aangemaakt en een kleur toegevoegd.
     */

    public ReserveringCar(){
        Random random = new Random();
        int aankomsttijd = (int) (random.nextFloat() * 3 * 60 );
        int aantalminuten = (int) (20 + random.nextFloat() * 3 * 60) + aankomsttijd;
        this.setMinutesLeft(aantalminuten);
        this.setArrivalTime(aankomsttijd);
        this.setHasToPay(true);
    }


    public Color getColor(){
        return COLOR;
    }

}
