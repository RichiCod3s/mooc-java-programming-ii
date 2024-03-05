import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {

    HashMap<String, ArrayList<String>> storage;
    
    public StorageFacility(){
        storage = new HashMap<>();
    }
    
    public void add(String unit, String item){
        // if the unit is not in HashMap create one
        storage.putIfAbsent(unit, new ArrayList<>());
        
        //add item to unit's ArrayList
       storage.get(unit).add(item);       
    }

    
}
