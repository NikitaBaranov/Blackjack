import common.Player;
import games.Blackjack;
import games.Game;
import strategies.Human;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Let's play a game!");
        int numberOfPlayers = getNumberOfPlayers();

        String[] userNames = new String[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            String userName = getUserName(i + 1);
            userNames[i] = userName;
        }

        System.out.println("What game would you like to play?");
        for (Game game : Game.values()) {
            System.out.printf("%s: %s\n", game.getKey(), game.getName());
        }

        Game game;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            game = Game.getGameByKey(input);
            if (game != null) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter a valid key.");
            }
        }

        switch (game) {
            case BLACKJACK:
                Blackjack blackJack = new Blackjack();
                blackJack.play(userNames);
                break;
            case POCKER_5_CARD_DRAW:
                System.out.println("5 Card Draw Poker, not implemented yet.");
                break;
            case POCKER_7_CARD_DRAW:
                System.out.println("7 Card Draw Poker, not implemented yet.");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private static int getNumberOfPlayers() {
        Scanner scanner = new Scanner(System.in);
        int numberOfPlayers = 0;

        boolean selecting = true;
        while (selecting) {
            System.out.println("How many human players will play?");
            System.out.print("> ");
            String input = scanner.nextLine();

            try {
                numberOfPlayers = Integer.parseInt(input);
                if (numberOfPlayers >= 2) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number greater than 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        return numberOfPlayers;
    }

    private static String getUserName(int playerNumber) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("What is the name of player %d?\n", playerNumber);
        System.out.print("> ");
        return scanner.nextLine();
    }

}
