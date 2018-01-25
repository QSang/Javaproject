package Parkeersimulator.view;

import java.awt.*;

import Parkeersimulator.*;
import Parkeersimulator.logic.*;

public class CarParkView extends AbstractView {

    private static int AdHocCar;
    private static int ParkPassCar;

    private Dimension size;
    private Image carParkImage;
    private ParkGarage parkGarage;

    public CarParkView(ParkGarage model) {
        super(model);
        this.parkGarage = model;
        size = new Dimension(0, 0);
    }

    public Dimension getPreferredSize() {
        return new Dimension(800, 500);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Create a new car park image if the size has changed.
        if (!size.equals(getSize())) {
            size = getSize();
            carParkImage = createImage(size.width, size.height);

        }
        AdHocCar = 0;
        ParkPassCar = 0;

        Graphics graphics = carParkImage.getGraphics();
        for(int floor = 0; floor < parkGarage.getNumberOfFloors(); floor++) {
            for(int row = 0; row < parkGarage.getNumberOfRows(); row++) {
                for(int place = 0; place < parkGarage.getNumberOfPlaces(); place++) {
                    Location location = new Location(floor, row, place);
                    Car car = parkGarage.getCarAt(location);
                    if (car == null){
                        Color color = Color.white;
                        drawPlace(graphics, location, color);
                    }
                    else if (car != null && car.getClass().equals(AdHocCar.class)){
                        Color color1 = Color.red;
                        drawPlace(graphics, location, color1);
                        AdHocCar++;
                    }
                    else if (car != null && car.getClass().equals(ParkingPassCar.class)){
                        Color color2 = Color.blue;
                        drawPlace(graphics, location, color2);
                        ParkPassCar++;
                    }
                }
            }
            if (carParkImage == null) {
                return;
            }

            Dimension currentSize = getSize();
            if (size.equals(currentSize)) {
                g.drawImage(carParkImage, 0, 0, null);
            }
            else {
                // Rescale the previous image.
                g.drawImage(carParkImage, 0, 0, 800, 500, null);
            }
            repaint();
        }

    }

    private void drawPlace(Graphics graphics, Location location, Color color) {
        graphics.setColor(color);
        graphics.fillRect(
                location.getFloor() * 260 + (1 + (int)Math.floor(location.getRow() * 0.5)) * 75 + (location.getRow() % 2) * 20,
                60 + location.getPlace() * 10,
                20 - 1,
                10 - 1); // TODO use dynamic size or constants
    }


    public static int GetAdHoc(){
        return AdHocCar;
    }
    public static int GetParkPass(){
        return ParkPassCar;
    }
}