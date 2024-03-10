import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {
    
    private int capacity;
    private ArrayList<Item> box;
    
    public BoxWithMaxWeight(int capacity){
    this.capacity = capacity;
    box = new ArrayList<>();
    }
     @Override
    public void add(Item item){
      int weight =0;
      
        if(!(box.isEmpty())){
           for(Item inBox: box){
           weight += inBox.getWeight();
           }
       }
        if(weight + item.getWeight()<= this.capacity){
            box.add(item);
        }
    }
     @Override
    public boolean isInBox(Item item){
        boolean inBox = false;
        for(Item itemInBox: box){
            if(itemInBox.equals(item)){
                inBox = true;
            }
        }
        return inBox;
    }
    
    
}
