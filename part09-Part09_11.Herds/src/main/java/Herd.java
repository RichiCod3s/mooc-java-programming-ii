import java.util.*;
        
public class Herd implements Movable {
    
    private ArrayList<Movable> herd;
    
    public Herd(){
    herd = new ArrayList<>();    
    }
    
    @Override
    public String toString(){
      String print ="";
      for(Movable org : herd){
          print += org.toString()+"\n";
      }
      return print;
      
    }
    
    public void addToHerd(Movable movable){
        herd.add(movable);
    }
    
    @Override
    public void move(int dx, int dy){
        for(Movable organism: herd){
            organism.move(dx, dy);
        }
    }
    
    
    
    
}
