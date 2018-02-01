package parkeersimulator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import parkeersimulator.logic.Model;

import javax.swing.*;

/**
 * Class for SimulatorController in the simulator
 * has textfields, action eventlisteners, buttons, labels
 * @author Sjoerd Feenstra
 */

public class SimulatorController extends AbstractController implements ActionListener {
    private JButton oneStepButton;
    private JButton hundredStepsButton;
    private JButton startButton;
    private JButton stopButton;
    private ActionEvent event;

    /**
    *@param model get information from Model
    */

    public SimulatorController(Model model) {
        super(model);

        oneStepButton = new JButton("One Step");
        oneStepButton.addActionListener(this);
        hundredStepsButton = new JButton("Hundred Steps");
        hundredStepsButton.addActionListener(this);
        startButton = new JButton("Start");
        startButton.addActionListener(this);
        stopButton = new JButton("Stop");
        stopButton.addActionListener(this);

        stopButton.setBounds(670, 0, 70, 20);
        startButton.setBounds(410, 0, 70, 20);
        oneStepButton.setBounds(10, 0, 200, 20);
        hundredStepsButton.setBounds(10, 20, 200, 20);
        add(startButton);
        add(stopButton);
        add(oneStepButton);
        add(hundredStepsButton);
        setVisible(true);
    }

    /*
    @param e event
     */
    public void setActionEvent(ActionEvent e) {
        event = e;
    }

    /**
     * returns the set event
     * @return event get the event
     */

    public ActionEvent getActionEvent() {
        return event;
    }

    /**
    @param e makes a new thread and runs the action
     */

    public void actionPerformed(ActionEvent e) {
        setActionEvent(e);
        Thread performerThread = new Thread() {

            /**
             * Creates the commands that the buttons execute
             */

            public void run() {
            ActionEvent e = getActionEvent();
            String command = e.getActionCommand();
            model.setStop(false);
            if (command == "One Step") {
                model.runSimulator(1);
            }
            if (command == "Hundred Steps") {
                model.runSimulator(100);
            }
            if (command == "Start") {

                model.runSimulator(100000);
            }
            if (command == "Stop") {

                model.setStop(true);
            }
            }
        };
        performerThread.start();
    }
}
