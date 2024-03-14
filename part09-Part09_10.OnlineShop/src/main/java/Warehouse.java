
import java.util.*;

public class Warehouse {

   private Map<String, Integer> price;
   private Map<String, Integer> stock;

    public Warehouse() {
        price = new HashMap<>();
        stock = new HashMap<>();
    }

    //adds a product to the warehouse with the price and stock balance given as parameters.
    public void addProduct(String product, int price, int stock) {
        this.price.putIfAbsent(product, price);// may need to change to put
        this.stock.putIfAbsent(product, stock);
    }

    //returns the price of the product it received as a parameter.
    //If the product hasn't been added to the warehouse, the method must return -99.
    public int price(String product) {
        return price.getOrDefault(product, -99);
    }

    //returns the current remaining stock of the product in the warehouse. 
    //If the product hasn't been added to the warehouse, the method must return 0.
    public int stock(String product) {
        return stock.getOrDefault(product, 0);
    }

    /*reduces the stock remaining for the product it received by one,and returns 
    true if there was stock remaining. If the product was not available in the 
    warehouse the method returns false. A products stock can't go below zero.*/
    public boolean take(String product) {
        if (stock.containsKey(product) && stock.get(product) > 0) {
            int price = stock.get(product) - 1;
            stock.put(product, price);
            return true;
        }
        return false;
    }

    public Set<String> products() {
        // Able to put the products from either HashMap into the Sets constructor
        Set set = new HashSet(price.keySet());
        return set;
    }

}//class
