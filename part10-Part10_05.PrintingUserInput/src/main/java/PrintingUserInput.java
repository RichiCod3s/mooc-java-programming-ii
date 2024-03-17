
import java.util.ArrayList;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {

        /*reads the user's input as strings. When the user inputs an empty string 
        (only presses enter), the input reading will be stopped and the program will print all the user inputs.*/
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            System.out.println("Enter a String (no input to end):");
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                break;
            }

            list.add(input);
        }

        list.stream().forEach(s -> System.out.println(s));

    }
}
