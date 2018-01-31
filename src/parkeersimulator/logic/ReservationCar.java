package parkeersimulator.logic;
import java.awt.Color;
import java.util.Random;

    /**
     * @author Jurgen Katoen
     */

public class ReservationCar extends Car {
    private static final Color COLOR=Color.GREEN;

    /**
    * Create a reservation and added a colour.
    */

    public ReservationCar(){
        Random random = new Random();
        int arrivalTime = (int) (random.nextFloat() * 3 * 60 );
        int minutes = (int) (20 + random.nextFloat() * 3 * 60) + arrivalTime;
        this.setMinutesLeft(minutes);
        this.setArrivalTime(arrivalTime);
        this.setHasToPay(true);
    }

    public Color getColor(){
        return COLOR;
    }
}
