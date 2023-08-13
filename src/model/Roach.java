package model;

import java.util.Random;

public class Roach extends Thread{
    // The code `private static int roachCount = 0;` declares a private static variable `roachCount` of type `int` and
    // initializes it to 0. This variable is used to keep track of the number of Roach objects created.
    private static int roachCount = 0;
    private static Roach winner = null;
    private static final Object lock = new Object();

    private int number;
    private int distance;

    public Roach(int distance) {
        this.number = ++roachCount;
        this.distance = distance;
    }

    // The `@Override` annotation is used to indicate that the method is intended to override a method in the superclass or
    // interface. In this case, the `run()` method is being overridden from the `Thread` class.
    @Override
    public void run() {
        int totalDistance = 0;
        while (totalDistance < distance) {
            int sleepTime = new Random().nextInt(4) + 2; // Sleep for 2-5 milliseconds
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            totalDistance++;
            System.out.println("Tarakan #" + number + " has run " + totalDistance + " iterations.");
        }

        // The `synchronized (lock)` block is used to ensure that only one thread can access the code inside the block at a
        // time. In this case, it is used to ensure that only one Roach thread can set itself as the winner.
        synchronized (lock) {
            if (winner == null) {
                winner = this;
                System.out.println("Congratulations to tarakan #" + number + " (winner)!");
            }
        }
    }
}
