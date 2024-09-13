package nl.hu.bep2.casino.blackjack.domein;

import nl.hu.bep2.casino.blackjack.domein.Result.Results;
import nl.hu.bep2.casino.blackjack.domein.Result.ResultsFunctions;
import nl.hu.bep2.casino.blackjack.domein.people.Dealer;
import nl.hu.bep2.casino.blackjack.domein.people.Choices;
import nl.hu.bep2.casino.blackjack.domein.people.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean continuePlaying = true;

        while (continuePlaying) {
            Player player = new Player();
            Dealer dealer = new Dealer();
            Choices playerChoice = null;

            // Show dealer's first card and the player's initial hand
            System.out.println("Dealer's cards: " + dealer.getDealerCards().get(0) + " [Hidden]");
            System.out.println("Your cards: " + player.getPlayerCards());
            System.out.println("Your card value: " + player.getHandValue());

            // Check for Blackjack after showing the initial hand
            if (player.getPlayerCards().size() == 2 && player.getHandValue() == 21) {
                System.out.println("You have Blackjack! Automatically standing.");
                playerChoice = Choices.STAND;
                dealer.play(); // Dealer plays immediately
                showFinalResults(player, dealer); // Show results
                continuePlaying = promptRetry(scanner); // Prompt to retry
                continue; // Skip to the next game iteration
            }

            // Player's turn loop
            boolean playerTurn = true;
            while (playerTurn) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Choose an option:");
                System.out.println("1. Hit  2. Stand  3. Double  4. Surrender");

                try {
                    int choice = scanner.nextInt();
                    playerChoice = getChoiceFromInput(choice);

                    if (playerChoice != null) {
                        System.out.println("You chose: " + playerChoice);
                        player.chooseAction(playerChoice);

                        if (player.getHandValue() > 21) {
                            playerChoice = Choices.SURRENDER; // Mark as surrender if bust
                            playerTurn = false;
                            System.out.println("You bust! You lose.");
                        } else if (playerChoice == Choices.STAND || playerChoice == Choices.SURRENDER) {
                            playerTurn = false;
                        } else if (playerChoice == Choices.DOUBLE) {
                            dealer.play(); // Dealer plays after doubling
                            playerTurn = false;
                        }
                    } else {
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // Clear the invalid input
                }
            }

            if (playerChoice != Choices.SURRENDER) {
                System.out.println("Dealer's turn...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Dealer's cards: " + dealer.getDealerCards());
                System.out.println("Dealer's cards value: " + dealer.getDealerHandValue());

                dealer.play(); // Dealer plays to complete their turn
            }

            showFinalResults(player, dealer); // Show final results
            continuePlaying = promptRetry(scanner); // Prompt to retry
        }

        scanner.close();
    }

    private static void showFinalResults(Player player, Dealer dealer) {
        System.out.println("Final Dealer's cards: " + dealer.getDealerCards());
        System.out.println("Final Dealer's cards value: " + dealer.getDealerHandValue());
        System.out.println("Final Your cards: " + player.getPlayerCards());
        System.out.println("Final Your card value: " + player.getHandValue());

        Results result = ResultsFunctions.determineResult(player, dealer);
        System.out.println("Game result: " + result);
    }

    private static boolean promptRetry(Scanner scanner) {
        System.out.println("Retry? (yes/no)");
        String response = scanner.next().trim().toLowerCase();
        return response.equals("yes");
    }

    private static Choices getChoiceFromInput(int input) {
        switch (input) {
            case 1:
                return Choices.HIT;
            case 2:
                return Choices.STAND;
            case 3:
                return Choices.DOUBLE;
            case 4:
                return Choices.SURRENDER;
            default:
                return null;
        }
    }
}
