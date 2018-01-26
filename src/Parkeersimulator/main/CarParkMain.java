package Parkeersimulator.main;

import java.awt.*;

import javax.swing.*;

import Parkeersimulator.controller.GegevensController;
import Parkeersimulator.controller.SimulatorController;
import Parkeersimulator.logic.Model;
import Parkeersimulator.view.AbstractView;
import Parkeersimulator.view.CarParkView;

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
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
