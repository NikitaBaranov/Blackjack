import common.Player;
import games.Blackjack;
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
        System.out.println("Enter 1 for BlackJack, 2 for 5 Card Draw, 3 for ...");
        System.out.print("> ");

        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1:
                Blackjack blackJack = new Blackjack();
                blackJack.play(userNames);
                break;
            case 2:
                // create an object of the 5 card draw poker game
                // play
                break;
            case 3:
                // create an object of the 7 card draw poker game
                // play
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
