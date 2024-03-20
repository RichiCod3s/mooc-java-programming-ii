
public class Student implements Comparable<Student> {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    //sorts the students in alphabetical order based on their names.
    // Note that String.compareTo() also treats letters according to their size, 
    //while the compareToIgnoreCase method of the same class ignores the capitalization completely
    @Override
    public int compareTo(Student student) {
        return this.name.compareToIgnoreCase(student.getName());

    }

}
