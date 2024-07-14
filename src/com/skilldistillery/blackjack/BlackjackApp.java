package com.skilldistillery.blackjack;

import java.util.Scanner;

public class BlackjackApp {
	private Dealer dealer;
	private Player player;
	private Scanner scan;

	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		app.run();
	}

	public BlackjackApp() {
		this.dealer = new Dealer();
		this.player = new Player();
		this.scan = new Scanner(System.in);
	}

	private void run() {

		while (!dealer.isDeckEmpty()) {
			System.out.println("========= New Game =========");
			System.out.println("Cards remaining: " + dealer.checkDeckSize());

			firstHand();

			playerTurn();
			
			if(!player.isBlackjack()) {
				dealerTurn();
				
				checkWins();
			}
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
			System.exit(0);
		}
		System.out.println("1 - Hit  :  2 - Stay");
		int choice = scan.nextInt();

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
				}
				if (player.isBust()) {
					System.out.println("Bust!");
					isTrue = false;
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
		} else if (dealer.isBust() && !player.isBust()) {
			System.out.println("Dealer Busts! Player wins.");
		} else {
			if (player.getBlackjackHandValue() > dealer.getBlackjackHandValue()) {
				System.out.println("Player wins with " + player.getBlackjackHandValue() + " points!");
			} else if (dealer.getBlackjackHandValue() > player.getBlackjackHandValue()) {
				System.out.println("Dealer wins with " + dealer.getBlackjackHandValue() + " points.");
			} else {
				System.out.println("No winner. Both have " + player.getBlackjackHandValue() + " points.");
			}
		}
	}

	private void checkAce() {
		if (player.isAce()) {
			System.out.println("Choose which Ace to replace (enter 0-based index):");
			int aceIndex = scan.nextInt();

			System.out.println("Choose a value 1 or 11 for your Ace:");
			int aceValue = scan.nextInt();

			player.replaceAce(aceIndex, aceValue);

			System.out.println("Player's updated hand: " + player.displayHand());
		}
	}
}
