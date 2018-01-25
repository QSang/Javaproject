package Parkeersimulator.controller;

import Parkeersimulator.logic.*;

import javax.swing.*;


public abstract class AbstractController extends JPanel{

    protected Model model;

    public AbstractController(Model model) {
        this.model = model;
    }
}
