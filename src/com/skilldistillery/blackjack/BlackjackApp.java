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
		
		firstHand();
		
		playerTurn();
		
		dealerTurn();
		
		checkWins();
		
	}
	
	private void firstHand() {
		while(true) {
			player.drawBlackjackCard(dealer.dealCard());
			System.out.println(player.displayHand());
			
			dealer.drawBlackjackCard(dealer.dealCard());
			System.out.println("Dealer hand: [Hidden Card]");
			player.drawBlackjackCard(dealer.dealCard());
			
			if(player.isBlackjack()) {
				System.out.println(player.displayHand());
				System.out.println("Blackjack!");
				break;
			}
			System.out.println(player.displayHand());
			dealer.drawBlackjackCard(dealer.dealCard());
			System.out.println(dealer.displayHand());
			break;
		}
	}
	
	private void playerTurn() {
		boolean isTrue = true;
		
		System.out.println("1 - Hit  :  2 - Stay");
		int choice = scan.nextInt();
		
		while(isTrue) {
			if (choice == 2) {
				isTrue = false;
			} else if (choice == 1) {
				player.drawBlackjackCard(dealer.dealCard());
				System.out.println(player.displayHand());
				
				if (player.isBlackjack()) {
					System.out.println("Blackjack!");
					System.exit(0);
				} else if (player.isBust()) {
					System.out.println("Bust!");
					isTrue = false;
				} else {
					System.out.println("1 - Hit  :  2 - Stay");
					choice = scan.nextInt();
				}
			}
		}
	}
	
	private void dealerTurn() {
		
		System.out.println(dealer.displayHiddenHand());
		
		if (dealer.getBlackjackHandValue() >= 17) {
			System.out.println("Dealer stays");
		}
		
		while (dealer.getBlackjackHandValue() < 17) {
			dealer.drawBlackjackCard(dealer.dealCard());
			System.out.println(dealer.displayHiddenHand());
		}
	}
	
	private void checkWins() {
		
		if(player.getBlackjackHandValue() > dealer.getBlackjackHandValue() && !player.isBust()) {
			System.out.println("Player wins!");
		} else if (player.isBust() && dealer.isBust()) {
			System.out.println("No one wins");
		} else if (!dealer.isBust() && dealer.getBlackjackHandValue() > player.getBlackjackHandValue() || dealer.isBlackjack()) {
			System.out.println("Dealer wins");
		}
	}
}
