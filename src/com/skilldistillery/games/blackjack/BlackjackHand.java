package com.skilldistillery.games.blackjack;

import com.skilldistillery.games.common.Card;
import com.skilldistillery.games.common.Hand;
import com.skilldistillery.games.common.Rank;
import com.skilldistillery.games.common.Suit;

public class BlackjackHand extends Hand {
	
	public BlackjackHand() {
		super();
	}

	public int getHandValue() {
		int handValue = 0;
		for (int i = 0; i < cards.size(); i++) {
			handValue += cards.get(i).getValue();
		}
		return handValue;
	}
	

	public String getFirstCardValue() {
		return "" + cards.get(0);
	}

	public boolean isAce() {
		boolean isAce = false;
		if (cards.toString().contains("ACE") || cards.toString().contains("ACE1")) {
			isAce = true;
		} else {
			isAce = false;
		}
		return isAce;
	}
	
	public Card drawAce(int value) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getValue() == 11) {
                Card newAce = new Card(Suit.HEARTS, getRankFromValue(value));
                cards.set(i, newAce);
                return newAce;
            }
        }
        return null;
    }
	
	public Card replaceAce(int index, int value) {
	    Card newAce = new Card(Suit.DIAMONDS, getRankFromValue(value));
	    cards.set(index, newAce);
	    return newAce;
	}
	
	public boolean hasSoftAce() {
	    for (Card card : cards) {
	        if (card.getValue() == 11 && getHandValue() < 21) {
	            return true;
	        }
	    }
	    return false;
	}

    private Rank getRankFromValue(int value) {
        return (value == 1) ? Rank.ACE1 : Rank.ACE;
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
