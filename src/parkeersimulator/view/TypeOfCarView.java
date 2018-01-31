package parkeersimulator.view;

import java.awt.*;
import javax.swing.*;

import parkeersimulator.logic.*;

/**
 * Create a view of types of car
 * @author Sang Nguyen, Sjoerd Feenstra, Jurgen Katoen
 */

public class TypeOfCarView extends AbstractView{
    private JTextField adHoc;
    private JTextField passHolder;
    private JTextField reservationSpot;
    private JTextField reservedCar;
    private JTextField empty;

    public TypeOfCarView(Model model) {
        super(model);

        /**
         * Create a JTextField and JLabel for the adHoc, passHolder, reservationSpot, empty Spots in the garage
         **/

        JLabel adHocLabel = new JLabel("Percentage of Adhoc Cars:                ");
        adHoc = new JTextField("   0%  ");
        adHoc.setColumns(4);
        adHoc.setEditable(false);
        adHoc.setBackground(Color.RED);
        adHoc.setHorizontalAlignment(JTextField.CENTER);
        adHoc.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(adHocLabel);
        add(adHoc);

        JLabel passHolderLabel = new JLabel("Percentage of Parking Pass Cars:   ");
        passHolder = new JTextField("   0%  ");
        passHolder.setColumns(4);
        passHolder.setEditable(false);
        passHolder.setBackground(Color.decode("#0077FF"));
        passHolder.setHorizontalAlignment(JTextField.CENTER);
        passHolder.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(passHolderLabel);
        add(passHolder);

        JLabel reservedSpotLabel = new JLabel("Percentage of Reservation Spots:    ");
        reservationSpot = new JTextField("   0%  ");
        reservationSpot.setColumns(4);
        reservationSpot.setEditable(false);
        reservationSpot.setBackground(Color.MAGENTA);
        reservationSpot.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(reservedSpotLabel);
        add(reservationSpot);

        JLabel reservedCarLabel = new JLabel("Percentage of Reserving Cars:         ");
        reservedCar = new JTextField("  0%  ");
        reservedCar.setColumns(4);
        reservedCar.setEditable(false);
        reservedCar.setBackground(Color.green);
        reservedCar.setHorizontalAlignment(JTextField.CENTER);
        reservedCar.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(reservedCarLabel);
        add(reservedCar);

        JLabel emptySpotsLabel = new JLabel("Percentage of Empty Spots:               ");
        empty = new JTextField("  100%  ");
        empty.setColumns(4);
        empty.setEditable(false);
        empty.setBackground(Color.white);
        empty.setHorizontalAlignment(JTextField.CENTER);
        empty.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(emptySpotsLabel);
        add(empty);
    }

    /**
     * Method updateView for updating the view
     */

    public void updateView() {
        calculatePercentage();
    }

    /**
     * Method calculatePercentage, calculates the percentages.
     */

    public void calculatePercentage() {
        double garageSize = 540;
        double AdHoc = CarParkView.GetAdHoc();
        double PassCar = CarParkView.GetParkPass();
        double ReservedSpot = CarParkView.GetReservedSpot();
        double ReservingCars = CarParkView.GetReservedCars();

        int AdHocCar;
        int PassParkCar;
        int ReservedSpots;
        int ReservingCar;

        AdHocCar = (int) (((100 / garageSize) * AdHoc));
        PassParkCar = (int) (((100 / garageSize) * PassCar));
        ReservedSpots = (int) (((100 / garageSize) * ReservedSpot));
        ReservingCar = (int) (((100 / garageSize) * ReservingCars));

        int EmptySpots = (int) (540 - AdHoc - PassCar - ReservedSpot  - ReservingCars);
        int Empty = (int) (((100 / garageSize) * EmptySpots));

        String a = String.valueOf(AdHocCar);
        String p = String.valueOf(PassParkCar);
        String Rs = String.valueOf(ReservedSpots);
        String r = String.valueOf(ReservingCar);
        String e = String.valueOf(Empty);

        adHoc.setText("   " + a + "%");
        passHolder.setText("   " + p + "%");
        reservationSpot.setText("   "+ Rs +"%");
        reservedCar.setText("   " + r + "%");
        empty.setText("   " + e + "%");

    }
}