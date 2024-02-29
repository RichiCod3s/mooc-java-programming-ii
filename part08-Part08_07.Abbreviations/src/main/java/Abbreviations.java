
import java.util.HashMap;

public class Abbreviations {

    HashMap<String, String> hashmap;

    public Abbreviations() {
        this.hashmap = new HashMap<>();
    }

    // adds a new abbreviation and its explanation.
    public void addAbbreviation(String abbreviation, String explanation) {
        this.hashmap.put(abbreviation,explanation);
    }
    
    //checks if an abbreviation has already been added
    public boolean hasAbbreviation(String abbreviation){
        if(hashmap.containsKey(abbreviation)){
            return true;
        }
        
        return false;
    }
    
    //finds the explanation for an abbreviation;
    public String findExplanationFor(String abbreviation){
        if(!(hasAbbreviation(abbreviation))){
            return null;
        }
        
        return hashmap.get(abbreviation);
               
    }
}
