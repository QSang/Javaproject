package parkeersimulator.view;

import javax.swing.*;
import java.awt.*;

import parkeersimulator.logic.*;

    public class DisplayQueueView extends AbstractView{
        private JTextField txtEntranceQueue;
        private JTextField txtEntrancePassQueue;
        private JTextField txtExitQueue;
        private JTextField txtTotalCars;
        private JTextField txtCurrentRevenue;
        private JTextField txtTotalRevenue;


        private Model model;

        private int exitIndex;
        private int totalCarsIndex;
        double ticketPrice = 5.0;
        /**
         * Constructor for TextOverview
         */
        public DisplayQueueView(Model model) {
            super(model);
            this.model = model;

            /**
             * Entrance Queue JTextField and JLabel
             */
            JLabel lblEntranceQueue = new JLabel("Entrance Car Queue:                            ");
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
            JLabel lblExitQueue = new JLabel("Exit Cars Queue:                                    ");
            txtExitQueue = new JTextField("   0");
            txtExitQueue.setColumns(4);
            txtExitQueue.setEditable(false);
            txtExitQueue.setOpaque(false);
            txtExitQueue.setBorder(BorderFactory.createLineBorder(Color.black,1));
            add(lblExitQueue);
            add(txtExitQueue);

            JLabel lblTotalCars = new JLabel("Total cars used:                                     ");
            txtTotalCars = new JTextField("   0");
            txtTotalCars.setColumns(4);
            txtTotalCars.setEditable(false);
            txtTotalCars.setOpaque(false);
            txtTotalCars.setBorder(BorderFactory.createLineBorder(Color.black,1));
            add(lblTotalCars);
            add(txtTotalCars);

        JLabel lblCurrentRevenue = new JLabel("Current Revenue:                                  ");
            txtCurrentRevenue = new JTextField("   0");
            txtCurrentRevenue.setColumns(4);
            txtCurrentRevenue.setEditable(false);
            txtCurrentRevenue.setOpaque(false);
            txtCurrentRevenue.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(lblCurrentRevenue);
        add(txtCurrentRevenue);

        JLabel lblTotalRevenue = new JLabel("Total Revenue:                                       ");
            txtTotalRevenue = new JTextField("   0");
            txtTotalRevenue.setColumns(4);
            txtTotalRevenue.setEditable(false);
            txtTotalRevenue.setOpaque(false);
            txtTotalRevenue.setBorder(BorderFactory.createLineBorder(Color.black,1));
            add(lblTotalRevenue);
            add(txtTotalRevenue);

            calcRevenue();
            calcExpRevenue();
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
            txtExitQueue.setText("   "+ exitIndex);
            txtTotalCars.setText("   "+ totalCarsIndex);

            setVisible(true);

            super.updateView();
            calcRevenue();
            calcExpRevenue();

        }
        /**
         * calculates the revenue
         */

        public void calcRevenue()
        {
            int totalCars = model.getPayingCars();
            double totalRevenue = totalCars * ticketPrice;

            txtTotalRevenue.setText(" € "+totalRevenue+"0");

        }
        /**
         * Calculates the expected Revenue of cars which still have to pay.
         */
        public void calcExpRevenue(){

            int totalCurrentCars = CarParkView.GetAdHoc();

            double currentRevenue = totalCurrentCars * ticketPrice;

            txtCurrentRevenue.setText(" € "+currentRevenue+"0");
        }
    }