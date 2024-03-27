
import java.util.Comparator;

public class BySuitInValueOrder implements Comparator<Card> {

    // cards are sorted by value inside their suit.
    @Override
    public int compare(Card c1, Card c2) {
        if (c1.getSuit().ordinal() == c2.getSuit().ordinal()) {
            return c1.getValue() - c2.getValue();
        }
        return c1.getSuit().ordinal() - c2.getSuit().ordinal();

    }
}

/*
It can even be done with a lambda function, without ever creating the sorting class.

Collections.sort(cards, (c1, c2) -> c1.getSuit().ordinal() - c2.getSuit().ordinal());

 */
