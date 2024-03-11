
public class CD implements Packable{
    private String artist;
    private String nameOfCD;
    private int published;
    private double weight;
    
    public CD(String artist, String nameOfCD, int published){
        this.artist = artist;
        this.nameOfCD = nameOfCD;
        this.published = published;
        this.weight = 0.1;
    }
    @Override
    public double weight() {
        return this.weight;
    }
    
    public String toString(){
        return this.artist + ": "+ this.nameOfCD +" ("+this.published+")";
    }
}
