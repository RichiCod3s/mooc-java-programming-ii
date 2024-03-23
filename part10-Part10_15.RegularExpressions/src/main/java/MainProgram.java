

public class MainProgram {

    public static void main(String[] args) {
        // you can create test code here. Call the methods that you'll implement
        // during the course of this exercise
        
        Checker checker = new Checker();
        System.out.println(checker.isDayOfWeek("sun"));
        System.out.println(checker.allVowels("ae"));
        System.out.println(checker.timeOfDay("20:00:00"));
}
}