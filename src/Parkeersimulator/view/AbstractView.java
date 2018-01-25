package Parkeersimulator.view;

import javax.swing.*;
import Parkeersimulator.logic.*;

public abstract class AbstractView extends JPanel {
    protected ParkGarage simulator;
    protected AbstractModel model;

    public AbstractView(ParkGarage simulator) {
        this.simulator=simulator;
        simulator.addView(this);
    }

    public void updateView() {
        repaint();
    }
}