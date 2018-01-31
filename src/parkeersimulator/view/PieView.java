package parkeersimulator.view;

import java.awt.*;
import parkeersimulator.logic.*;

public class PieView extends AbstractView {
    private int aantalAdHoc;
    private int aantalPassCar;
    private int aantalEmpty;
    private int aantalReserveringsCars;
    private int aaantalReservationSpots;
    
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
        aantalReserveringsCars = CarParkView.GetReserveringCars();
        aaantalReservationSpots = CarParkView.GetReservedSpot();
        aantalEmpty = 540 - aantalPassCar - aantalAdHoc - aantalReserveringsCars - aaantalReservationSpots;

        a.setColor(Color.red);
        a.fillArc(15, 15, 250, 250, 0, calculateDegrees(aantalAdHoc));

        a.setColor(Color.decode("#0077FF"));
        a.fillArc(15, 15, 250, 250, calculateDegrees(aantalAdHoc), calculateDegrees(aantalPassCar));

        a.setColor(Color.magenta);
        a.fillArc(15, 15, 250, 250, calculateDegrees(aantalAdHoc) + calculateDegrees(aantalPassCar), calculateDegrees(aaantalReservationSpots));

        a.setColor(Color.green);
        a.fillArc(15, 15, 250, 250, calculateDegrees(aantalAdHoc) + calculateDegrees(aantalPassCar) + calculateDegrees(aaantalReservationSpots), calculateDegrees(aantalReserveringsCars));

        a.setColor(Color.white);
        a.fillArc(15, 15, 250, 250, calculateDegrees(aantalAdHoc) + calculateDegrees(aantalPassCar) + calculateDegrees(aantalReserveringsCars), calculateDegrees(aantalEmpty));

        updateView();
    }
}