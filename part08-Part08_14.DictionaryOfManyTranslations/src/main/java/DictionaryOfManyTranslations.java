import java.util.ArrayList;
import java.util.HashMap;

public class DictionaryOfManyTranslations {
   private HashMap<String, ArrayList<String>> translations;
    
    public DictionaryOfManyTranslations(){
    translations = new HashMap<>();
    }
    
    public void add(String word, String translation){
    //putIfAbsent is useful when you want to avoid overwriting existing values in the map
    // if new hashmap with arraylist if none exists
        this.translations.putIfAbsent(word, new ArrayList<>());
        
        // add translation to arraylist
        this.translations.get(word).add(translation);    
    }
    
    //returns a list of the translations added for the word.
    public ArrayList<String> translate(String word){
       //return translations Arraylist or if word doesn't exist return an empty ArrayList NullPointerException)
           return translations.getOrDefault(word,new ArrayList<>());      
    }
    
    //removes the word and all its translations from the dictionary.
    public void remove(String word){
        translations.remove(word);
    }
}
