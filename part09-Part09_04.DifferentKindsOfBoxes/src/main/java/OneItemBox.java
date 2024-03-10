import java.util.ArrayList;

public class OneItemBox extends Box {
    private ArrayList<Item> box;
    
    public OneItemBox(){
        box = new ArrayList<>();
    }
    
    //has the capacity of exactly one item. 
    //If there is already an item in the box,it must not be switched.
     @Override
    public void add(Item item){
        if(box.isEmpty()){
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
