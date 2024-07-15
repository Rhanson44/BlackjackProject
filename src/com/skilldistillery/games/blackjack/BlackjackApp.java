package com.skilldistillery.games.blackjack;

import java.util.Scanner;

import com.skilldistillery.games.common.ChipHolder;

public class BlackjackApp {
    private Dealer dealer;
    private Player player;
    private ChipHolder chipHolder;
    private Scanner scan;
    private int betAmount;

    public static void main(String[] args) {
        BlackjackApp app = new BlackjackApp();
        app.run();
    }

    public BlackjackApp() {
        this.chipHolder = new ChipHolder();
        this.dealer = new Dealer();
        this.scan = new Scanner(System.in);
        this.player = new Player(chipHolder);
    }

    private void run() {
        System.out.println("Enter buy-in amount:");
        int chipAmount = scan.nextInt();
        scan.nextLine();
        
        player.getChips(chipAmount);
        
        while (!dealer.isDeckEmpty()) {
            System.out.println("========= New Game =========");
            System.out.println("Cards remaining: " + dealer.checkDeckSize());
            
            System.out.println(chipHolder);
            
            System.out.println("Place your bet:");
            betAmount = scan.nextInt();
            scan.nextLine();
            
            player.placeBet(betAmount);
            
            firstHand();
            
            if (!player.isBlackjack()) {
            	
            	playerTurn();
            	
                dealerTurn();
                
            }
            checkWins();
        }
        System.out.println("No cards remaining");
    }

    private void firstHand() {
        while (true) {
            player.clearHand();
            dealer.clearHand();
            player.drawBlackjackCard(dealer.dealCard());
            System.out.println(player.displayHand());

            dealer.drawBlackjackCard(dealer.dealCard());
            System.out.println("Dealer hand: [Hidden Card]");
            player.drawBlackjackCard(dealer.dealCard());

            if (player.isBlackjack()) {
                System.out.println(player.displayHand());
                System.out.println("Blackjack!");
                break;
            }
            
            System.out.println(player.displayHand());
            checkAce();
            dealer.drawBlackjackCard(dealer.dealCard());
            System.out.println(dealer.displayHand());
            break;
        }
    }

    private void playerTurn() {
        boolean isTrue = true;

        if (player.isBlackjack()) {
            System.out.println("Blackjack!");
            player.adjustChips(betAmount);
        }
        System.out.println("1 - Hit  :  2 - Stay");
        int choice = scan.nextInt();
        scan.nextLine();

        while (isTrue) {
            if (choice == 1) {

                player.drawBlackjackCard(dealer.dealCard());
                System.out.println(player.displayHand());
                
                if (player.isBlackjack()) {
                    System.out.println("Blackjack!");
                    break;
                }
                if (!player.isBlackjack() && !player.isBust()) {
                    System.out.println("1 - Hit  :  2 - Stay");
                    choice = scan.nextInt();
                    scan.nextLine();
                }
                if (player.isBust()) {
                    System.out.println("Bust!");
                    break;
                }
            } else if (choice == 2) {
                break;
            }
        }
    }

    private void dealerTurn() {
        System.out.println(dealer.displayHiddenHand());
        boolean softAce = dealer.hasSoftAce();

        while (dealer.getBlackjackHandValue() <= 17 || softAce) {
            dealer.drawBlackjackCard(dealer.dealCard());
            System.out.println(dealer.displayHiddenHand());
            softAce = dealer.hasSoftAce();
        }
        System.out.println("Dealer stays");
    }

    private void checkWins() {
        if (player.isBust() && !dealer.isBust()) {
            System.out.println("Player Busts! Dealer wins.");
            player.adjustChips(-betAmount);
        } else if (dealer.isBust() && !player.isBust() && player.getBlackjackHandValue() < 21) {
            System.out.println("Dealer Busts! Player wins.");
            player.adjustChips(betAmount);
        } else {
            if (!player.isBust() && player.getBlackjackHandValue() > dealer.getBlackjackHandValue()) {
                System.out.println("Player wins with " + player.getBlackjackHandValue() + " points!");
                player.adjustChips(betAmount);
                player.resetChips(player.getChipsValue());
            } else if (dealer.getBlackjackHandValue() > player.getBlackjackHandValue()) {
                System.out.println("Dealer wins with " + dealer.getBlackjackHandValue() + " points.");
                player.adjustChips(-betAmount);
            } else {
                System.out.println("No winner. Both have " + player.getBlackjackHandValue() + " points.");
            }
        }
    }

    private void checkAce() {
        if (player.isAce()) {
            System.out.println("Choose which Ace to replace (enter 0-based index):");
            int aceIndex = scan.nextInt();
            scan.nextLine();

            System.out.println("Choose a value 1 or 11 for your Ace:");
            int aceValue = scan.nextInt();
            scan.nextLine();

            player.replaceAce(aceIndex, aceValue);

            System.out.println("Player's updated hand: " + player.displayHand());
        }
    }
}
