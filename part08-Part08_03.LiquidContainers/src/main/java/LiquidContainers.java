
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstContainer = 0;
        int secondContainer = 0;

        while (true) {
            System.out.println("First: " + firstContainer + "/100");
            System.out.println("Second: " + secondContainer + "/100");

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            String[] parts = input.split(" ");

            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);

            // ADD functionality
            if (command.equals("add")) {
                if (amount > 0) { // stop more than 100 in 1st container

                    if (amount + firstContainer > 100) {
                        firstContainer = 100;
                    } else {
                        firstContainer += amount;
                    }
                }
            }// end add

            // MOVE functionality
            if (command.equals("move")) {

                if (firstContainer > 0 && amount > 0) {

                    if (amount > firstContainer) {
                        // stop more than 100 in 2nd container
                        if (firstContainer + secondContainer > 100) {
                            secondContainer = 100;
                        } else {
                            secondContainer += firstContainer;
                        }
                        firstContainer = 0;
                    } else {
                        if (firstContainer + secondContainer > 100) {
                            secondContainer = 100;
                        } else {
                            secondContainer += amount;
                        }
                        firstContainer -= amount;
                    }
                }
            }//end move

            // REMOVE functionality 
            if (command.equals("remove")) {
                if (amount > 0 && secondContainer > 0) {

                    if (secondContainer - amount < 0) {
                        secondContainer = 0;
                    } else {
                        secondContainer -= amount;
                    }

                }
            }

        }// while end
    }

}
