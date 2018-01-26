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
    private JButton oneStepButton;
    private JButton hundredStepsButton;
    private JButton startButton;
    private JButton stopButton;
    private ActionEvent event;

    public SimulatorController(Model model){
        super(model);

        oneStepButton = new JButton("One Step");
        oneStepButton.addActionListener(this);
        hundredStepsButton = new JButton("Hundred Steps");
        hundredStepsButton.addActionListener(this);
        startButton = new JButton("Start");
        startButton.addActionListener(this);
        stopButton = new JButton("Stop");
        stopButton.addActionListener(this);




        stopButton.setBounds(670,0,70,20);
        startButton.setBounds(410,0,70,20);
        oneStepButton.setBounds(10,0,200,20);
        hundredStepsButton.setBounds(10,20,200,20);
        add(startButton);
        add(stopButton);
        add(oneStepButton);
        add(hundredStepsButton);
        setVisible(true);
    }

    public void setActionEvent(ActionEvent e) {
        event = e;
    }

    /**
     * returns the set event
     * @return event
     */

    public ActionEvent getActionEvent() {
        return event;
    }


    public void actionPerformed(ActionEvent e)
    {

        //sets the received actionEvent, and creates a new thread
        setActionEvent(e);
        Thread performerThread = new Thread(){

            /**
             * Creates the commands that the buttons execute
             */

            public void run (){
                ActionEvent e = getActionEvent();
                String command = e.getActionCommand();
                model.setStop(false);
                if (command == "One Step"){
                    model.runCommand(1);
                }
                if (command == "Hundred Steps"){
                    model.runCommand(100);
                }
                if (command == "Start"){

                    model.runCommand(100000);
                }
                if (command == "Stop"){

                    model.setStop(true);

                }

            }
        };
        performerThread.start();
    }






}
