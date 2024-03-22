
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LiteracyComparison {

    public static void main(String[] args) {
        
        
        try{
        Files.lines(Paths.get("literacy.csv"))
                .map(row -> row.split(","))
                // compareTo also sorts numbers that are String type correctly 
                .sorted((x,y) -> x[5].compareTo(y[5]))
                .forEach(row -> System.out.println(row[3] + " (" + row[4] + "), " + row[2].split(" ")[1].trim() + ", " + row[5]));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
        
    }
        
}
/*Another way to complete this:
src/main/java/LiteracyComparison.java
 
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
 
public class LiteracyComparison {
    
    public static void main(String[] args) {
 
        ArrayList<Result> results = new ArrayList<>();
        try {
            Files.lines(Paths.get("literacy.csv"))
                    .map(l -> l.split(","))
                    .map(a -> new Result(a[2].replace("(%)", "").trim(), a[3], Integer.valueOf(a[4]), Double.parseDouble(a[5])))
                    .forEach(t -> results.add(t));
        } catch (IOException ex) {
            System.out.println("Error reading file.");
        }
        
        results.stream().sorted((t1, t2) -> {
            if (t1.getLiteracyPercent() > t2.getLiteracyPercent()) {
                return 1;
            }
            if (t1.getLiteracyPercent() < t2.getLiteracyPercent()) {
                return -1;
            }
            return 0;
        }).forEach(t -> System.out.println(t));
    }
}
 

src/main/java/Result.java
 
public class Result {
 
    private String sex;
    private String country;
    private int year;
    private double literacyPercent;
 
    public Result(String sex, String country, int year, double literacyPercent) {
        this.sex = sex;
        this.country = country;
        this.year = year;
        this.literacyPercent = literacyPercent;
    }
 
    public double getLiteracyPercent() {
        return literacyPercent;
    }
 
    @Override
    public String toString() {
        return this.country + " (" + this.year + "), " + this.sex + ", " + this.literacyPercent;
    }
}
 


*/

/* Tutorial on sorting without Comparable interface

ArrayList<Person> persons = new ArrayList<>();
persons.add(new Person("Ada Lovelace", 1815));
persons.add(new Person("Irma Wyman", 1928));
persons.add(new Person("Grace Hopper", 1906));
persons.add(new Person("Mary Coombs", 1929));

// sorting an object without the Comparable interface && compareTo() override

// using stream sorted method
persons.stream().sorted((p1, p2) -> {
    return p1.getBirthYear() - p2.getBirthYear();
}).forEach(p -> System.out.println(p.getName()));

System.out.println();

// using Collections.sort()

Collections.sort(persons, (p1, p2) -> p1.getBirthYear() - p2.getBirthYear());


*/
