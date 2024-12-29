package common;

public enum CardSuit {
    HEARTS('♥', "Hearts"),
    DIAMONDS('♦', "Diamonds"),
    CLUBS('♣', "Clubs"),
    SPADES('♠', "Spades");

    private char symbol;
    private String name;

    CardSuit(char symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }
}
