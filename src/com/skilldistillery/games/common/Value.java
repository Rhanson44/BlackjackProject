package com.skilldistillery.games.common;

public enum Value {
	WHITE(1), RED(5), BLUE(10), GREEN(25), BLACK(100), PURPLE(500);
	
	private int value;
	
	private Value(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
