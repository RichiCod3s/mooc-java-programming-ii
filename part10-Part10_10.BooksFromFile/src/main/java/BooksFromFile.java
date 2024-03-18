
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BooksFromFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //presume that the book files are in the following format: name,publishing year,page count,author
        //The name and the author of the book are processed as strings, and the publishing year and the page count are processed as integers.
    }

    public static List<Book> readBooks(String file) {
        List<Book> books = new ArrayList<>();

        try {
            //reading the  file line by line
            Files.lines(Paths.get(file))
                    // splitting the row into parts on the "," character
                    .map(row -> row.split(","))
                    //deleting the split rows that have less than four parts (Book has a four argument constructor)
                    .filter(parts -> parts.length >= 4)
                    // creating Book from the parts
                    //public Book(String name, int ReleaseYear, int pages, String author) 
                    .map(parts -> new Book(parts[0], Integer.valueOf(parts[1]), Integer.valueOf(parts[2]), parts[3]))
                    // and finally add the persons to the list
                    .forEach(book -> books.add(book));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return books;
        
        /* ANOTHER WAY: Using Collectors.toList()  
        try {
            return Files.lines(Paths.get(file))
                    .map(line -> line.split(","))
                    .map(parts -> new Book(parts[0], Integer.valueOf(parts[1]), Integer.valueOf(parts[2]), parts[3]))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        */
    }
}
