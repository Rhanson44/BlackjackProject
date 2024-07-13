package com.skilldistillery.blackjack;

import com.skilldistillery.common.cards.Card;
import com.skilldistillery.common.cards.Deck;

public class Dealer extends Player{
	private Deck deck;
	
	public Dealer() {
		deck = new Deck();
		deck.createDeck();
		deck.shuffle();
	}
	
	public Card dealCard() {
		return deck.dealCard();
	}
	
	@Override
	public String displayHand() {
		return "Dealer hand: " + super.getFirstBlackjackCardValue() + " [HiddenCard]";
	}
	
	public String displayHiddenHand() {
		return "Dealer " + super.displayHand();
	}
	
}
