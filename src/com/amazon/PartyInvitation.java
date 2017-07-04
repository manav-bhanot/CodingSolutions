/**
 * 
 */
package com.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Manav
 *
 */
public class PartyInvitation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Process input in the below format		
		List<List<String>> partyInvitations = new ArrayList<List<String>>();
		
		String[] guestsList = new String[] {
			"Beth,Adam,4,2",
			"Cass,Adam,3,4",
			"Dole,Adam,2,3",
			"Evan,Beth,3,1",
			"Fury,Evan,2,2",
			"Greg,Dole,6,2",
			"Hugh,Cass,4,4",
			"Ivan,Cass,6,4",
			"Juan,Cass,3,1",
			"Kale,Ivan,1,6",
			"Leon,Ivan,2,5",
			"Mark,Ivan,1,6"
		};
		
		for (String s : guestsList) {
			
			List<String> invitation = new ArrayList<>();
			
			for (String str : s.split(",")) {
				invitation.add(str.trim());
			}
			
			partyInvitations.add(invitation);
		}
		
		for (String guestsNotInvited : processPartyInvitations(partyInvitations)) {
			System.out.print(guestsNotInvited + " ");
		}
	}
	
	private static List<String> processPartyInvitations(List<List<String>> partyInvitations) {
		
		// Create Disjoint Set data structure for the input data
		Map<Node, List<Node>> disjoinSets = new HashMap<Node, List<Node>>();
		
		for (List<String> record : partyInvitations) {
			
			String guestName = record.get(0);
			String inviterName = record.get(1);
			int candiesBrought = Integer.parseInt(record.get(2));
			int candiesConsumed = Integer.parseInt(record.get(3));
			
			Node inviter = new Node(inviterName);
			Node guest = new Node(guestName, candiesBrought, candiesConsumed);
			
			// Check if the inviter already exists in our disjoint set
			// If yes, then adds this guest to that inviter's list
			// else create a new entry in the disjointSets map
			if (!disjoinSets.containsKey(inviter)) {
				disjoinSets.put(inviter, new ArrayList<Node>());
			}
			disjoinSets.get(inviter).add(guest);
			
		}
		
		List<String> result = new ArrayList<String>();
		Node inviter = new Node("Adam");		
		List<Node> guestList = disjoinSets.get(inviter);
		
		findListOfPersonsToBeUnInvited(inviter, guestList, result, disjoinSets);
		
		return result;
		
	}

	private static void findListOfPersonsToBeUnInvited(Node inviter, List<Node> guestList, List<String> result, Map<Node, List<Node>> disjoinSets) {
		
		for (Node guest : guestList) {
			
			// Check if guest is again an inviter
			if (disjoinSets.containsKey(guest)) {
				
				// Recurse till we reach a guest who has not invited any further guest
				findListOfPersonsToBeUnInvited(guest, disjoinSets.get(guest), result, disjoinSets);
			}
			
			if (guest.leftover < 0) {
				result.add(guest.person);
			} else {
				inviter.leftover = inviter.leftover + guest.leftover;
			}
		}
		
		// Now check if the leftover candies can be increased after inviter invites some of his guests.
		if (inviter.leftover < 0) {
			result.add(inviter.person);
		}
	}
}

class Node {
	String person;
	int candiesConsumed;
	int candiesBrought;	
	int leftover;
	
	public Node(String person) {
		this.person = person;
	}

	public Node(String person, int candiesBrought, int candiesConsumed) {
		this.person = person;
		this.candiesConsumed = candiesConsumed;
		this.candiesBrought = candiesBrought;
		this.leftover = candiesBrought - candiesConsumed;
	}
	
	@Override
	public boolean equals(Object obj) {
		Node n = (Node) obj;
		return this.person.equals(n.person);
	}
	
	@Override
	public int hashCode() {
		return this.person.hashCode();
	}
}
