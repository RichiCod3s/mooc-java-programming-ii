
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PositiveNumbers {

    public static void main(String[] args) {
        // test your method here
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(-2);
        numbers.add(3);
        numbers.add(-4);
        numbers.add(5);

        System.out.println("Original numbers: " + numbers);

        List<Integer> positiveNumbers = positive(numbers);

        System.out.println("Positive numbers: " + positiveNumbers);
    }

    //receives an ArrayList of integers, and returns the positive integers from the list.
    public static List<Integer> positive(List<Integer> numbers) {

        //Collectors.toCollection(ArrayList::new) command.
        ArrayList<Integer> positiveNumbers = numbers.stream().filter(i -> i > 0).collect(Collectors.toCollection(ArrayList::new));
        return positiveNumbers;
        
        //Other way: Collectors.toList() 
        //return numbers.stream().filter(number -> number > 0).collect(Collectors.toList());
    }

}// class
