
import java.util.ArrayList;
import java.util.Collections;

public class MainProgram {

    public static void main(String[] args) {
        ArrayList<Human> humans = new ArrayList<>();
        humans.add(new Human("Matti", 150000));
        humans.add(new Human("Merja", 500));
        humans.add(new Human("Pertti", 80));

        System.out.println(humans);

        
        // to sort a object you have created you need to implement Comparable<Object> 
        //& override compareTo 
        Collections.sort(humans);
        System.out.println(humans);

    }
}
