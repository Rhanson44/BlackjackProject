package com.skilldistillery.games.blackjack;

import com.skilldistillery.games.common.Card;
import com.skilldistillery.games.common.Deck;

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
