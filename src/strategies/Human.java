package strategies;

import common.Decision;

import java.util.Scanner;

public class Human implements Strategy {
    @Override
    public Decision makeDecision(int handValue) {
        System.out.println("Would you like to hit (h) or stand (s)?");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");

            String input = scanner.nextLine();
            switch (input) {
                case "h":
                    return Decision.HIT;
                case "s":
                    return Decision.STAND;
                default:
                    System.out.printf("Invalid input: [%s]. Please enter 'h' or 's'.\n", input);
            }
        }
    }
}
