package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deckOfCards = new ArrayList<>();

	public Deck() {
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				Card newCard = new Card(suit, rank);
				deckOfCards.add(newCard);
			}
		}
	}

	public int cardsLeftInDeck() {
		return size();
	}

	public void dealCard(Hand hand) {
		Card cardToAdd = deckOfCards.remove(0);
		hand.addCard(cardToAdd);
	}

	public Card dealCard() {
		Card cardToAdd = deckOfCards.remove(0);
		return cardToAdd;
	}

	public Card dealDeck() {
		return deckOfCards.remove(0);
	}

	public void shuffle() {
		Collections.shuffle(deckOfCards);
	}

	public int size() {
		return deckOfCards.size();
	}

}
