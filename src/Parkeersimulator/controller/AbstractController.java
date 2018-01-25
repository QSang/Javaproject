package Parkeersimulator.controller;

import Parkeersimulator.logic.*;
import javax.swing.*;

public abstract class AbstractController extends JPanel {
    protected Simulator simulator;

    public AbstractController(AbstractModel model) {
        this.simulator = simulator;
    }
}
