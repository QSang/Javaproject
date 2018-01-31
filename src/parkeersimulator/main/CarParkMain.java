package parkeersimulator.main;

import javax.swing.*;

import java.awt.*;

import parkeersimulator.controller.*;
import parkeersimulator.logic.*;
import parkeersimulator.view.*;

public class CarParkMain {
    private JFrame screen;
    private Model model;

    private AbstractView carParkView;
    private AbstractView  displayQueueView;
    private AbstractView typeOfCarView;
    private AbstractView pieView;
    private AbstractView overCrowdedView;
    private AbstractView timeView;

    private GegevensController controller2;
    private SimulatorController controller;

    public CarParkMain() {
        model = new Model();

        controller = new SimulatorController(model);
        controller2 = new GegevensController(model);

        screen = new JFrame("parkeersimulator");
        screen.setSize(1150 , 800);

        carParkView = new CarParkView(model);
        displayQueueView = new DisplayQueueView(model);
        typeOfCarView = new TypeOfCarView(model);
        pieView = new PieView(model);
        overCrowdedView = new OvercrowdedView(model);
        timeView = new TimeView(model);

        screen.setResizable(false);

        screen.setLayout(null);

        screen.getContentPane().add(carParkView);
        screen.getContentPane().add(displayQueueView);
        screen.getContentPane().add(typeOfCarView);
        screen.getContentPane().add(pieView);
        screen.getContentPane().add(overCrowdedView);
        screen.getContentPane().add(timeView);

        screen.getContentPane().add(controller);
        screen.getContentPane().add(controller2);

        controller2.setBorder(BorderFactory.createLineBorder(Color.black));
        carParkView.setBorder(BorderFactory.createLineBorder(Color.black));
        displayQueueView.setBorder(BorderFactory.createLineBorder(Color.black));
        typeOfCarView.setBorder(BorderFactory.createLineBorder(Color.black));
        pieView.setBorder(BorderFactory.createLineBorder(Color.black));
        overCrowdedView.setBorder(BorderFactory.createLineBorder(Color.black));


        controller.setBounds(125, 700, 875, 500);
        controller2.setBounds(5, 10, 250, 420);

        carParkView.setBounds(280,10,860,420);
        typeOfCarView.setBounds(5, 440, 300, 130);
        displayQueueView.setBounds(5,580,300,145);
        pieView.setBounds(810, 440, 280, 280);
        overCrowdedView.setBounds(340,440,440,250);
        timeView.setBounds(340,740,440,250);

        Color displayQueueBg = new Color(0xDBEEF4);

        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        screen.setBackground(displayQueueBg);

        screen.setVisible(true);

        model.totalCarsInQueue();
        model.totalCars();

    }
}
