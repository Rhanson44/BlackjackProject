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
		
	public boolean isAce() {
		return hand.isAce();
	}
	
	public Card drawAce(int value) {
		return hand.drawAce(value);
	}
	
	public Card replaceAce(int index, int value) {
		return hand.replaceAce(index, value);
	}
	
	public boolean hasSoftAce() {
		return hand.hasSoftAce();
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
	
	public void clearHand() {
		hand.clear();
	}

}
