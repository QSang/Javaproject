package parkeersimulator.view;

import java.awt.*;
import javax.swing.*;

import parkeersimulator.logic.*;

public class TypeOfCarView extends AbstractView{
    private JTextField TadHoc;
    private JTextField TpassHolder;
    private JTextField TreservedSpots;
    private JTextField TreservedCar;
    private JTextField Tempty;

    public TypeOfCarView(Model model) {
        super(model);

        JLabel adHoc = new JLabel("Percentage of Adhoc Cars:                ");
        TadHoc = new JTextField("   0%  ");
        TadHoc.setColumns(4);
        TadHoc.setEditable(false);
        TadHoc.setBackground(Color.RED);
        TadHoc.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(adHoc);
        add(TadHoc);

        /*
         * Create a JTextField and JLabel for the ParkingPass Cars
         */
        JLabel passHolder = new JLabel("Percentage of Parking Pass Cars:   ");
        TpassHolder = new JTextField("   0%  ");
        TpassHolder.setColumns(4);
        TpassHolder.setEditable(false);
        TpassHolder.setBackground(Color.decode("#0077FF"));
        TpassHolder.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(passHolder);
        add(TpassHolder);

        JLabel reservedSpots = new JLabel("Percentage of Reserving Spots:         ");
        TreservedSpots = new JTextField("  0%  ");
        TreservedSpots.setColumns(4);
        TreservedSpots.setEditable(false);
        TreservedSpots.setBackground(Color.magenta);
        TreservedSpots.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(reservedSpots);
        add(TreservedSpots);

        JLabel reservedCars = new JLabel("Percentage of Reserved Cars:         ");
        TreservedCar = new JTextField("  0%  ");
        TreservedCar.setColumns(4);
        TreservedCar.setEditable(false);
        TreservedCar.setBackground(Color.green);
        TreservedCar.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(reservedCars);
        add(TreservedCar);

        /*
         * Create a JTextField and JLabel for the Empty Spots in the garage
         */
        JLabel emptySpots = new JLabel("Percentage of Empty Spots:           ");
        Tempty = new JTextField("  100%  ");
        Tempty.setColumns(4);
        Tempty.setEditable(false);
        Tempty.setBackground(Color.white);
        Tempty.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(emptySpots);
        add(Tempty);

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
        double adHoc = CarParkView.GetAdHoc();
        double passCar = CarParkView.GetParkPass();
        double reserveCars = CarParkView.GetReserveringCars();
        double reservedSpots = CarParkView.GetReservedSpot();

        int adHocCar;
        int passParkCar;
        int reservedCar;
        int reservedCarSpots;

        int EmptySpots = (int) ((int) 540 - adHoc - passCar - reserveCars - reservedSpots);
        int Empty = (int) (((100 / garageSize) * EmptySpots));

        adHocCar = (int) (((100 / garageSize) * adHoc));
        passParkCar = (int) (((100 / garageSize) * passCar));
        reservedCar = (int) (((100 / garageSize) * reserveCars));
        reservedCarSpots = (int) (((100 / garageSize) * reservedSpots));

        String a = String.valueOf(adHocCar);
        String p = String.valueOf(passParkCar);
        String s = String.valueOf(reservedCarSpots);
        String r = String.valueOf(reservedCar);
        String e = String.valueOf(Empty);

        TadHoc.setText("   " + a + "%");
        TpassHolder.setText("   " + p + "%");
        Tempty.setText("   " + e + "%");
        TreservedCar.setText("   " + r + "%");
        TreservedSpots.setText("   " + s + "%");


    }
    }