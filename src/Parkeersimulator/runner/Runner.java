package Parkeersimulator.runner;

import Parkeersimulator.logic.*;
import Parkeersimulator.view.*;

import javax.swing.*;
import java.awt.*;

public class Runner {

    public static void main(String[] args) {
        {

            ParkGarage parkGarage = new ParkGarage(3, 6, 30);

            JFrame screen = new JFrame("Parking Garage Simulator");
            screen.setSize(885, 820);
            screen.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.DARK_GRAY));
            screen.setLayout(null);
            screen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            screen.setVisible(true);

            CarParkView CarParkView  = new CarParkView(parkGarage);

            screen.getContentPane().add(CarParkView);

            CarParkView.setBounds(5, 10, 860, 420);

        }
    }
}