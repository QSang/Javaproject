package parkeersimulator.view;

import javax.swing.*;
import java.awt.*;

import parkeersimulator.logic.*;

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
         * Constructor for TextOverview
         */
        public DisplayQueueView(Model model) {
            super(model);
            this.model = model;

            /**
             * Entrance Queue JTextField and JLabel
             */
            JLabel lblEntranceQueue = new JLabel("Entrance Car Queue:                            ");
            txtEntranceQueue = new JTextField("0");
            txtEntranceQueue.setColumns(5);
            txtEntranceQueue.setOpaque(false);
            txtEntranceQueue.setEditable(false);
            txtEntranceQueue.setHorizontalAlignment(JTextField.CENTER);
            txtEntranceQueue.setBorder(BorderFactory.createLineBorder(Color.black,1));
            add(lblEntranceQueue);
            add(txtEntranceQueue);

            /**
             * Entrance Pass Queue JTextField and JLabel
             */

            JLabel lblEntrancePassQueue = new JLabel("Entrance Pass/Reserved Queue:      ");
            txtEntrancePassQueue = new JTextField("0");
            txtEntrancePassQueue.setColumns(5);
            txtEntrancePassQueue.setEditable(false);
            txtEntrancePassQueue.setOpaque(false);
            txtEntrancePassQueue.setHorizontalAlignment(JTextField.CENTER);
            txtEntrancePassQueue.setBorder(BorderFactory.createLineBorder(Color.black,1));
            add(lblEntrancePassQueue);
            add(txtEntrancePassQueue);

            /**
             * Exit Queue JTextField and JLabel
             */
            JLabel lblExit = new JLabel("Total cars Exiting:                                  ");
            txtExit = new JTextField("0");
            txtExit.setColumns(5);
            txtExit.setEditable(false);
            txtExit.setOpaque(false);
            txtExit.setHorizontalAlignment(JTextField.CENTER);
            txtExit.setBorder(BorderFactory.createLineBorder(Color.black,1));
            add(lblExit);
            add(txtExit);

            JLabel lblTotalCars = new JLabel("Total cars used:                                     ");
            txtTotalCars = new JTextField("0");
            txtTotalCars.setColumns(5);
            txtTotalCars.setEditable(false);
            txtTotalCars.setOpaque(false);
            txtTotalCars.setHorizontalAlignment(JTextField.CENTER);
            txtTotalCars.setBorder(BorderFactory.createLineBorder(Color.black,1));
            add(lblTotalCars);
            add(txtTotalCars);

        JLabel lblCurrentRevenue = new JLabel("Current Revenue:                        ");
            txtCurrentRevenue = new JTextField("   0");
            txtCurrentRevenue.setColumns(8);
            txtCurrentRevenue.setEditable(false);
            txtCurrentRevenue.setOpaque(false);
            txtCurrentRevenue.setHorizontalAlignment(JTextField.CENTER);
            txtCurrentRevenue.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(lblCurrentRevenue);
        add(txtCurrentRevenue);

        JLabel lblTotalRevenue = new JLabel("Total Revenue:                            ");
            txtTotalRevenue = new JTextField("   0");
            txtTotalRevenue.setColumns(8);
            txtTotalRevenue.setEditable(false);
            txtTotalRevenue.setOpaque(false);

            txtTotalRevenue.setHorizontalAlignment(JTextField.CENTER);
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
            txtExit.setText("   "+ exitIndex);
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