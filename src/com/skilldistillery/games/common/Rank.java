package com.skilldistillery.games.common;

public enum Rank {
	TWO(2), THREE(3), FOUR(4), 
	FIVE(5), SIX(6), SEVEN(7), 
	EIGHT(8), NINE(9), TEN(10), 
	JACK(10), QUEEN(10), KING(10), ACE(11), ACE1(1);
	
	private int value;
	
	private Rank(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
