package Parkeersimulator.main;

import javax.swing.*;

import java.awt.*;

import Parkeersimulator.controller.SimulatorController;
import Parkeersimulator.logic.Model;
import Parkeersimulator.view.AbstractView;
import Parkeersimulator.view.CarParkView;
import Parkeersimulator.view.DisplayQueueView;

public class CarParkMain {
    private JFrame screen;
    private Model model;
    private AbstractView carParkView;
    private AbstractView displayQueueView;



    private SimulatorController controller;

    public CarParkMain() {
        model = new Model();

        controller = new SimulatorController(model);
        carParkView = new CarParkView(model);
        displayQueueView = new DisplayQueueView(model);

        screen = new JFrame("ParkeerGarage simulator");
        screen.setSize(885, 820 );

        screen.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.DARK_GRAY));
        screen.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.DARK_GRAY));


        screen.setResizable(false);

        screen.getContentPane().add(carParkView);
        screen.getContentPane().add(controller);
        screen.getContentPane().add(displayQueueView);

        controller.setBounds(-2, 730, 875, 50);

        carParkView.setBounds(5,10,860,420);
        displayQueueView.setBounds(245,640,300,80);

        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color displayQueueBg = new Color(0xDBEEF4);

        screen.setBackground(displayQueueBg);


        model.start();
    }
}
