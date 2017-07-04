package com.kubra;

public class Card {
	
	public String suit;
	public String val;
	
	public Card() {
	}
	
	public Card(String suit, String val) {
		super();
		this.suit = suit;
		this.val = val;
	}
	
	public Card(String suit) {
		this.suit = suit;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		Card search = (Card) obj;
		
		if (this.suit.equalsIgnoreCase(search.suit) && this.val.equalsIgnoreCase(search.val)) {
			return true;
		}
		
		return false;
	}
}
