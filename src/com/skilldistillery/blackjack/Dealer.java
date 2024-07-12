package com.skilldistillery.blackjack;

import com.skilldistillery.common.cards.Card;
import com.skilldistillery.common.cards.Deck;

public class Dealer extends Player{
	private Deck deck;
	
	public Dealer() {
		deck = new Deck();
	}
	
	public Card dealCard() {
		return deck.dealCard();
	}
	
	@Override
	public void displayHand() {
		
	}
	
}
