package parkeersimulator.view;

import java.awt.*;
import parkeersimulator.logic.*;

public class PieView extends AbstractView {
    private int amountAdHoc;
    private int amountPassCar;
    private int amountEmpty;
    private int amountReservedCars;
    private int amountReservedSpots;

    /**
     * Creates the constructor
     * @param Model gives information needed from the simulator
     */
    public PieView(Model Model) {
        super(Model);
        setSize(300,300);
    }

    private int calculateDegrees(double aantalCars)
    {
        int degrees;
        double garageSize = 540;

        degrees = (int) (((100 / garageSize) * aantalCars) * 3.6);

        return degrees;
    }

    /**
     * Paints the PieChart itself
     */
    protected void paintComponent(Graphics a) {
        super.paintComponent(a);

        amountAdHoc = CarParkView.GetAdHoc();
        amountPassCar = CarParkView.GetParkPass();
        amountReservedCars = CarParkView.GetReserveringCars();
        amountReservedSpots = CarParkView.GetReservedSpot();

        amountEmpty = 540 - amountPassCar - amountAdHoc - amountReservedCars - amountReservedSpots;

        a.setColor(Color.white);
        a.fillArc(15, 15, 250, 250, 350, 360);

        a.setColor(Color.red);
        a.fillArc(15, 15, 250, 250, 0, calculateDegrees(amountAdHoc));

        a.setColor(Color.decode("#0077FF"));
        a.fillArc(15, 15, 250, 250, calculateDegrees(amountAdHoc), calculateDegrees(amountPassCar));

        a.setColor(Color.magenta);
        a.fillArc(15, 15, 250, 250, calculateDegrees(amountAdHoc) + calculateDegrees(amountPassCar), calculateDegrees(amountReservedSpots));

        a.setColor(Color.green);
        a.fillArc(15, 15, 250, 250, calculateDegrees(amountAdHoc) + calculateDegrees(amountPassCar) + calculateDegrees(amountReservedSpots),calculateDegrees(amountReservedCars));

        a.setColor(Color.white);
        a.fillArc(15, 15, 250, 250, calculateDegrees(amountAdHoc) + calculateDegrees(amountPassCar) + calculateDegrees(amountReservedSpots), calculateDegrees(amountEmpty));

        updateView();
    }
}