
import java.util.ArrayList;

public class MisplacingBox extends Box{
   private ArrayList<Item> box;
    public MisplacingBox(){
         box = new ArrayList<>();
    }
    
     public void add(Item item){
            box.add(item);
    }
    /*You can add any items to a misplacing box, 
     but items can never be found when looked for*/
     @Override
     public boolean isInBox(Item item){      
        return false;
    }
    
}
