package Parkeersimulator.logic;

import Parkeersimulator.view.*;
import java.util.*;

public abstract class AbstractModel {
    private List<AbstractView> views;

    public AbstractModel() {
        this.views = new ArrayList<AbstractView>();
    }

    public void addView(AbstractView view) {
        this.views.add(view);
    }

    public void notifyViews() {
        for(AbstractView v: this.views){
            v.updateView();
        }
    }
}
