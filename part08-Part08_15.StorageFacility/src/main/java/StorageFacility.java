import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {

   private HashMap<String, ArrayList<String>> storage;
    
    public StorageFacility(){
        this.storage = new HashMap<>();
    }
    
    //adds item to the storage unit
    public void add(String unit, String item){
        // if the unit is not in HashMap create one
        this.storage.putIfAbsent(unit, new ArrayList<>());
        
        //add item to unit's ArrayList
       this.storage.get(unit).add(item);       
    }
    
    // returns a list that contains all the items in the storage unit 
    public ArrayList<String> contents(String storageUnit){
        
        return this.storage.getOrDefault(storageUnit, new ArrayList<>());
    }
    
    //removes the given item from the given storage unit. 
    public void remove(String storageUnit, String Item){
        
        // remove item from StorageUnit ArrayList
        this.storage.get(storageUnit).remove(Item);
        
        // if array is empty, remove the storageUnit from hashMap
        if(this.storage.get(storageUnit).isEmpty()){
            this.storage.remove(storageUnit);
        }    
    }
        //returns the names of the storage units as a list.
         public ArrayList<String> storageUnits(){
         ArrayList<String> storageUnitNames = new ArrayList<>();
         
             for(String storageUnits: this.storage.keySet()){
            storageUnitNames.add(storageUnits);
         }
             
             return storageUnitNames;
     }  
}
