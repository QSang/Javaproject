package Parkeersimulator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Parkeersimulator.logic.Model;
import Parkeersimulator.main.CarParkMain;

import javax.swing.*;

public class SimulatorController extends AbstractController implements ActionListener
{
    private JButton steps,startButton, stopButton;
    private JLabel insertSteps;
    private JTextField stepsField;

    public SimulatorController(Model model){
        super(model);

        insertSteps = new JLabel("insertSteps");
        stepsField = new JTextField("");
        steps = new JButton("Total Steps");
        steps.addActionListener(this);
        stepsField.addActionListener(this);
        startButton = new JButton("startButton");
        startButton.addActionListener(this);
        stopButton = new JButton("stopButton");
        stopButton.addActionListener(this);


        this.setLayout(null);

        stopButton.setBounds(670,0,70,20);
        startButton.setBounds(410,0,70,20);
        insertSteps.setBounds(10,0,200,20);
        stepsField.setBounds(10,20,75,20);
        steps.setBounds(110,20,70,20);
        add(startButton);
        add(stopButton);
        add(steps);
        add(insertSteps);
        add(stepsField);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == steps){
            this.startStepPressed();
        }
        else if (e.getSource() == startButton){
            this.startPressed();
        }
        else if (e.getSource() == stopButton){
            this.stopPressed();
        }
    }

    public void startPressed() {
        model.run = true;
    }


    public void stopPressed() {
        model.run = false;
    }

    private void setSteps(int steps) {
        Model carPark = (Model) super.model;

        for(int i =0; i < steps; i++)
            carPark.tick();
    }

    private void startStepPressed(){

        try{
            int steps = Integer.parseInt(stepsField.getText());

            setSteps(steps);

        } catch (NumberFormatException e){
            // TODO notify user that the field is not a number!
        }
    }
}
