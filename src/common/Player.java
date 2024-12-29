package common;

import strategies.Strategy;

public class Player {
    private final String name;
    private final Hand hand;
    private final Strategy strategy;

    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;

        this.hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public Strategy getStrategy() {
        return strategy;
    }
}
