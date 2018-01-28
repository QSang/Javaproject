package Parkeersimulator.view;

import java.awt.*;
import Parkeersimulator.logic.*;

public class PieView extends AbstractView {
    private int aantalAdHoc;
    private int aantalPassCar;
    private int aantalEmpty;

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

        aantalAdHoc = CarParkView.GetAdHoc();
        aantalPassCar = CarParkView.GetParkPass();
        aantalEmpty = 540 - aantalPassCar - aantalAdHoc;

        a.setColor(Color.red);
        a.fillArc(15, 15, 250, 250, 0, calculateDegrees(aantalAdHoc));

        a.setColor(Color.decode("#0077FF"));
        a.fillArc(15, 15, 250, 250, calculateDegrees(aantalAdHoc), calculateDegrees(aantalPassCar));

        a.setColor(Color.white);
        a.fillArc(15, 15, 250, 250, calculateDegrees(aantalAdHoc) + calculateDegrees(aantalPassCar), calculateDegrees(aantalEmpty));

        updateView();
    }
}