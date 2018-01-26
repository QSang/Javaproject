package Parkeersimulator.main;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import Parkeersimulator.controller.SimulatorController;
import Parkeersimulator.logic.Model;
import Parkeersimulator.view.AbstractView;
import Parkeersimulator.view.CarParkView;

public class CarParkMain {
    private JFrame screen;
    private Model model;
    private AbstractView carparkview;

    private SimulatorController controller;

    public CarParkMain() {
        model = new Model();
        controller = new SimulatorController(model);
        carparkview = new CarParkView(model);
        screen = new JFrame("Parkeersimulator");
        screen.setSize(1200, 600);
        screen.setResizable(false);

        screen.getContentPane().add(carparkview);
        screen.getContentPane().add(controller);
        carparkview.setBounds(260,30,900,500);
        controller.setBounds(30,320,910,200);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
