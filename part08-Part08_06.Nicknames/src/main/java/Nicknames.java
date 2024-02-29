
import java.util.HashMap;

public class Nicknames {

    public static void main(String[] args) {
        // Do the operations required here!
        
        HashMap<String,String> nickname = new HashMap<>();
        
        nickname.put("Matthew", "Matt");
        nickname.put("Micheal","Mix");
        nickname.put("Arthur","Artie");
        
        System.out.println("Mathews nickname is " + nickname.get("Matthew"));
        
    }

}
