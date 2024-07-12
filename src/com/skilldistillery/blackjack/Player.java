package com.skilldistillery.blackjack;

import com.skilldistillery.common.cards.Card;

public class Player {
	
	private BlackjackHand hand;
	
	public Player() {
		this.hand = new BlackjackHand();
	}
	
	public void drawCard(Card card) {
		hand.drawCard(card);
	}
	
	public int getHandValue() {
		return hand.getHandValue();
	}
	
	public void displayHand() {
		System.out.println(hand.getHandValue());
	}

}
