
import java.util.ArrayList;
import java.util.HashMap;


public class Main {

    public static void main(String[] args) {
        
        VehicleRegistry registry = new VehicleRegistry();
        
        // the following is the same sample program shown in ex 8.13 description
        /*
        LicensePlate li1 = new LicensePlate("FI", "ABC-123");
        LicensePlate li2 = new LicensePlate("FI", "UXE-465");
        LicensePlate li3 = new LicensePlate("D", "B WQ-431");

        ArrayList<LicensePlate> finnishPlates = new ArrayList<>();
        finnishPlates.add(li1);
        finnishPlates.add(li2);

        LicensePlate newLi = new LicensePlate("FI", "ABC-123");
        if (!finnishPlates.contains(newLi)) {
            finnishPlates.add(newLi);
        }
        System.out.println("Finnish: " + finnishPlates);
        // if the equals-method hasn't been overwritten, the same license number will be added to the list againg
        
        HashMap<LicensePlate, String> owners = new HashMap<>();
        owners.put(li1, "Arto");
        owners.put(li3, "Jürgen");

        System.out.println("owners:");
        System.out.println(owners.get(new LicensePlate("FI", "ABC-123")));
        System.out.println(owners.get(new LicensePlate("D", "B WQ-431")));
        // if the hasCode-method hasn't been overwritten, the owners won't be found
        
      */  
        
        // Testing Registry Class
        
            // Test adding license plates with different owners
        LicensePlate plate1 = new LicensePlate("FI", "ABC-123");
        LicensePlate plate2 = new LicensePlate("US", "XYZ-987");

        System.out.println("Adding license plates:");
        System.out.println("Add result for plate1: " + registry.add(plate1, "John"));
        System.out.println("Add result for plate2: " + registry.add(plate2, "Alice"));

        // Test adding a license plate that already exists
        System.out.println("Add result for plate1 (again): " + registry.add(plate1, "Bob"));

        // Test printing license plates
        System.out.println("\nLicense plates in registry:");
        registry.printLicensePlates();

        // Test getting owner for a license plate
        System.out.println("\nOwner of plate1: " + registry.get(plate1));

        // Test removing a license plate
        System.out.println("\nRemoving plate2:");
        System.out.println("Remove result for plate2: " + registry.remove(plate2));

        // Test printing owners
        System.out.println("\nOwners in registry:");
        registry.printOwners();
    }
        
    }

