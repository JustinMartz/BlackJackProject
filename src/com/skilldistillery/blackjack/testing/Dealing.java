package com.skilldistillery.blackjack.testing;

import java.util.Scanner;
import com.skilldistillery.blackjack.entities.*;


public class Dealing {

	public static void main(String[] args) {
		Dealing doug = new Dealing();
		doug.run();
	}
	
	private void run() {
		Scanner userInput = new Scanner(System.in);
		Deck myDeck = new Deck();
		Card dealtCard;
		myDeck.shuffle();
		int totalValueOfCards = 0;
		
		System.out.print("How many cards do you want dealt? ");
		int numberOfCards = userInput.nextInt();
		
		for (int i = 0; i < numberOfCards; i++) {
			dealtCard = myDeck.dealDeck();
			System.out.println(dealtCard);
			totalValueOfCards += dealtCard.getValue();
		}
		System.out.println("Total value of cards dealt: " + totalValueOfCards);
		userInput.close();
	}

}
