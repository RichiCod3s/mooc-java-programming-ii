
import java.util.ArrayList;

public class Pipe<T> {

    private ArrayList<T> pipe;

    public Pipe() {
        pipe = new ArrayList<>();
    }

    //puts an object with a type in accordance with the type parameter given to the the class into the pipe.
    public void putIntoPipe(T value) {
        pipe.add(value);
    }

    /*
     takes out the value, which has been in the pipe the longest. 
    In case there is nothing in the pipe, return null. Calling the method returns the value, which has been in the pipe the longest, and removes it from the pipe.
     */
    public T takeFromPipe() {

        if (pipe.isEmpty()) {
            return null;
        } else {
            T take = pipe.get(0);
            pipe.remove(0);
            return take;
        }
    }

    // returns the value true if the pipe has values. In case the pipe is empty, it returns the value false.
    public boolean isInPipe() {
        return !pipe.isEmpty();
    }

}
