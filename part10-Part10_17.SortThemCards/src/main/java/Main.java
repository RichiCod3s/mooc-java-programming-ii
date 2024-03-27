
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        // test your code here
        ArrayList<Card> cards = new ArrayList<>();

        cards.add(new Card(3, Suit.SPADE));
        cards.add(new Card(2, Suit.DIAMOND));
        cards.add(new Card(14, Suit.SPADE));
        cards.add(new Card(12, Suit.HEART));
        cards.add(new Card(2, Suit.SPADE));

        // using a class to sort by value inside their suit
        BySuitInValueOrder bySuitInValueOrder = new BySuitInValueOrder();
        Collections.sort(cards, bySuitInValueOrder);
        cards.stream().forEach(c -> System.out.println(c));

        System.out.println("");
        // testing hand class

        Hand hand = new Hand();

        hand.add(new Card(12, Suit.HEART));
        hand.add(new Card(4, Suit.SPADE));
        hand.add(new Card(2, Suit.DIAMOND));
        hand.add(new Card(14, Suit.SPADE));
        hand.add(new Card(7, Suit.HEART));
        hand.add(new Card(2, Suit.SPADE));

        // sorts by using a class that implements comparator
        hand.sortBySuit();

        hand.print();

        System.out.println("");

        Hand hand2 = new Hand();

        hand2.add(new Card(11, Suit.DIAMOND));
        hand2.add(new Card(11, Suit.SPADE));
        hand2.add(new Card(11, Suit.HEART));

        // sorted using the comparator object
        hand2.sort();

        hand2.print();

        System.out.println("");
        
        //comparing hands overiding compareTo()
        int comparison = hand.compareTo(hand2);

        if (comparison < 0) {
            System.out.println("better hand is");
            hand2.print();
        } else if (comparison > 0) {
            System.out.println("better hand is");
            hand.print();
        } else {
            System.out.println("hands are equal");
        }

    }//main

}//class
