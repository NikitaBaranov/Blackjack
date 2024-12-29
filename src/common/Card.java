package common;

public class Card {
    private final CardSuit suit;
    private final CardValue value;

    public Card(CardSuit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public int getValue() {
        return value.getValue();
    }

    @Override
    public String toString() {
        return String.format("%s of %s (%s%d)", value.getName(), suit.getName(), suit.getSymbol(), value.getValue());
    }
}
