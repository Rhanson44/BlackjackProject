package com.skilldistillery.games.common;

import java.util.Objects;

public class Chip {
	private Value value;
	
	public Chip(Value value) {
		this.value = value;
	}
	
	public Value getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chip other = (Chip) obj;
		return value == other.value;
	}

	@Override
	public String toString() {
		return "Chip value: " + value;
	}
}
