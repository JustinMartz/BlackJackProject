package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> handOfCards = new ArrayList<>();

	public abstract int getHandValue();

	public abstract boolean isBust();

	public abstract boolean isBlackjack();

	public void addCard(Card card) {
		handOfCards.add(card);
	}

	public void clear() {
		handOfCards.clear();
	}

	public String toString() {
		return "" + handOfCards;
	}

	public int sizeOfHand() {
		return handOfCards.size();
	}

	public String getCardFromHand(int position) {
		return "" + handOfCards.get(position);
	}

}
