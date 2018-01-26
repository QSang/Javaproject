package Parkeersimulator.main;

import javax.swing.*;

import java.awt.*;

import Parkeersimulator.controller.*;
import Parkeersimulator.logic.*;
import Parkeersimulator.view.*;

public class CarParkMain {
    private JFrame screen;
    private Model model;
    private AbstractView carParkView;
    private AbstractView displayQueueView;
    private AbstractView typeOfCarView;


    private SimulatorController controller;

    public CarParkMain() {

        model = new Model();

        controller = new SimulatorController(model);
        carParkView = new CarParkView(model);
        displayQueueView = new DisplayQueueView(model);
        typeOfCarView = new TypeOfCarView(model);

        screen = new JFrame("ParkeerGarage Simulator");
        screen.setSize(885, 820 );
        screen.setResizable(false);
        screen.setLayout(null);

        screen.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.DARK_GRAY));
        screen.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.DARK_GRAY));


        screen.getContentPane().add(carParkView);
        screen.getContentPane().add(controller);
        screen.getContentPane().add(displayQueueView);
        screen.getContentPane().add(typeOfCarView);

        controller.setBounds(-2, 730, 875, 50);

        carParkView.setBounds(5,10,860,420);
        displayQueueView.setBounds(245,640,300,80);
        typeOfCarView.setBounds(245, 500, 300, 130);

        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color displayQueueBg = new Color(0xDBEEF4);

        screen.setBackground(displayQueueBg);

        screen.setVisible(true);
        model.start();
    }
}
