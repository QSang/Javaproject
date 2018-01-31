package parkeersimulator.logic;
import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;



public class CarQueue {
    private Queue<Car> queue = new LinkedList<>();

    /**
     * Adds a car to the queue and returns the queue.
     *
     * @param car Car to add to the queue.
     * @return Queue with the car added.
     */
    public boolean addCar(Car car) {
        return queue.add(car);
    }

    /**
     * Removes a car from the head of the queue and returns the queue.
     *
     * @return Queue
     */
    public Car removeCar() {
        return queue.poll();
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     *
     * @return Queue
     */
    public Car peekCar() {
        return queue.peek();
    }

    /**
     * Returns amounts of car in the queue.
     *
     * @return Size of queue.
     */
    public int carsInQueue() {
        return queue.size();
    }


    public static void warningOverCrowdedCars() {
        JOptionPane.showMessageDialog(null, "De parkeergarage heeft zijn maximum overtreden");
    }


    public static void warningOverCrowdedQueue() {
        JOptionPane.showMessageDialog(null, "De wachtrij heeft zijn maximum overtreden");
    }
}
