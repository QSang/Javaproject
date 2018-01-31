package parkeersimulator.view;

import java.awt.*;
import javax.swing.*;

import parkeersimulator.logic.*;

public class TypeOfCarView extends AbstractView{
    private JTextField TadHoc;
    private JTextField TpassHolder;
    private JTextField TreservingCar;
    private JTextField Tempty;

    public TypeOfCarView(Model model) {
        super(model);

        JLabel LadHoc = new JLabel("Percentage of Adhoc Cars:                ");
        TadHoc = new JTextField("   0%  ");
        TadHoc.setColumns(4);
        TadHoc.setEditable(false);
        TadHoc.setBackground(Color.RED);
        TadHoc.setHorizontalAlignment(JTextField.CENTER);
        TadHoc.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(LadHoc);
        add(TadHoc);

        /*
         * Create a JTextField and JLabel for the ParkingPass Cars
         */
        JLabel LpassHolder = new JLabel("Percentage of Parking Pass Cars:   ");
        TpassHolder = new JTextField("   0%  ");
        TpassHolder.setColumns(4);
        TpassHolder.setEditable(false);
        TpassHolder.setBackground(Color.decode("#0077FF"));
        TpassHolder.setHorizontalAlignment(JTextField.CENTER);
        TpassHolder.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(LpassHolder);
        add(TpassHolder);

        JLabel LreservingCars = new JLabel("Percentage of Reserving Cars:         ");
        TreservingCar = new JTextField("  0%  ");
        TreservingCar.setColumns(4);
        TreservingCar.setEditable(false);
        TreservingCar.setBackground(Color.green);
        TreservingCar.setHorizontalAlignment(JTextField.CENTER);
        TreservingCar.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(LreservingCars);
        add(TreservingCar);

        /*
         * Create a JTextField and JLabel for the Empty Spots in the garage
         */
        JLabel Lempty = new JLabel("Percentage of Empty Spots:               ");
        Tempty = new JTextField("  100%  ");
        Tempty.setColumns(4);
        Tempty.setEditable(false);
        Tempty.setBackground(Color.white);
        Tempty.setHorizontalAlignment(JTextField.CENTER);
        Tempty.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(Lempty);
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
        double AdHoc = CarParkView.GetAdHoc();
        double PassCar = CarParkView.GetParkPass();
        double ReservingCars = CarParkView.GetReserveringCars();

        int AdHocCar;
        int PassParkCar;
        int ReservingCar;

        int EmptySpots = (int) ((int) 540 - AdHoc - PassCar - ReservingCars);
        int Empty = (int) (((100 / garageSize) * EmptySpots));

        AdHocCar = (int) (((100 / garageSize) * AdHoc));
        PassParkCar = (int) (((100 / garageSize) * PassCar));
        ReservingCar = (int) (((100 / garageSize) * ReservingCars));

        String a = String.valueOf(AdHocCar);
        String p = String.valueOf(PassParkCar);
        String r = String.valueOf(ReservingCar);
        String e = String.valueOf(Empty);

        TadHoc.setText("   " + a + "%");
        TpassHolder.setText("   " + p + "%");
        Tempty.setText("   " + e + "%");
        TreservingCar.setText("   " + r + "%");

        }
    }