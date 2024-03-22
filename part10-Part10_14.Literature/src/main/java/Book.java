
public class Book {

    private String name;
    private int ageRecommendation;

    public Book(String name, int ageRecommendation) {
        this.name = name;
        this.ageRecommendation = ageRecommendation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAgeRecommendation() {
        return ageRecommendation;
    }

    public void setAgeRecommendation(int ageRecommendation) {
        this.ageRecommendation = ageRecommendation;
    }
    
    public String toString(){
        return getName() + " (recommended for " +getAgeRecommendation() + " year-olds or older)";
    }
    
    
    
    
    
    
    
    
    
    
}
