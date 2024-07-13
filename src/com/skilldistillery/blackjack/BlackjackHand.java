package com.skilldistillery.blackjack;

import com.skilldistillery.common.cards.Hand;

public class BlackjackHand extends Hand{

	public BlackjackHand() {
	}
	
	public int getHandValue() {	
		int handValue = 0;
		for (int i = 0; i < super.cards.size(); i++) {
			handValue += super.cards.get(i).getValue();
		}
		return handValue;
	}
	
	public String getFirstCardValue() {
		return "" + super.cards.get(0);
	}
	
	public boolean isBlackjack() {
		boolean isBlackjack = false;
		if (getHandValue() == 21) {
			isBlackjack = true;
		} else {
			isBlackjack = false;
		}
		return isBlackjack;
	}
	
	public boolean isBust() {
		boolean isBust = false;
		if (getHandValue() > 21) {
			isBust = true;
		} else {
			isBust = false;
		}
		return isBust;
	}
}
