package com.skilldistillery.blackjack;

import com.skilldistillery.common.cards.Card;
import com.skilldistillery.common.cards.Deck;

public class Dealer extends Player{
	private Deck deck;
	
	public Dealer() {
		deck = new Deck();
		deck.shuffle();
	}
	
	public Card dealCard() {
		return deck.dealCard();
	}
	
	public boolean isDeckEmpty() {
		return deck.isDeckEmpty();
	}
	
	public int checkDeckSize() {
		return deck.checkDeckSize();
	}
	
	@Override
	public String displayHand() {
		return "Dealer hand: " + super.getFirstBlackjackCardValue() + " [HiddenCard]";
	}
	
	public String displayHiddenHand() {
		return "Dealer " + super.displayHand();
	}
	
}
