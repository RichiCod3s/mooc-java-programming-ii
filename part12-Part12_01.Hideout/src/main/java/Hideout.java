
import java.util.ArrayList;

public class Hideout<T> {

    ArrayList<T> hideout;

    public Hideout() {
        hideout = new ArrayList();
    }

    //puts an object with a type in accordance with the type parameter given to the the class into the hideout. 
    //In case an object is already in the hideout, it will disappear.
    public void putIntoHideout(T toHide) {
        if (!hideout.isEmpty()) {
            this.hideout.clear();
        }

        this.hideout.add(toHide);
    }

    /*
    takes out the object with a type in accordance with the type parameter given
    to the the class from the hideout. In case there is nothing in the hideout, we return null. 
    Calling the method returns the object in the hideout and removes the object from the hideout.
     */
    public T takeFromHideout() {
        if (hideout.isEmpty()) {
            return null;
        } else {
            T take = hideout.get(0);
            hideout.clear();
            return take;
        }

    }
    
    //returns the value true if there is an object in the hideout. 
    //In case there isn't an object in the hideout, it should return the value false.
        public boolean isInHideout(){
    
    return !hideout.isEmpty();
}
        
        
        
}//main


/* Another Way

public class Hideout<T> {
 
    private T inHiding;
 
    public void putIntoHideout(T toHide) {
        this.inHiding = toHide;
    }
 
    public boolean isInHiding() {
        return this.inHiding != null;
    }
 
    public T takeFromHideout() {
        T previouslyInHiding = this.inHiding;
        this.inHiding = null;
        return previouslyInHiding;
    }
}
 

*/