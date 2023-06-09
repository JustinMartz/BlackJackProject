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
//				System.out.println("Adding " + rank.getWrittenName() + " [value: " + rank.getValue() + "] of " + suit + " to deck.");
//				System.out.println(deckOfCards.size() + " cards in deck.");
			}
		}
	}
	
	public int checkDeckSize() {
		return deckOfCards.size();
	}
	
	public Card dealDeck() {
		return deckOfCards.remove(0);
	}
	
	public void shuffle() {
		Collections.shuffle(deckOfCards);
	}
}
