
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        //asks user for input until the user inputs 0. 
        //After this, the program prints the average of the positive numbers (numbers that are greater than zero)
        Scanner scanner = new Scanner(System.in);

        int input;
        int sum = 0;
        int count = 0;
        double average = 0;

        do {
            input = scanner.nextInt();
            if (input > 0) {
                sum += input;
                count++;
            }
        } while (input != 0);

        if (count == 0) {
            System.out.println("Cannot calculate the average");
        } else {
            average = (double) sum / count;
            System.out.println(average);
        }

    }
}
