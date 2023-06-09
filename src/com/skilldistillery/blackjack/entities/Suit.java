package com.skilldistillery.blackjack.entities;

public enum Suit {
	HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");
	private String niceName;
	
	private Suit(String harshName) {
		niceName = harshName;
	}
	
	@Override
	public String toString() {
		return niceName;
	}
}
