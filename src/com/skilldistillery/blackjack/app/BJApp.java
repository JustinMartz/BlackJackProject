package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BJApp {
	private Dealer dealer;
	private Player player;

	public static void main(String[] args) {
		BJApp myApp = new BJApp();
		myApp.run();
	}

	public void run() {
		dealer = new Dealer();
		player = new Player();
		initialDeal();
		playGame();
	}

	private void initialDeal() {
		boolean hideFirstCard = true;

		dealer.dealCard(player);
		dealer.dealCard(dealer);
		dealer.dealCard(player);
		dealer.dealCard(dealer);
		dealer.displayHand(hideFirstCard);
		player.displayHand();
	}

	private void playGame() {
		Scanner userInput = new Scanner(System.in);
		String choice = "";
		boolean continuePlaying = true;

		while (continuePlaying) {
			if (player.checkHand() == 1) {
				System.out.println("Blackjack! Player wins.");
				player.displayWinningHand();
				break;
			} else if (player.checkHand() == -1) {
				System.out.println("Bust! Dealer wins.");
				dealer.displayWinningHand();
				break;
			}

			System.out.print("Would you like to [H]it or [S]tand: ");
			choice = userInput.nextLine().toLowerCase();
			switch (choice) {
			case "h":
			case "hit":
				System.out.println("Hit");
				dealer.dealCard(player);
				player.displayHand();
				break;
			case "s":
			case "stand":
				System.out.println("Stand");
				System.out.println("Showing all dealer's cards...");
				dealer.displayHand();
				continuePlaying = dealerTurn();
				break;
			default:
				break;
			}

		}

		userInput.close();
	}

	private boolean dealerTurn() {
		int dealerHand = dealer.getHandValue();
		int playerHand = player.getHandValue();
		
		while (dealerHand < 17) {
			System.out.println("Dealer hit...");
			dealer.dealCard(dealer);
			dealer.displayHand();
			dealerHand = dealer.getHandValue();
		}
		
		if (dealerHand == 21) {
			System.out.println("Blackjack! Dealer wins!");
			dealer.displayWinningHand();
			return false;
		} else if (dealerHand > 21) {
			System.out.println("Dealer bust! Player wins!");
			player.displayWinningHand();
			return false;
		} else if (playerHand == dealerHand) {
			System.out.println("Push. Clearing hands and dealing again. ");
			dealer.clearHands(dealer);
			dealer.clearHands(player);
			System.out.println();
			initialDeal();
			return true;
		} else if (playerHand > dealerHand) {
			System.out.println("Player wins!");
			player.displayWinningHand();
			return false;
		} else if (playerHand < dealerHand) {
			System.out.println("Dealer wins!");
			dealer.displayWinningHand();
			return false;
		}

		return false;
	}

}
