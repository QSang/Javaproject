package Parkeersimulator.logic;

import java.util.Random;
import java.awt.*;
import Parkeersimulator.logic.*;
import Parkeersimulator.view.*;
import Parkeersimulator.controller.*;


public class AdHocCar extends Car {
	private static final Color COLOR=Color.red;

    public AdHocCar() {
        Random random = new Random();
        int stayMinutes = (int) (15 + random.nextFloat() * 3 * 60);
        this.setMinutesLeft(stayMinutes);
        this.setMinutesTotal(stayMinutes);
        this.setHasToPay(true);
        this.setHasReserved(false);
        this.setHasReducedPrice(false);
        Model.addCashIndex();
    }
    
    public Color getColor(){
    	return COLOR;
    }
}
