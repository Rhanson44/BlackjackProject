package com.skilldistillery.games.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck;

	public Deck() {
		deck = new ArrayList<>();
		createDeck();
	}

	public void createDeck() {
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deck.add(new Card(suit, rank));
			}
		}
	}

	public int checkDeckSize() {
		return deck.size();
	}
	
	public boolean isDeckEmpty() {
		if (deck.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public Card dealCard() {
		Card c = new Card(Suit.CLUBS, Rank.FIVE);
		if (!deck.isEmpty()) {
			return deck.remove(0);
		} else {
			System.out.println("Deck empty");
			return c;
		}
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}

	@Override
	public String toString() {
		return "Deck: " + deck;
	}
}
