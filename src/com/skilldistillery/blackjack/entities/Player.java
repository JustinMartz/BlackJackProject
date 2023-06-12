package com.skilldistillery.blackjack.entities;

public class Player {
	protected Hand hand;

	public Player() {
		hand = new BlackjackHand();
	}

	public Hand getHand() {
		return hand;
	}

	public int getHandValue() {
		return hand.getHandValue();
	}

	public String getCardFromHand(int position) {
		return hand.getCardFromHand(position);
	}

	public int checkHand() {
		if (hand.isBust())
			return -1;
		else if (hand.isBlackjack())
			return 1;
		else
			return 0;
	}

	public void displayHand() {
		System.out.println("Player's hand: " + hand + "\nTotal value of hand: " + hand.getHandValue());
		System.out.println();
	}
	
	public void displayWinningHand() {
		System.out.println("Winning hand is " + this.getClass().getSimpleName() + "'s: " + hand + " [Hand value: "  + hand.getHandValue() + "]");
	}

}
