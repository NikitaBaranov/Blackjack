package games;

public enum Game {
    BLACKJACK("Blackjack", "The goal is to get as close to 21 as possible without going over.", "b"),
    POCKER_5_CARD_DRAW("5 Card Draw Poker", "The goal is to have the best hand after the draw.", "5"),
    POCKER_7_CARD_DRAW("7 Card Draw Poker", "The goal is to have the best hand after the draw.", "7");

    private String name;
    private String description;
    private String key;

    Game(String name, String description, String key) {
        this.name = name;
        this.description = description;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getKey() {
        return key;
    }

    public static Game getGameByKey(String key) {
        for (Game game : Game.values()) {
            if (game.getKey().equals(key)) {
                return game;
            }
        }
        return null;
    }
}
