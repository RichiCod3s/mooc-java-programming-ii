

public class Card implements Comparable<Card> {

    private int value;
    private Suit suit;

    public Card(int value, Suit suit) {
        if (value < 2 || value > 14) {
            throw new IllegalArgumentException("Card value must be in range 2...14.");
        }

        this.value = value;
        this.suit = suit;
    }

    @Override
    public String toString() {
        String cardValue = "" + value;
        if(value == 11) {
            cardValue = "J";
        } else if (value == 12) {
            cardValue = "Q";
        } else if (value == 13) {
            cardValue = "K";
        } else if (value == 14) {
            cardValue = "A";
        }
        
        return suit + " " + cardValue;
    }

    public int getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }
    
    //sorted by club first, diamond second, heart third, and spade last.
    //if values are the same sort by Suit using the ordinal() method
    public int compareTo(Card cardToCompare){
       if (this.getValue() == cardToCompare.getValue()) {
           //Returns the ordinal of this enumeration constant . ie what position the Enum is in
    		return  this.getSuit().ordinal() - cardToCompare.getSuit().ordinal();
		}
		return this.getValue() - cardToCompare.getValue();
	}
    
    
    
    }// class


