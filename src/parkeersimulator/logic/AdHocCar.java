package parkeersimulator.logic;

import java.util.Random;
import java.awt.*;

/**
 * Creates AdHocCar that extends the Car
 * @author Sang Nguyen, Sjoerd Feenstra, WaiCheong Ng, Jurgen Katoen
 */

public class AdHocCar extends Car {
	private static final Color COLOR=Color.red;

    /**
     * Creates a construcor of the AdHocCar
     * @author Sang Nguyen, Sjoerd Feenstra, WaiCheong Ng, Jurgen Katoen
     */

    public AdHocCar() {
        Random random = new Random();
        int stayMinutes = (int) (15 + random.nextFloat() * 3 * 60);
        this.setMinutesLeft(stayMinutes);
        this.setMinutesTotal(stayMinutes);
        this.setHasToPay(true);
        this.setHasReserved(false);
        this.setHasReducedPrice(false);
    }
    
    public Color getColor(){
    	return COLOR;
    }
}
