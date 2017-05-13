/**
 * 
 */
package com.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Manav
 *
 */
public class AdamsParty {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node root = new Node("Adam", 0, 0);

		Scanner s = new Scanner(System.in);
		
		// Read the input and create the tree
		
		for (Node guest : root.guestsList) {
			//if (findLeftOverCandies(guest) : )
		}

	}
	
	public static int findLeftOverCandies(Node n) {
		
		for (Node guest : n.guestsList) {
			return n.leftoverCandies + findLeftOverCandies(guest);
		}
		
		return 0;		
	}
	
	public Node searchNode(String name, Node root) {
		
		if (root.name.equalsIgnoreCase(name)) {
			return root;
		}
		
		for (Node n : root.guestsList) {			
			searchNode(name, n);
		}
		
		return null;
	}

}

class Node {

	String name;
	int candiesBrought;
	int candiesConsumed;
	int leftoverCandies;
	List<Node> guestsList;

	Node(String n, int cb, int cc) {
		name = n;
		candiesBrought = cb;
		candiesConsumed = cc;
		leftoverCandies = cb - cc;
		guestsList = new ArrayList<Node>();
	}
}
