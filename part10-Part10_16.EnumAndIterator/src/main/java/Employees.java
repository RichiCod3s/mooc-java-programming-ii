
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employees {

    private ArrayList<Person> employees;

    public Employees() {
        employees = new ArrayList<>();
    }

    //adds the given person to the employees list
    public void add(Person personToAdd) {
        employees.add(personToAdd);
    }

    //adds the given list of people to the employees list
    public void add(List<Person> peopleToAdd) {
        for (Person people : peopleToAdd) {
            employees.add(people);
        }
    }

    //prints all employees
    public void print() {
        Iterator<Person> iterator = employees.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //prints the employees whose education matches the education given as a parameter.
    public void print(Education education) {
        Iterator<Person> iterator = employees.iterator();

        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getEducation() == education) {
                System.out.println(person);
            }
        }
    }
    
    public void fire(Education education){
         Iterator<Person> iterator = employees.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().getEducation() == education) {
                iterator.remove();
            }
        }
    }
}// class
