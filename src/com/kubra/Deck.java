/**
 * 
 */
package com.kubra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @author Manav
 *
 */
public class Deck {

	List<Card> cards;

	public Deck() {
		cards = new ArrayList<Card>();
	}	

	public void deal() {
		Card c = this.cards.remove(0);
		System.out.println("Card Removed :: " + c.suit + " " + c.val);		
	}

	public int search(String suit, String val) {
		
		Card c = new Card(suit, val);
		return this.cards.indexOf(c);
		
	}

	public void turnOver() {
		System.out.println("Turned Over Card is : " + this.cards.get(0));
	}

	public void cut(int cutPoint) {

		List<Card> sub = this.cards.subList(0, cutPoint);
		this.cards.addAll(sub);

		while (cutPoint != 0) {
			this.cards.remove(0);
			cutPoint--;
		}
	}

	public void shuffle() {
		Collections.shuffle(this.cards);
	}

	public void printListOfCards() {
		for (Card c : cards) {
			System.out.println(c.suit + " " + c.val);
		}
	}

	public void initializeDeckOfCards() {
		String[] suit = new String[] { "HEART", "CLUB", "DIAMOND", "SPADE" };

		for (int i = 0; i < suit.length; i++) {
			Card ace = new Card(suit[i], "ACE");
			cards.add(ace);

			for (int j = 2; j < 10; j++) {
				Card card = new Card(suit[i], "" + j);
				cards.add(card);
			}

			Card jack = new Card(suit[i], "JACK");
			cards.add(jack);

			Card queen = new Card(suit[i], "QUEEN");
			cards.add(queen);

			Card king = new Card(suit[i], "KING");
			cards.add(king);
		}
	}
}
