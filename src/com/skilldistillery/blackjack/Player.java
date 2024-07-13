package com.skilldistillery.blackjack;

import com.skilldistillery.common.cards.Card;

public class Player {
	
	private BlackjackHand hand;
	
	public Player() {
		this.hand = new BlackjackHand();
	}
	
	public boolean isBlackjack() {
		return hand.isBlackjack();
	}
	
	public boolean isBust() {
		return hand.isBust();
	}
	
	public void drawBlackjackCard(Card card) {
		hand.drawCard(card);
	}
	
	public int getBlackjackHandValue() {
		return hand.getHandValue();
	}
	
	public String getFirstBlackjackCardValue() {
		return hand.getFirstCardValue();
	}
	
	public String displayHand() {
		return "Hand: " + hand.toString() + " " + hand.getHandValue();
	}

}
