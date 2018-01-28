package Parkeersimulator.controller;

import javax.swing.*;
import Parkeersimulator.logic.Model;

public abstract class AbstractController extends JPanel {
    protected Model model;

    public AbstractController(Model model) {
        this.model=model;
    }

}
