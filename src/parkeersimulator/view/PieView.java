package parkeersimulator.view;

import java.awt.*;
import parkeersimulator.logic.*;

/**
 * @author WaiCheong Ng, Sang Nguyen
 */
public class PieView extends AbstractView {
    private int amountAdHoc;
    private int amountPassCar;
    private int amountEmptySpots;
    private int amountReservationCars;
    private int amountReservationSpots;

    /**
     * Creates the constructor
     * @param Model invoke the overridden methods
     */
    public PieView(Model Model) {
        super(Model);
        setSize(300,300);
    }

    /**
     * Calculate the degrees
     * @param amountCars that are entering the garage
     */
    private int calculateDegrees(double amountCars)
    {
        int degrees;
        double garageSize = 540;

        degrees = (int) (((100 / garageSize) * amountCars) * 3.6);

        return degrees;
    }

    /**
     * Paints the PieChart itself and sets the right colour for the pieView
     */
    protected void paintComponent(Graphics a) {
        super.paintComponent(a);

        amountAdHoc = CarParkView.GetAdHoc();
        amountPassCar = CarParkView.GetParkPass();
        amountReservationCars = CarParkView.GetReservedCars();
        amountReservationSpots = CarParkView.GetReservedSpot();
        amountEmptySpots = 540 - amountPassCar - amountAdHoc - amountReservationCars - amountReservationSpots;

        a.setColor(Color.red);
        a.fillArc(15, 15, 250, 250, 0, calculateDegrees(amountAdHoc));

        a.setColor(Color.decode("#0077FF"));
        a.fillArc(15, 15, 250, 250, calculateDegrees(amountAdHoc), calculateDegrees(amountPassCar));

        a.setColor(Color.magenta);
        a.fillArc(15, 15, 250, 250, calculateDegrees(amountAdHoc) + calculateDegrees(amountPassCar), calculateDegrees(amountReservationSpots));

        a.setColor(Color.green);
        a.fillArc(15, 15, 250, 250, calculateDegrees(amountAdHoc) + calculateDegrees(amountPassCar) + calculateDegrees(amountReservationSpots), calculateDegrees(amountReservationCars));

        a.setColor(Color.white);
        a.fillArc(15, 15, 250, 250, calculateDegrees(amountAdHoc) + calculateDegrees(amountPassCar) + calculateDegrees(amountReservationCars), calculateDegrees(amountEmptySpots));

        updateView();
    }
}