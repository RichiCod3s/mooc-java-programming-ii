
import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("How many random numbers should be printed?");
        
        int howMany = scanner.nextInt();
        
        for(int i=0; i<howMany; i++){
            //The printed numbers should be within the range [0, 10]
            int randomNumber = random.nextInt(11);
            System.out.println(randomNumber);
            
            //  System.out.println(random.nextInt(11));
        }
        
        
    }

}
