package parkeersimulator.view;

import javax.swing.JPanel;
import parkeersimulator.logic.Model;

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
