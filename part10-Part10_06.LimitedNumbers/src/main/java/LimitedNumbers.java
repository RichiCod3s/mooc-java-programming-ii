
import java.util.ArrayList;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        /*When the user gives a negative number as an input, the input reading will be stopped. 
        After this, print all the numbers the user has given as input that are between 1 and 5.*/

        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        while (true) {
            System.out.println("Enter positive int value (negative value to end):");
            int input = scanner.nextInt();
            if (input < 0) {
                break;
            }
            list.add(input);
        }

        list.stream().filter(i -> i >= 1 && i <= 5).forEach(i -> System.out.println(i));
    }
}
