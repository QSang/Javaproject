package parkeersimulator.logic;

import java.util.ArrayList;
import java.util.List;

import parkeersimulator.view.AbstractView;

/**
 * Abstract Class for the model subclasses
 * @author Sang Nguyen, Sjoerd Feenstra, WaiCheong Ng, Jurgen Katoen
 */

public abstract class AbstractModel {
    private List<AbstractView> views;

    public AbstractModel()
    {
        views = new ArrayList<AbstractView>();
    }

    public void addView(AbstractView view)
    {
        views.add(view);
    }

    public void notifyView()
    {
        for(AbstractView v: views) v.updateView();
    }

}
