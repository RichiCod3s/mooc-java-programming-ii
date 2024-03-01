
import java.util.HashMap;

public class Program {

    public static void main(String[] args) {
        // Test your program here!
        HashMap<String, Book> hashmap = new HashMap<>();
        hashmap.put("sense", new Book("Sense and Sensibility", 1811, "..."));
        hashmap.put("prejudice", new Book("Pride and prejudice", 1813, "...."));

        printValues(hashmap);
        System.out.println("---");
        printValueIfNameContains(hashmap, "prejud");
    }

    // prints all the values in the hashmap given as a parameter using
    public static void printValues(HashMap<String, Book> hashmap) {

        for (String key : hashmap.keySet()) {
            System.out.println(hashmap.get(key));
        }
        
        /* other way...
        for (Book value : hashmap.values()) {
            System.out.println(value);*/
    }

    public static void printValueIfNameContains(HashMap<String, Book> hashmap, String text) {
       // get the set of keys
        for (String key : hashmap.keySet()) {
            // if the value of the books name contains the text, print the book object
            if (hashmap.get(key).getName().contains(text)) {
                System.out.println(hashmap.get(key));
            }
        }
        
         /* other way... 
        for (Book value : hashmap.values()) {
            if (value.getName().contains(text)) {
                System.out.println(value);
            }
        }*/
    }

}//class
