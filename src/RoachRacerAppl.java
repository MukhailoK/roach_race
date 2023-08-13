import model.Roach;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoachRacerAppl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numRoaches = 0;
        int distance = 0;
        try {
            System.out.print("Enter the number of tarakans: ");
            numRoaches = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter the race distance: ");
            distance = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numbers.");
            return;
        }

        // The code is creating a list of Roach objects called `roaches` using the `ArrayList` class. It then iterates
        // `numRoaches` times and for each iteration, it creates a new Roach object with the given `distance` and adds it
        // to the `roaches` list. Finally, it starts each Roach thread by calling the `start()` method on each Roach
        // object.
        List<Roach> roaches = new ArrayList<>();
        for (int i = 0; i < numRoaches; i++) {
            Roach roach = new Roach(distance);
            roaches.add(roach);
            roach.start();
        }

        // The code is iterating over the list of Roach objects and calling the `join()` method on each Roach object. The
        // `join()` method is used to wait for a thread to complete its execution. In this case, it is used to wait for
        // each Roach thread to finish racing before proceeding with the rest of the code. If an `InterruptedException`
        // occurs during the waiting process, it will be caught and the stack trace will be printed.
        for (Roach roach : roaches) {
            try {
                roach.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
