package Parkeersimulator.controller;

import Parkeersimulator.logic.AbstractModel;
import javax.swing.*;

public abstract class AbstractController extends JPanel {
    protected AbstractModel model;

    public AbstractController(AbstractModel model) {
        this.model = model;
    }
}
