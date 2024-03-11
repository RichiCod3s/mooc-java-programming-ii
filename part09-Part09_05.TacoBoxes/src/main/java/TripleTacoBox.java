
public class TripleTacoBox implements TacoBox {

    private int tacos;

    public TripleTacoBox() {
        this.tacos = 3;
    }

    //Return the number of tacos remaining in the box.
    @Override
    public int tacosRemaining() {
        return this.tacos;
    }

    //reduces the number of tacos remaining by one. 
    @Override
    public void eat() {
        if (this.tacos > 0) {
            this.tacos -= 1;
        }
    }

}
