package common;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public void clearHand() {
        cards.clear();
    }

    @Override
    public String toString() {
        return String.join(", ", cards.stream().map(Card::toString).toList());
    }
}
