package parkeersimulator.controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import parkeersimulator.logic.*;

import javax.swing.*;

/**
 * Class for settingsController in the simulator
 * has textfields, action eventlisteners, buttons, labels
 * @author Sjoerd Feenstra
 *
 */

public class SettingsController extends AbstractController implements ActionListener {
    private JTextField weekDayArText;
    private JTextField weekendArText;
    private JTextField weekDayPassArText;
    private JTextField weekendPassArText;
    private JTextField weekDayReservedArText;
    private JTextField weekendReservedArText;
    private JTextField enterSpText;
    private JTextField paymentSpText;
    private JTextField exitSpText;

    private ActionEvent event;

    private JButton set;
    private JButton reset;

    private JLabel weekDayArLabel;
    private JLabel weekendArLabel;
    private JLabel weekDayPassArLabel;
    private JLabel weekendPassArLabel;
    private JLabel weekDayReservedArLabel;
    private JLabel weekendReservedArLabel;
    private JLabel enterSpLabel;
    private JLabel paymentSpLabel;
    private JLabel exitSpLabel;

    /**
     * Constructs the constructor for SettingsController
     */

    public SettingsController(Model model) {
        super(model);

        weekDayArLabel = new JLabel("Weekday Car Arrivals:                   ");
        weekDayArText = new JTextField(3);
        weekDayArText.setText("100");
        weekDayArText.setHorizontalAlignment(JTextField.CENTER);

        weekDayArText.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(weekDayArLabel);
        add(weekDayArText);

        weekendArLabel = new JLabel("Weekend Car Arrivals:                  ");
        weekendArText = new JTextField(3);
        weekendArText.setText("200");
        weekendArText.setHorizontalAlignment(JTextField.CENTER);
        weekendArText.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(weekendArLabel);
        add(weekendArText);

        weekDayPassArLabel = new JLabel("Weekday Parkingpass Arrivals: ");
        weekDayPassArText = new JTextField(3);
        weekDayPassArText.setText("50");
        weekDayPassArText.setHorizontalAlignment(JTextField.CENTER);
        weekDayPassArText.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(weekDayPassArLabel);
        add(weekDayPassArText);

        weekendPassArLabel = new JLabel("Weekend Parkingpass Arrivals: ");
        weekendPassArText = new JTextField(3);
        weekendPassArText.setText("5");
        weekendPassArText.setHorizontalAlignment(JTextField.CENTER);
        weekendPassArText.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(weekendPassArLabel);
        add(weekendPassArText);

        weekDayReservedArLabel = new JLabel("Weekday Reserved Arrivals:       ");
        weekDayReservedArText = new JTextField(3);
        weekDayReservedArText.setText("50");
        weekDayReservedArText.setHorizontalAlignment(JTextField.CENTER);
        weekDayReservedArText.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(weekDayReservedArLabel);
        add(weekDayReservedArText);

        weekendReservedArLabel = new JLabel("Weekend Reserved Arrivals:       ");
        weekendReservedArText = new JTextField(3);
        weekendReservedArText.setText("5");
        weekendReservedArText.setHorizontalAlignment(JTextField.CENTER);
        weekendReservedArText.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(weekendReservedArLabel);
        add(weekendReservedArText);

        enterSpLabel = new JLabel("Enter Speed:                                     ");
        enterSpText = new JTextField(3);
        enterSpText.setText("3");
        enterSpText.setHorizontalAlignment(JTextField.CENTER);
        enterSpText.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(enterSpLabel);
        add(enterSpText);

        paymentSpLabel = new JLabel("Payment Speed:                              ");
        paymentSpText = new JTextField(3);
        paymentSpText.setText("7");
        paymentSpText.setHorizontalAlignment(JTextField.CENTER);
        paymentSpText.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(paymentSpLabel);
        add(paymentSpText);

        exitSpLabel = new JLabel("Exit Speed:                                        ");
        exitSpText = new JTextField(3);
        exitSpText.setText("5");
        exitSpText.setHorizontalAlignment(JTextField.CENTER);
        exitSpText.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(exitSpLabel);
        add(exitSpText);

        set = new JButton("Set");
        set.addActionListener((ActionListener) this);
        set.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        set.setPreferredSize(new Dimension(70, 20));
        set.setBackground(Color.BLUE);
        set.setForeground(Color.WHITE);
        add(set);

        reset = new JButton("Reset");
        reset.addActionListener((ActionListener) this);
        reset.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        reset.setPreferredSize(new Dimension(70, 20));
        reset.setBackground(Color.BLUE);
        reset.setForeground(Color.WHITE);
        add(reset);
    }

    public void setActionEvent(ActionEvent e) {
        event = e;
    }

    /**
     * returns the set event
     *
     * @return event
     */

    public ActionEvent getActionEvent() {
        return event;
    }

    /**
     * Executes the the input action
     * Creates the commands that the buttons execute
     */
    public void actionPerformed(ActionEvent e) {
        setActionEvent(e);
        Thread performerThread = new Thread() {

        public void run() {
            ActionEvent e = getActionEvent();
            String command = e.getActionCommand();

            if (command == "Set") {
                int weekAr = Integer.parseInt(weekDayArText.getText().trim());
                model.changeWeekAr(weekAr);

                int weekendAr = Integer.parseInt(weekendArText.getText().trim());
                model.changeWeekendAr(weekendAr);

                int weekP = Integer.parseInt(weekDayPassArText.getText().trim());
                model.changeWeekP(weekP);

                int weekendP = Integer.parseInt(weekendPassArText.getText().trim());
                model.changeWeekendP(weekendP);

                int weekRes = Integer.parseInt(weekDayReservedArText.getText().trim());
                model.changeWeekRes(weekRes);

                int weekendRes = Integer.parseInt(weekendReservedArText.getText().trim());
                model.changeWeekendRes(weekendRes);

                int entrySpeed = Integer.parseInt(enterSpText.getText().trim());
                model.changeEntrySpeed(entrySpeed);

                int paySpeed = Integer.parseInt(paymentSpText.getText().trim());
                model.changePaySpeed(paySpeed);

                int exitSpeed = Integer.parseInt(exitSpText.getText().trim());
                model.changeExitSpeed(exitSpeed);

                model.setSet(true);
                model.setStart(false);
            }
                if (command == "Reset") {

                    weekDayArText.setText("100");
                    weekendArText.setText("200");
                    weekDayPassArText.setText("50");
                    weekendPassArText.setText("5");
                    weekDayReservedArText.setText("50");
                    weekendReservedArText.setText("5");
                    enterSpText.setText("3");
                    paymentSpText.setText("7");
                    exitSpText.setText("5");
                    model.setSet(false);
                }
            }
        };
        performerThread.start();
    }
}







