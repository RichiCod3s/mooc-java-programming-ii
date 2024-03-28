
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hand implements Comparable<Hand> {

   private ArrayList<Card> hand;

    public Hand() {
        hand = new ArrayList<>();
    }

    public void add(Card card) {
        hand.add(card);
    }

    public void print() {
        for (Card card : hand) {
            System.out.println(card);
        }
    }
    //sorts the cards in the hand using the Comparator class
    public void sort() {
        Comparator<Card> comparator = Comparator
				.comparing(Card::getValue)
				.thenComparing(Card::getSuit);

		Collections.sort(hand, comparator);
    }
    
    // hands are ranked based on the sum of values of its cards
    @Override
    public int compareTo(Hand handToCompare) {
        //get value of my hand
        int thisHandValue = this.hand.stream().mapToInt(Card::getValue).sum();
        // get value of comparing hand
        int compareHandValue = handToCompare.hand.stream().mapToInt(Card::getValue).sum();
        //compare
        return thisHandValue - compareHandValue;

        
        /*OTHER WAY
		int thisHandValue = 0;
		for (Card card : hand) {
			thisHandValue += card.getValue();
		}
		int compareHandValue = 0;
		for (Card card : handToCompare.hand) {
			compareHandValue += card.getValue();
		}

		return thisHandValue - compareHandValue;
         */
    }
    // use the BySuitInValeOrder class in collections.sort
    public void sortBySuit(){
        Collections.sort(hand, new BySuitInValueOrder());
        
        /* Another way
        BySuitInValueOrder valueOrder = new BySuitInValueOrder();
        Collections.sort(hand, BySuitInValueOrder());
        */
    }

}//class
