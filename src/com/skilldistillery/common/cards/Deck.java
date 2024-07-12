package com.skilldistillery.common.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck;

	public Deck() {
		createDeck();
	}

	public void createDeck() {
		deck = new ArrayList<>();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deck.add(new Card(suit, rank));
			}
		}
	}

	public int checkDeckSize() {
		return deck.size();
	}
	
	public boolean isEmpty() {
		if (deck.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public Card dealCard() {
		return deck.remove(0);
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

	@Override
	public String toString() {
		return "Deck: " + deck;
	}
}
