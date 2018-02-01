package parkeersimulator.controller;

import javax.swing.*;
import parkeersimulator.logic.Model;

/**
 * Abstract Class for the controller
 * @author Sang Nguyen, Sjoerd Feenstra, WaiCheong Ng, Jurgen Katoen
 *
 */

public abstract class AbstractController extends JPanel {
    protected Model model;

    public AbstractController(Model model) {
        this.model=model;
    }

}
