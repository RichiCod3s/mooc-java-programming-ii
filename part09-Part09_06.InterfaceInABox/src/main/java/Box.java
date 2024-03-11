
import java.util.ArrayList;

public class Box implements Packable{

    private ArrayList<Packable> box;
    private double maxCapacityKG;

    public Box(double capacity) {
        box = new ArrayList<>();
        maxCapacityKG = capacity;
    }

    public void add(Packable item){
            if (weight() + item.weight() <= maxCapacityKG) {
                box.add(item);
            }
    }
    
    public double weight(){
        double weightOfBox = 0;

        if (!(box.isEmpty())) {
            for(Packable items : box) {
                weightOfBox += items.weight();
            }           
    }
        return weightOfBox;
    }
    
    @Override
    public String toString(){
        return "Box: " + box.size() + " items, total weight " + weight() +" kg";  
    }
}
