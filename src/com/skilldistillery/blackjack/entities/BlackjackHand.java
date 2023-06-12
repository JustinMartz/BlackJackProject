package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand {

	@Override
	public int getHandValue() {
		int totalValueOfCards = 0;
		for (Card cardInHand : handOfCards) {
			totalValueOfCards += cardInHand.getValue();
		}

		return totalValueOfCards;
	}

	public boolean isBlackjack() {
		if (getHandValue() == 21) {
			return true;
		}

		return false;
	}

	public boolean isBust() {
		if (getHandValue() > 21) {
			return true;
		}
		
		return false;
	}

}
