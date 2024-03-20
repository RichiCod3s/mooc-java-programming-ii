import java.util.ArrayList;
import java.util.Collections;

public class MainProgram {

    public static void main(String[] args) {
        
      // returns the int value from the compareTo() method  
     Student first = new Student("jamo");
     Student second = new Student("jamo1");
     System.out.println(first.compareTo(second));
     
        System.out.println("");
     
     // Create a list of students
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice"));
        students.add(new Student("Charlie"));
        students.add(new Student("Bob"));

        // Print the list of students before sorting
        System.out.println("Before sorting:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Sort the list of students
        Collections.sort(students);

        // Print the list of students after sorting
        System.out.println("\nAfter sorting:");
        for (Student student : students) {
            System.out.println(student);
        }
        
        System.out.println("");
        
        ArrayList<Student> streamTest = new ArrayList<>();
        streamTest.add(new Student("Jim"));
        streamTest.add(new Student("Zavier"));
        streamTest.add(new Student("Alice"));
        
          // Sort the list of students using streams
          System.out.println("Sort using Stream ");
          streamTest.stream().sorted().forEach(s -> System.out.println(s));
          
    }
}
