package common;

public class Card {
    private final CardSuit suit;
    private final CardRank rank;

    public Card(CardSuit suit, CardRank value) {
        this.suit = suit;
        this.rank = value;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public CardRank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return String.format("%s of %s (%s%d)", rank.getName(), suit.getName(), suit.getSymbol(), rank.getRank());
    }
}
