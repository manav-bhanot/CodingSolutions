/**
 * 
 */
package com.quantcast.honeycomb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Manav
 *
 */
public class Node {
	
	// To store the charcter of the current node of the honeycomb
	public String value;
	
	// To store the neighboring nodes of this node
	public Node N, NE, NW, S, SE, SW;	
	
	// To store all the neighbors
	// Used to make DFS search efficient
	public Map<String, List<Node>> mapOfConnectedNodes;

	/**
	 * 
	 * @param value
	 */

	public Node() {
		this.mapOfConnectedNodes = new HashMap<String, List<Node>>();
	}

	public Node(String value) {
		this();
		this.value = value;
	}
	
	private void addAConnection(Node n) {
		
		if (!this.mapOfConnectedNodes.containsKey(n.value)) {
			this.mapOfConnectedNodes.put(n.value, new ArrayList<Node>());
		}
		this.mapOfConnectedNodes.get(n.value).add(n);
	}
	
	public void addNeighbour(Node neighbour, String direction) {

		switch (direction) {

		case "N":
			this.N = neighbour;
			neighbour.S = this;
			break;

		case "NE":
			this.NE = neighbour;
			neighbour.SW = this;
			break;

		case "SE":
			this.SE = neighbour;
			neighbour.NW = this;
			break;

		case "S":
			this.S = neighbour;
			neighbour.N = this;
			break;

		case "SW":
			this.SW = neighbour;
			neighbour.NE = this;
			break;

		case "NW":
			this.NW = neighbour;
			neighbour.SE = this;
			break;
		}

		// This is basically done so as to use DFS while searching for dictionary words
		// in the honeycomb
		// Note that this has to be running for every node.
		this.addAConnection(neighbour);
		neighbour.addAConnection(this);
	}
}
