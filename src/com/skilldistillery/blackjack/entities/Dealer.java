package com.skilldistillery.blackjack.entities;

public class Dealer extends Player {
	private Deck newDeck;

	public Dealer() {
		newDeck = new Deck();
		System.out.println("Getting new deck...");
		newDeck.shuffle();
		System.out.println("Shuffling deck...");
	}

	public void dealCard(Player player) {
		Card newCard = newDeck.dealCard();
		player.hand.addCard(newCard);
	}

	@Override
	public void displayHand() {
		System.out.println("Dealer's hand: " + hand + "\nTotal value of hand: " + hand.getHandValue());
	}

	public void displayHand(boolean hideFirstCard) {
		System.out.println("Dealer's hand: " + "[Face-down card, " + hand.getCardFromHand(1) + "]");
		System.out.println();
	}

	public int getDeckSize() {
		return newDeck.size();
	}

	public void clearHands(Player player) {
		player.hand.clear();
	}
}
