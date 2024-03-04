
import java.util.HashMap;

public class IOU {
/*The IOU does not care about old debt. When you set a new sum owed to a person 
  when there is some money already owed to the same person, the old debt is forgotten.*/
    private HashMap<String, Double> owed;

    public IOU() {
        this.owed = new HashMap<>();
    }

//saves the amount owed and the person owed to to the IOU.
    public void setSum(String toWhom, double amount) {
        this.owed.put(toWhom, amount);
    }

//returns the amount owed to the person whose name is given as a parameter. If the person
    public double howMuchDoIOweTo(String toWhom) {
        // getOrDefault returns 0.0 if toWhom is not known
        // eliminates nullPointerException
      return  this.owed.getOrDefault(toWhom,0.0);
    }

}
