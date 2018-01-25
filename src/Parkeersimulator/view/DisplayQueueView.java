package Parkeersimulator.view;

import javax.swing.*;
import java.awt.*;

import Parkeersimulator.logic.*;

/**
 * Class for the Queue overview
 * @author Martijn Bakker, Albert van der Berg, Antonie Groenveld, Arneld van der Veen and Daniel Bouius
 *
 */

public class DisplayQueueView extends AbstractView{
    private JTextField txtEntranceQueue;
    private JTextField txtEntrancePassQueue;
    private JTextField txtExitQueue;
    private Model model;

    /**
     * Constructor for TextOverview
     */
    public DisplayQueueView(Model model) {
        super(model);
        this.model = model;

        /**
         * Entrance Queue JTextField and JLabel
         */
        JLabel lblEntranceQueue = new JLabel("Entrance Queue:                                    ");
        txtEntranceQueue = new JTextField("   0");
        txtEntranceQueue.setColumns(4);
        txtEntranceQueue.setOpaque(false);
        txtEntranceQueue.setEditable(false);
        txtEntranceQueue.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(lblEntranceQueue);
        add(txtEntranceQueue);

        /**
         * Entrance Pass Queue JTextField and JLabel
         */

        JLabel lblEntrancePassQueue = new JLabel("Entrance Pass Queue:                         ");
        txtEntrancePassQueue = new JTextField("   0");
        txtEntrancePassQueue.setColumns(4);
        txtEntrancePassQueue.setEditable(false);
        txtEntrancePassQueue.setOpaque(false);
        txtEntrancePassQueue.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(lblEntrancePassQueue);
        add(txtEntrancePassQueue);

        /**
         * Exit Queue JTextField and JLabel
         */
        JLabel lblExitQueue = new JLabel("Exit Queue:                                              ");
        txtExitQueue = new JTextField("   0");
        txtExitQueue.setColumns(4);
        txtExitQueue.setEditable(false);
        txtExitQueue.setOpaque(false);
        txtExitQueue.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(lblExitQueue);
        add(txtExitQueue);
    }

    /**
     * Updates the view so the numbers inside the textfield change accordingly
     */
    public void updateView(){
        entranceQueue();
        entrancePassQueue();
        exitQueue();
    }

    /**
     * Fill Entrance Queue text field
     */

    public void entranceQueue() {
        int entranceQueue = model.getEntranceCarQueue();
        txtEntranceQueue.setText("   "+entranceQueue);
    }

    /**
     * Fill Entrance Pass Queue text field
     */

    public void entrancePassQueue() {
        int entrancePassQueue = model.getPassCarQueue();
        txtEntrancePassQueue.setText("   "+entrancePassQueue);
    }

    /**
     * Fill Exit Queue text field
     */
    public void exitQueue() {
        int exitQueue = model.getExitCarQueue();
        txtExitQueue.setText("   "+exitQueue);
    }
}
