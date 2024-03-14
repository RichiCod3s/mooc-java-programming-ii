
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> input = new ArrayList<>();
        
        System.out.println("Input numbers, type\"end\" to stop");
        while(true){
            String row = scanner.nextLine();
            
            if(row.equals("end")){
                break;
            }
            
            input.add(row);
        }
        
        System.out.println("Print the average of the negative numbers or the positive numbers?(n/p)");
        String choice = scanner.nextLine();
        if(choice.equals("n")){
            // using a stream on collection(ArrayList), changes String to int, filters to negative numbers, gets the average and converts to double
            System.out.println(input.stream().mapToInt(s -> Integer.valueOf(s)).filter(number -> number<0).average().getAsDouble());
        }else if(choice.equals("p")){
            // exact same but filters to positive numbers
            System.out.println(input.stream().mapToInt(s -> Integer.valueOf(s)).filter(number -> number>0).average().getAsDouble());
        }
        
        // note to self if you had an Array<Integer> instead of String, you would still need the mapToInt tp convert from reference to :
        //System.out.println("Average of the negative numbers: " + input.stream().filter(l -> l < 0).mapToInt(i -> i).average().getAsDouble());
    }
}
