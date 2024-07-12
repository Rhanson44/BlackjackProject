package com.skilldistillery.blackjack;

public class BlackjackApp {
	private Dealer dealer;
	private Player player;

	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		app.run();
	}

	private void run() {
		dealer = new Dealer();
		player = new Player();
	}

}
