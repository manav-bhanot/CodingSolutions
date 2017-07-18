/**
 * 
 */
package com.kubra;

import java.util.Scanner;

/**
 * @author Manav
 *
 */
public class PlayCards {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Deck d = new Deck();
		d.initializeDeckOfCards();

		System.out.println("------  Printing Deck Of Cards After Initialization -------------");
		d.printListOfCards();

		System.out.println("\n");

		System.out.println("\n\n------  Printing Deck Of Cards After Shuffling -------------");
		d.shuffle();
		d.printListOfCards();

		try (Scanner scan = new Scanner(System.in)) {

			System.out.println("\n\n ---------------------------------------------");
			System.out.println("Enter cut point : ");
			int cutPoint = scan.nextInt();

			d.cut(cutPoint);

			System.out.println("\n\n ---------------------------------------------");
			System.out.println("\n\n------  Printing Deck Of Cards After Cut Point -------------");
			d.printListOfCards();

			System.out.println("\n\n ---------------------------------------------");
			System.out.println("\n\n------  Deal -------------");
			d.deal();

			System.out.println("\n\n ---------------------------------------------");
			System.out.println("\n\n------  TurnOver -------------");
			d.turnOver();

			System.out.println("\n\n ---------------------------------------------");
			System.out.println("Enter suit");
			String suit = scan.next();

			System.out.println("Enter card textValue");
			String val = scan.next();
			System.out.println("Searched card is at position : " + (d.search(suit, val) + 1));
		} 

	}

}
