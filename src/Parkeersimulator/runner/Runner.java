package Parkeersimulator.runner;

import Parkeersimulator.logic.*;
import Parkeersimulator.view.*;
import Parkeersimulator.controller.*;

import javax.swing.*;
import java.awt.*;

public class Runner extends JFrame{

    public static void main(String[] args) {

        Model model = new Model(3, 6, 30);

        CarParkView CarParkView  = new CarParkView(model);


        JFrame screen = new JFrame("Parking Garage Simulator");
        screen.setSize(885, 820);
        screen.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.DARK_GRAY));
        screen.setResizable(false);
        screen.setLayout(null);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        screen.getContentPane().add(CarParkView);

        CarParkView.setBounds(5, 10, 860, 420);



    }

}