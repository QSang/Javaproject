package Parkeersimulator.view;


import Parkeersimulator.logic.Model;
import Parkeersimulator.logic.*;

import java.awt.*;

public class OvercrowdedView extends AbstractView {

    private int aantalExitCars;
    private int aantalQueueCars;


    private int maxAantalQueue;

    public OvercrowdedView(Model Model) {
        super(Model);
        setSize(300,300);
    }

    public int calculateDegrees(double aantalCars)
    {
        int degrees;
        double garageSize = 540;

        degrees = (int) (((100 / garageSize) * aantalCars) * 3.6);

        return degrees;

    }

    protected void paintComponent(Graphics a) {
        super.paintComponent(a);


        maxAantalQueue = 5;

        if(maxAantalQueue < aantalQueueCars){
            aantalExitCars = aantalQueueCars -2;
        }


        System.out.println("AantalQueueCars :" + aantalQueueCars + " AantalExitCars:" + aantalExitCars);


        a.setColor(Color.white);
        a.fillArc(15, 15, 250, 250, 350, 360);

        a.setColor(Color.blue);
        a.fillArc(15, 15, 250, 250, 0, calculateDegrees(aantalQueueCars));
        a.setColor(Color.green);
        a.fillArc(15, 15, 250, 250, calculateDegrees(aantalQueueCars), calculateDegrees(aantalExitCars));



    }
}