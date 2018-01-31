package parkeersimulator.view;

import javax.swing.JPanel;
import parkeersimulator.logic.Model;

/**
 * @author Sang Nguyen, Sjoerd Feenstra, WaiCheong Ng, Jurgen Katoen
 * Extend to all views with AbstractView.
 */

public abstract class AbstractView extends JPanel{
    protected Model model;

    public AbstractView(Model model) {
        this.model = model;
        model.addView(this);
    }

    public Model getModel(){
        return model;
    }

    public void updateView(){
        repaint();
    }
}
