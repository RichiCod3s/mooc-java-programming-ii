
import java.util.HashMap;
import java.util.ArrayList;
public class VehicleRegistry {

   private HashMap<LicensePlate, String> registry;

    public VehicleRegistry() {
        registry = new HashMap<>();
    }

    /* assigns the owner to a car that corresponds to the license plate. If the 
    license plate doesn't have an owner, the method returns true. If the license 
    already has an owner attached, the method returns false and does nothing.*/
    public boolean add(LicensePlate licensePlate, String owner) {
        // if the license has an owner
        if (registry.containsKey(licensePlate)) {
            return false;
        } else { // add plate and owner to registry
            registry.put(licensePlate, owner);
            return true;
        }
    }
    
    // returns the owner of the car corresponding to the license plate
    //If the car isn't in the registry, the method returns null.
    public String get(LicensePlate licensePlate){
        return registry.getOrDefault(licensePlate,null);
    }
    
    //removes the license plate and attached data from the registry. The method 
    //returns true if removed successfully and false if the license plate wasn't in the registry.
    public boolean remove(LicensePlate licensePlate){
        if(!(registry.containsKey(licensePlate))){
            return false;
        }else{
            registry.remove(licensePlate);
            return true;
        }
    }
    
    public void printLicensePlates(){
        for(LicensePlate plates: registry.keySet()){
            System.out.println(plates);
        }
    }
    
    /*prints the owners of the cars in the registry. Each name should only be 
    printed once, even if a particular person owns more than one car*/
    public void printOwners(){
        //use a list to keep track of owners so they are not printed twice
        ArrayList<String> list = new ArrayList<>();
        
        for(LicensePlate plate : registry.keySet()){
            // if list contains owner skip otherwise add owner to list and print
            if(list.contains(registry.get(plate))){
                //do nothing//
                continue;
            }else{
                list.add(registry.get(plate));
                System.out.println(   registry.get(plate));
            }
         
        }
    }
}
