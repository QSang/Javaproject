package parkeersimulator.view;

import javax.swing.*;
import java.awt.*;

import parkeersimulator.logic.*;

/**
 * @author Sang Nguyen
 * Creates a view for overcrowded queue's
 */

public class DisplayQueueView extends AbstractView{
    private JTextField txtEntranceQueue;
    private JTextField txtEntrancePassQueue;
    private JTextField txtExit;
    private JTextField txtTotalCars;
    private JTextField txtCurrentRevenue;
    private JTextField txtTotalRevenue;

    private Model model;

    private int exitIndex;
    private int totalCarsIndex;
    double ticketPrice = 5.0;

    /**
     * Constructor for DisplayQueueView
     */

    public DisplayQueueView(Model model) {
        super(model);
        this.model = model;

    /**
     * JTextField and JLabel for EntranceQueue, EntrancePassQueue, Total cars exiting, CurrentRevenue, TotalRevenue
     */
        JLabel EntranceQueueLabel = new JLabel("Entrance Car Queue:                            ");
        txtEntranceQueue = new JTextField("0");
        txtEntranceQueue.setColumns(5);
        txtEntranceQueue.setOpaque(false);
        txtEntranceQueue.setEditable(false);
        txtEntranceQueue.setHorizontalAlignment(JTextField.CENTER);
        txtEntranceQueue.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(EntranceQueueLabel);
        add(txtEntranceQueue);

        JLabel entrancePassQueueLabel = new JLabel("Entrance Pass/Reserved Queue:      ");
        txtEntrancePassQueue = new JTextField("0");
        txtEntrancePassQueue.setColumns(5);
        txtEntrancePassQueue.setEditable(false);
        txtEntrancePassQueue.setOpaque(false);
        txtEntrancePassQueue.setHorizontalAlignment(JTextField.CENTER);
        txtEntrancePassQueue.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(entrancePassQueueLabel);
        add(txtEntrancePassQueue);

        JLabel exitLabel = new JLabel("Total cars Exiting:                                  ");
        txtExit = new JTextField("0");
        txtExit.setColumns(5);
        txtExit.setEditable(false);
        txtExit.setOpaque(false);
        txtExit.setHorizontalAlignment(JTextField.CENTER);
        txtExit.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(exitLabel);
        add(txtExit);

        JLabel totalCarsLabel = new JLabel("Total cars used:                                     ");
        txtTotalCars = new JTextField("0");
        txtTotalCars.setColumns(5);
        txtTotalCars.setEditable(false);
        txtTotalCars.setOpaque(false);
        txtTotalCars.setHorizontalAlignment(JTextField.CENTER);
        txtTotalCars.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(totalCarsLabel);
        add(txtTotalCars);

        JLabel currentRevenueLabel = new JLabel("Current Revenue:                        ");
        txtCurrentRevenue = new JTextField("   0");
        txtCurrentRevenue.setColumns(8);
        txtCurrentRevenue.setEditable(false);
        txtCurrentRevenue.setOpaque(false);
        txtCurrentRevenue.setHorizontalAlignment(JTextField.CENTER);
        txtCurrentRevenue.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(currentRevenueLabel);
        add(txtCurrentRevenue);

        JLabel totalRevenueLabel = new JLabel("Total Revenue:                            ");
        txtTotalRevenue = new JTextField("   0");
        txtTotalRevenue.setColumns(8);
        txtTotalRevenue.setEditable(false);
        txtTotalRevenue.setOpaque(false);

        txtTotalRevenue.setHorizontalAlignment(JTextField.CENTER);
        txtTotalRevenue.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(totalRevenueLabel);
        add(txtTotalRevenue);

        calculateRevenue();
        calculateCurrentRevenue();
    }

    /**
     * Updates the view so the numbers inside the textfield change accordingly
     */
    public void updateView(){
        Model model = (Model) super.model;

        exitIndex = model.getExitIndex();
        totalCarsIndex = model.getTotalCarsIndex();

        txtEntranceQueue.setText("   " + model.getEntranceCarQueue());
        txtEntrancePassQueue.setText("   " + model.getEntrancePassQueue());
        txtExit.setText("   "+ exitIndex);
        txtTotalCars.setText("   "+ totalCarsIndex);

        setVisible(true);

        super.updateView();
        calculateRevenue();
        calculateCurrentRevenue();

    }

    /**
     * when the cars leave the garage, calculate the total revenue
     */

    public void calculateRevenue()
    {
        int totalCars = model.getPayingCars();
        double totalRevenue = totalCars * ticketPrice;

        txtTotalRevenue.setText(" € "+totalRevenue+"0");

    }

    /**
     * Calculate the current revenue of cars which still have to pay.
     */

    public void calculateCurrentRevenue(){

        int totalCurrentCars = CarParkView.GetAdHoc();

        double currentRevenue = totalCurrentCars * ticketPrice;

        txtCurrentRevenue.setText(" € "+currentRevenue+"0");
    }
}