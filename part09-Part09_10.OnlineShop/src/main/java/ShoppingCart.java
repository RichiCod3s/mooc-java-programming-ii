
import java.util.*;

public class ShoppingCart {

    private Map<String, Item> cart;

    public ShoppingCart() {
        cart = new HashMap();
    }

    public void add(String product, int price) {
        // increase qty of item if product is in cart
        if (cart.containsKey(product)) {
            cart.get(product).increaseQuantity();
        } else {
            Item newItem = new Item(product, 1, price);
            cart.put(product, newItem);
        }
    }

    public int price() {
        int totalPrice = 0;

        for (Item item : cart.values()) {
            totalPrice += item.price();
        }
        return totalPrice;
    }

    public void print() {
        for (String item : cart.keySet()) {
            System.out.println(cart.get(item));
        }
    }
}
