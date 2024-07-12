package com.skilldistillery.common.cards;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> cards;
	
	public Hand() {
		cards = new ArrayList<>();
	}
	
	public void drawCard(Card card) {
		Deck deck = new Deck();
		deck.createDeck();
		deck.dealCard();
	}
	
	public void clear() {
		cards.clear();
	}
	
	public abstract int getHandValue();

	@Override
	public String toString() {
		return "Hand: " + cards;
	}
	
	
}
