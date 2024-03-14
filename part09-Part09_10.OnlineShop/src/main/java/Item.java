
public class Item {
    
    private String product;
    private int qty;
    private int unitPrice;
    
    public Item(String product, int qty, int unitPrice){
        this.product = product;
        this.qty = qty;
        this.unitPrice= unitPrice;
    }
    // return the price of the item
    public int price(){
        return unitPrice*qty;
    }
    // increases the quantity by one.
    public void increaseQuantity(){
    this.qty++;
}
    public String toString(){
        return this.product+": " + this.qty;
    }
    
}
