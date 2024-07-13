package com.skilldistillery.blackjack;

import java.util.Scanner;

public class BlackjackApp {
	private Dealer dealer;
	private Player player;

	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		app.run();
	}

	private void run() {
		Scanner scan = new Scanner(System.in);
		int turn = 0;
		this.dealer = new Dealer();
		this.player = new Player();
		if (turn == 0) {
			player.drawBlackjackCard(dealer.dealCard());
			System.out.println(player.displayHand());
			dealer.drawBlackjackCard(dealer.dealCard());
			System.out.println("Dealer hand: [Hidden Card]");
			player.drawBlackjackCard(dealer.dealCard());
			if(player.getBlackjackHandValue() == 21) {
				System.out.println(player.displayHand());
				System.out.println("Blackjack!");
				System.exit(0);
			}
			System.out.println(player.displayHand());
			dealer.drawBlackjackCard(dealer.dealCard());
			System.out.println(dealer.displayHand());
			turn++;
		}
		System.out.println("1 - Hit  :  2 - Stay");
		int choice = scan.nextInt();
		while (choice == 1) {
			player.drawBlackjackCard(dealer.dealCard());
			System.out.println(player.displayHand());
			if (player.getBlackjackHandValue() == 21) {
				System.out.println("Blackjack!");
				choice = -1;
			} else if (player.getBlackjackHandValue() > 21) {
				System.out.println("Bust!");
				choice = 0;
			} else {
				System.out.println("1 - Hit  :  2 - Stay");
				choice = scan.nextInt();
			}
		}
		while (choice == 0 || choice == 2) {
			if (dealer.getBlackjackHandValue() >= 17) {
				System.out.println("Dealer stays");
				System.out.println(dealer.displayHiddenHand());
			}
			while (dealer.getBlackjackHandValue() <= 17) {
				dealer.drawBlackjackCard(dealer.dealCard());
				if (dealer.getBlackjackHandValue() >= player.getBlackjackHandValue() && dealer.getBlackjackHandValue() <= 21) {
					System.out.println("Dealer wins");
				} else if (dealer.getBlackjackHandValue() == 21) {
					System.out.println(dealer.displayHiddenHand());
					System.out.println("Dealer blackjack!");
					choice = -1;
				} else if (dealer.getBlackjackHandValue() > 21) {
					System.out.println(dealer.displayHiddenHand());
					System.out.println("Dealer bust");
					if (player.getBlackjackHandValue() <= 21) {
						System.out.println("You win!");
					} else if (player.getBlackjackHandValue() > 21) {
						System.out.println("No one wins");
					}
					choice = -1;
				}
			}
			
			scan.close();
		}
	}
}
