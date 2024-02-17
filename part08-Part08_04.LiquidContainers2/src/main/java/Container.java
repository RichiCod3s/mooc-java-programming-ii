
import java.util.ArrayList;

public class Container {

    private int liquid;

    public Container() {
        this.liquid = 0;
    }

     //returns the amount of liquid in a container as an integer.
    public int contains() {
        return liquid;
    }
    
    // adds the amount of liquid given as a parameter to the container.
    public void add(int amount){
        if(amount>0){
            liquid += amount;
        }
        
        if(liquid >100){
            liquid = 100;
        }
    }
    
    //  removes  amount of liquid. 
    //If the amount is negative, no liquid is removed. A container can never hold less than 0 units of liquid.
    public void remove(int amount){
       if(amount >0){
           liquid-=amount;
           
           if(liquid <0)
               liquid =0;
       }
    }
    
    public String toString(){
        return liquid + "/100";
    }
}
