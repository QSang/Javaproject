package Parkeersimulator.view;

import javax.swing.*;
import Parkeersimulator.logic.AbstractModel;

public abstract class AbstractView extends JPanel {
    protected AbstractModel model;

    public AbstractView(AbstractModel model) {
        this.model = model;
        model.addView(this);

        setLayout(null);
    }

    public AbstractModel abstractModel() {
        return model;
    }

    public void updateView() {
        repaint();
    }
}