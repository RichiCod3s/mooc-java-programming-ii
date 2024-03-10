import java.util.ArrayList;
import java.util.Collections;

public class ChangeHistory {
    private ArrayList<Double> list;
    
    public ChangeHistory(){
    list = new ArrayList<>();
    }
    
    //adds provided status as the latest amount to remember in the change history.
    public void add(double status){
        if(status >0){
             list.add(status);
        }   
    }
    
    //empties the history.
    public void clear(){
        list.clear();
    }
    
    // returns the largest value in the change history.
    public double maxValue(){
      
        if(list.isEmpty()){
           return 0;
       }else{
       double max = list.get(0);
       for(double i : list){
           if(max< i){
               max =i;
           }
       }
       return max;
       }
    }
    
    //eturns the smallest value in the change history.
    public double minValue(){
        if(list.isEmpty()){
           return 0;
       }else{
       double min = list.get(0);
       for(double i : list){
           if(min> i){
               min =i;
           }
       }
       return min;
       }
    }
    //returns the average of the values in the change history. 
    public double average(){
        // start here tommorrow
        double sum =0.0;
        int count =0;
        
        for(double values : list){
            sum += values;
            count++;
        }
        return sum / count;
    }
    
    public String toString(){
       return list.toString();
    }
    
}
