
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Container first = new Container();
        Container second = new Container();

        while (true) {
            System.out.println("First: "+first.toString());
            System.out.println("Second: "+second.toString());
                 
            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            String[] parts = input.split(" ");

            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);

            // ADD functionality
            if (command.equals("add")) {
               first.add(amount);
               
            }// end add

            // MOVE functionality
            if (command.equals("move")) {
                if(first.contains() < amount){
                second.add(first.contains());
                first.remove(first.contains());
                }else{
                    second.add(amount);
                    first.remove(amount);
                }
             
            }//end move

            // REMOVE functionality 
            if (command.equals("remove")) {
              second.remove(amount);
            }

        }// while end

    }
}
