package Parkeersimulator.logic;


import java.util.ArrayList;
import java.util.List;

import Parkeersimulator.view.AbstractView;

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
