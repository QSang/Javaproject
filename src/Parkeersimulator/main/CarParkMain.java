package Parkeersimulator.main;

import javax.swing.*;

import java.awt.*;

import Parkeersimulator.controller.*;
import Parkeersimulator.logic.*;
import Parkeersimulator.view.*;

public class CarParkMain {
    private JFrame screen;
    private Model model;
    private AbstractView carparkview;

    private SimulatorController controller;
    private GegevensController controller2;

    public CarParkMain() {
        model = new Model();
        controller = new SimulatorController(model);
        controller2 = new GegevensController(model);
        carparkview = new CarParkView(model);
        screen = new JFrame("Parkeersimulator");
        screen.setSize(880, 800);
        carParkView = new CarParkView(model);
        displayQueueView = new DisplayQueueView(model);
        typeOfCarView = new TypeOfCarView(model);

        screen = new JFrame("ParkeerGarage Simulator");
        screen.setSize(885, 820 );
        screen.setResizable(false);

        screen.getContentPane().add(carparkview);
        screen.getContentPane().add(controller);
        screen.getContentPane().add(controller2);
        carparkview.setBounds(5, 10, 875, 420);
        controller.setBounds(-2, 730, 875, 100);
        controller2.setBounds(5, 440, 875, 100);
        controller.setBorder(BorderFactory.createLineBorder(Color.black));
        controller2.setBorder(BorderFactory.createLineBorder(Color.black));
        carparkview.setBorder(BorderFactory.createLineBorder(Color.black));

        screen.setVisible(true);
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
