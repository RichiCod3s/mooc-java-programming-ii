
import java.util.Scanner;

public class Cubes {
/*the program should handle the input as an integer and 
    print the cube of the integer (meaning number * number * number)*/
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(true){
          String input = scanner.nextLine();
          
          if(input.equals("end")){
              break;
          }
          
          //String to Integer
          int number = Integer.valueOf(input);
          
           // used Math.pow to x inout by itsled 3x
            System.out.println((int)Math.pow(number, 3));
            //test
        }
    }
}
