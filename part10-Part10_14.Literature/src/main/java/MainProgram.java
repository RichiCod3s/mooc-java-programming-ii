
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        while (true) {
            System.out.println("Input the name of the book, empty stops: ");
            String bookName = scanner.nextLine();

            if (bookName.isEmpty()) {
                break;
            }

            System.out.println("Input the age recommendation: ");
            int ageRecommendation = Integer.valueOf(scanner.nextLine());

            Book book = new Book(bookName, ageRecommendation);
            books.add(book);
            
            //ANOTHER WAY
            //books.add(new Book(name, age));
        }
         /*
      
      
        // using the Comparator class - sorting by ageRecommendation
                       //The method reference is given as Class::method
        Comparator<Book> comparator = Comparator.comparing(Book::getAgeRecommendation)
        Collections.sort(books, comparator);

        System.out.println(books.size() + " books in total");
        for (Book book : books) {
            System.out.println(book);
        }*/
        
        // Comparator class - sort by ageRecommendation and then by name
                              //The method reference is given as Class::method
        Comparator<Book> anotherComparator = Comparator.comparing(Book::getAgeRecommendation).thenComparing(Book::getName);
        
        Collections.sort(books, anotherComparator);
        
        System.out.println("Books:");
        System.out.println(books.size() + " books in total.");
        for (Book book : books) {
            System.out.println(book);
        }

    }//main
}//class
