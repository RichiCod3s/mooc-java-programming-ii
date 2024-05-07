package title;

import java.util.Scanner;
import javafx.application.Application;


public class Main {

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter title for GUI window");
        String title = scanner.nextLine();
        
        // we use the Application class itself
       Application.launch(UserTitle.class, "--title=" + title);// //passes the title parameter from the user input
       //Note: that this must all be one word: "--title=" + title
       
    }

}
