package parkeersimulator.view;

import java.awt.*;
import javax.swing.*;

import parkeersimulator.logic.*;

public class TypeOfCarView extends AbstractView{
    private JTextField adHoc;
    private JTextField passHolder;
    private JTextField reservedCar;
    private JTextField empty;
    private JTextField reservationSpot;

    public TypeOfCarView(Model model) {
        super(model);

        JLabel adHocLabel = new JLabel("Percentage of Adhoc Cars:                ");
        adHoc = new JTextField("   0%  ");
        adHoc.setColumns(4);
        adHoc.setEditable(false);
        adHoc.setBackground(Color.RED);
        adHoc.setHorizontalAlignment(JTextField.CENTER);
        adHoc.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(adHocLabel);
        add(adHoc);

        /*
         * Create a JTextField and JLabel for the ParkingPass Cars
         */
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

        /*
         * Create a JTextField and JLabel for the Empty Spots in the garage
         */
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
     * Method updateView for updating the view each time something changes
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
        double ReservingCars = CarParkView.GetReserveringCars();
        double ReservedSpot = CarParkView.GetReservedSpot();

        int AdHocCar;
        int PassParkCar;
        int ReservedSpots;
        int ReservingCar;

        int EmptySpots = (int) ((int) 540 - AdHoc - PassCar - ReservedSpot  - ReservingCars);
        int Empty = (int) (((100 / garageSize) * EmptySpots));

        AdHocCar = (int) (((100 / garageSize) * AdHoc));
        PassParkCar = (int) (((100 / garageSize) * PassCar));
        ReservedSpots = (int) (((100 / garageSize) * ReservedSpot));
        ReservingCar = (int) (((100 / garageSize) * ReservingCars));

        String a = String.valueOf(AdHocCar);
        String p = String.valueOf(PassParkCar);
        String Rs = String.valueOf(ReservedSpots);
        String r = String.valueOf(ReservingCar);
        String e = String.valueOf(Empty);

        adHoc.setText("   " + a + "%");
        passHolder.setText("   " + p + "%");
        empty.setText("   " + e + "%");
        reservationSpot.setText("   "+ Rs +"%");
        reservedCar.setText("   " + r + "%");

    }
}