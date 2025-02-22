package common;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>(52);
        for (CardSuit suit : CardSuit.values()) {
            for (CardRank value : CardRank.values()) {
                cards.add(new Card(suit, value));
            }
        }
    }

    public void shuffle() {
        for (int i = 0; i < cards.size(); i++) {
            int randomIndex = (int) (Math.random() * cards.size());
            Card temp = cards.get(i);
            cards.set(i, cards.get(randomIndex));
            cards.set(randomIndex, temp);
        }
    }

    public Card dealCard() {
        return cards.remove(0);
    }
}
