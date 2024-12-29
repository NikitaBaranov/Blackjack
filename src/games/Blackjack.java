package games;

import common.*;
import strategies.AI;

import java.util.*;

public class Blackjack {
    private static final int BLACKJACK = 21;

    public void play(List<Player> players) {
        System.out.println("Playing Blackjack!");

        Player dealer = new Player("Dealer", new AI(16));
        System.out.printf("Players at the table, left to right: %s\n",
                String.join(", ", players.stream().map(Player::getName).toList()));

        // Create deck and shuffle
        Deck deck = new Deck();
        deck.shuffle();

        // Deal cards
        dealCards(deck, players, dealer);

        // Check players for Blackjack
        for (Player player : players) {
            if (calculateHandValue(player.getHand()) == BLACKJACK) {
                System.out.println(player.getName() + " has Blackjack!");
                return;
            }
        }

        // Check dealer for Blackjack
        if (calculateHandValue(dealer.getHand()) == BLACKJACK) {
            System.out.println(dealer.getName() + " has Blackjack!");
            return;
        }

        // Players turns
        boolean playerWins = false;
        for (Player player : players) {
            if (turn(player, deck)) {
                playerWins = true;
                break;
            }
        }

        // Dealer's turn
        if (!playerWins) {
            turn(dealer, deck);
        }

        // Game is over add dealer to players
        players.add(dealer);

        // Print all hands
        System.out.print("\nFinal hands:\n");
        for (Player player : players) {
            System.out.println(player.getName() + "'s hand: " + formHand(player.getHand(), false));
        }

        // Compare hands
        int winingHandTotal = 0;
        Map<Integer, List<Player>> handValues = new HashMap<>();

        for (Player player : players) {
            int payerHandValue = calculateHandValue(player.getHand());
            handValues.put(payerHandValue, List.of(player));
            if (payerHandValue <= BLACKJACK && payerHandValue > winingHandTotal) {
                winingHandTotal = payerHandValue;
            }
        }

        // Print the winner
        for (Player player : handValues.get(winingHandTotal)) {
            if (calculateHandValue(player.getHand()) == winingHandTotal) {
                System.out.println(player.getName() + " wins!");
            }
        }

        // Clear hands
        for (Player player : players) {
            player.getHand().clearHand();
        }
    }

    private void dealCards(Deck deck, List<Player> players, Player dealer) {
        System.out.println("Dealing cards...");

        // All users get one card
        for (Player player : players) {
            player.getHand().addCard(deck.dealCard());
        }

        // Dealer gets one card
        dealer.getHand().addCard(deck.dealCard());

        // All users get second card
        for (Player player : players) {
            player.getHand().addCard(deck.dealCard());
        }
        dealer.getHand().addCard(deck.dealCard());

        // Print all hands
        for (Player player : players) {
            System.out.printf("%s's hand: %s\n", player.getName(), formHand(player.getHand(), false));
        }
        System.out.printf("%s's hand: %s\n", dealer.getName(), formHand(dealer.getHand(), true));
    }

    private boolean turn(Player player, Deck deck) {
        System.out.printf("\n%s's turn, hand %s\n", player.getName(), formHand(player.getHand(), false));
        boolean playing = true;
        while (playing) {
            Decision decision = player.getStrategy().makeDecision(calculateHandValue(player.getHand()));
            switch (decision) {
                case HIT:
                    Card card = deck.dealCard();
                    System.out.printf("%s hits and receives %s.\n", player.getName(), card);
                    player.getHand().addCard(card);
                    System.out.printf("%s's hand: %s\n", player.getName(), formHand(player.getHand(), false));
                    break;
                case STAND:
                    System.out.println(player.getName() + " stands.");
                    playing = false;
                    break;
            }
            if (calculateHandValue(player.getHand()) == BLACKJACK) {
                return true;
            }
            if (calculateHandValue(player.getHand()) > BLACKJACK) {
                System.out.println(player.getName() + " busts!");
                return false;
            }
        }

        return false;
    }

    private String formHand(Hand hand, boolean hideSecondCard) {
        if (hideSecondCard) {
            return String.format("Hand (--): %s , <hidden>", hand.getCards().get(0));
        } else {
            return String.format("Hand (%2d): %s", calculateHandValue(hand), hand);
        }
    }

    private int calculateHandValue(Hand hand) {
        int value = 0;
        int aces = 0;

        for (Card card : hand.getCards()) {
            if (card.getValue() == 1) {
                aces++;
            } else {
                value += card.getValue();
            }
        }

        for (int i = 0; i < aces; i++) {
            if (value + 11 <= 21) {
                value += 11;
            } else {
                value += 1;
            }
        }

        return value;
    }
}
