/**
 * 
 */
package com.quantcast.honeycomb;

/**
 * @author Manav
 *
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

public class HoneyComb {

	private String honeyCombInputFile;
	public List<List<Node>> layers;

	// This Node's neighbors
	String N = "N";
	String NE = "NE";
	String NW = "NW";
	String S = "S";
	String SE = "SE";
	String SW = "SW";

	// Map data structure to directly jump to the first character
	// of the word to be searched in honeycomb
	private Map<String, Set<Node>> characterNodes;

	/**
	 * Default Constructor
	 */
	public HoneyComb() {
		this.layers = new ArrayList<List<Node>>();
		this.characterNodes = new HashMap<String, Set<Node>>();
	}

	/**
	 * 
	 * @param honeyCombInputFile
	 */
	public HoneyComb(String honeyCombInputFile) {
		this();
		this.honeyCombInputFile = honeyCombInputFile;
	}

	/**
	 * Creates list of layers. Each layer is a list of nodes
	 * representing the characters in that layer
	 */
	public void createLayersOfHoneycomb() {

		try (Scanner scan = new Scanner(new File(this.honeyCombInputFile))) {
			int totalLayers = Integer.parseInt(scan.nextLine().trim());

			int layer = 0;
			while (layer < totalLayers) {
				String temp = scan.nextLine();
				ArrayList<Node> tempList = new ArrayList<Node>();

				for (char ch : temp.toCharArray()) {
					tempList.add(new Node("" + ch));
				}

				this.layers.add(tempList);
				layer++;
			}
		} catch (FileNotFoundException e) {
			System.err.println("FILE NOT FOUND : FileName and Location = " + this.honeyCombInputFile);
		} finally {
		}
	}

	/**
	 * Makes the connections
	 * 1. Connects the current layer's nodes to the nodes in the outer layer
	 * 2. Connects the nodes in the current layer with each other
	 * 3. Nodes in the lower layer have been already connected in the previous loop
	 * which is inside this method
	 */
	public void connectLayers() {

		// Check if there is only one center node given in the honeycomb
		if (layers.size() == 1) {

			// If yes then just initialize the honeycomb with one node and return
			Node centerNode = layers.get(0).get(0);
			characterNodes.put(centerNode.value, new HashSet<Node>());
			characterNodes.get(centerNode.value).add(centerNode);

			return;
		}

		// Connect the center node in the first layer to its 6 surrounding nodes in the
		// second
		// layer in the clockwise direction (N -> NE -> SE -> S -> SW -> NW)
		// 1st layer => layer at index 0
		// 2nd layer => layer at index 1

		Node centerNode = layers.get(0).get(0);

		centerNode.addNeighbour(layers.get(1).get(0), N);
		centerNode.addNeighbour(layers.get(1).get(1), NE);
		centerNode.addNeighbour(layers.get(1).get(2), SE);
		centerNode.addNeighbour(layers.get(1).get(3), S);
		centerNode.addNeighbour(layers.get(1).get(4), SW);
		centerNode.addNeighbour(layers.get(1).get(5), NW);

		characterNodes.put(centerNode.value, new HashSet<Node>());
		characterNodes.get(centerNode.value).add(centerNode);

		// Iterate through the nodes of each individual layer
		// and connect them
		for (int layer = 1; layer < layers.size(); layer++) {

			// Keeps track of the edge of the current hexagon
			// that we are processing
			// 0 => N edge, 1 => NE, 2 => SE, 3 => S, 4 => SW, 5 => NW
			int edge = 0;

			// As the layers increase, the inner nodes in each side of the hexagon are
			// connected to only
			// two nodes on the next layer whereas the nodes at the vertices of hexagon are
			// connected
			// to three nodes in the next layer
			// Count keeps track of the number of inner nodes (i.e. nodes lying on the
			// edges) in each side of the hexagon
			int count = 0;

			// Tells me that I have processed this side of the hexagon
			// and the next node that is coming is the beginning of
			// the new side of the hexagon and hence is at the vertex
			// of this side and the next side. Thus connect it to only 2 other nodes
			// in the next layer.

			// TRUE because the first node of every upper layed hexagon is lying
			// at the vertex
			boolean isCurrNodeLyingAtVertex = true;

			// this determines when to set the count back to 0
			// Each layer increase the nodes on each edge of the hexagon by 1
			// Therefore each new layer adds 6 more nodes than in the previous layer
			// And these 6 nodes are added in each edge of the hexagon
			int totalNodesOnAnEdgeOfThisHexagon = (layers.get(layer).size()) / 6;

			// Iterate the nodes in each of the layers
			for (int nodeIdx = 0; nodeIdx < layers.get(layer).size(); nodeIdx++) {

				// Get the current node at index nodeIdx in the layer numbered as layer
				// and establish its connection with the neighbouring nodes
				Node currNode = layers.get(layer).get(nodeIdx);
				Node neighbourNode = null;

				// if we have covered a particular edge of the hexagon
				// we need to reset the count to mark the beginning of the new edge
				// A new edge begins from the node at the vertex of the curr edge
				// and the new edge

				if (count == totalNodesOnAnEdgeOfThisHexagon) {
					count = 0;
					isCurrNodeLyingAtVertex = true;
					edge++;
				}

				switch (edge) {

				case 0:

					// This if checks blocks the attempt to connect the last layer of honeycomb
					// next layer as there is no next layer available
					// So here we just need to create a Circular Linked List
					// of the nodes at the current layer
					if (layer + 1 != layers.size()) {

						if (isCurrNodeLyingAtVertex) {
							// Example : Connect node B in second layer with node Q in third layer
							// Handle the nodes lying at the vertex to connect it two three nodes in the
							// outer layer
							neighbourNode = layers.get(layer + 1).get(layers.get(layer + 1).size() - 1);
							/*
							 * System.out.println("Connecting Node " + currNode.value + " in layer " + layer
							 * + " with node : " + neighbourNode.value + " in layer " + (layer + 1));
							 */
							currNode.addNeighbour(neighbourNode, NW);
						}

						// Connects the two corresponding nodes in the next layer
						neighbourNode = layers.get(layer + 1).get(nodeIdx + edge);
						/*
						 * System.out.println("Connecting Node " + currNode.value + " in layer " + layer
						 * + " with node : " + neighbourNode.value + " in layer " + (layer + 1));
						 */
						currNode.addNeighbour(neighbourNode, N);

						neighbourNode = layers.get(layer + 1).get(nodeIdx + 1 + edge);
						/*
						 * System.out.println("Connecting Node " + currNode.value + " in layer " + layer
						 * + " with node : " + neighbourNode.value + " in layer " + (layer + 1));
						 */
						currNode.addNeighbour(neighbourNode, NE);
					}

					// This is to connect the current node with the next node in the same layer
					// Creating a Circular Linked List for each layer
					neighbourNode = layers.get(layer).get((nodeIdx + 1) % layers.get(layer).size());
					/*
					 * System.out.println("Connecting Node " + currNode.value + " in layer " + layer
					 * + " with node : " + neighbourNode.value + " in layer " + layer);
					 */
					currNode.addNeighbour(neighbourNode, SE);

					break;

				case 1:

					if (layer + 1 != layers.size()) {
						if (isCurrNodeLyingAtVertex) {
							neighbourNode = layers.get(layer + 1).get(nodeIdx - 1 + edge);
							/*
							 * System.out.println("Connecting Node " + currNode.value + " in layer " + layer
							 * + " with node : " + neighbourNode.value + " in layer " + (layer + 1));
							 */
							currNode.addNeighbour(neighbourNode, N);
						}

						neighbourNode = layers.get(layer + 1).get(nodeIdx + edge);
						/*
						 * System.out.println("Connecting Node " + currNode.value + " in layer " + layer
						 * + " with node : " + neighbourNode.value + " in layer " + (layer + 1));
						 */
						currNode.addNeighbour(neighbourNode, NE);

						neighbourNode = layers.get(layer + 1).get(nodeIdx + 1 + edge);
						/*
						 * System.out.println("Connecting Node " + currNode.value + " in layer " + layer
						 * + " with node : " + neighbourNode.value + " in layer " + (layer + 1));
						 */
						currNode.addNeighbour(neighbourNode, SE);
					}

					neighbourNode = layers.get(layer).get((nodeIdx + 1) % layers.get(layer).size());
					/*
					 * System.out.println("Connecting Node " + currNode.value + " in layer " + layer
					 * + " with node : " + neighbourNode.value + " in layer " + layer);
					 */
					currNode.addNeighbour(neighbourNode, S);

					break;

				case 2:

					if (layer + 1 != layers.size()) {
						if (isCurrNodeLyingAtVertex) {
							neighbourNode = layers.get(layer + 1).get(nodeIdx - 1 + edge);
							/*
							 * System.out.println("Connecting Node " + currNode.value + " in layer " + layer
							 * + " with node : " + neighbourNode.value + " in layer " + (layer + 1));
							 */
							currNode.addNeighbour(neighbourNode, NE);
						}

						neighbourNode = layers.get(layer + 1).get(nodeIdx + edge);
						/*
						 * System.out.println("Connecting Node " + currNode.value + " in layer " + layer
						 * + " with node : " + neighbourNode.value + " in layer " + (layer + 1));
						 */
						currNode.addNeighbour(neighbourNode, SE);

						neighbourNode = layers.get(layer + 1).get(nodeIdx + 1 + edge);
						/*
						 * System.out.println("Connecting Node " + currNode.value + " in layer " + layer
						 * + " with node : " + neighbourNode.value + " in layer " + (layer + 1));
						 */
						currNode.addNeighbour(neighbourNode, S);
					}

					neighbourNode = layers.get(layer).get((nodeIdx + 1) % layers.get(layer).size());
					/*
					 * System.out.println("Connecting Node " + currNode.value + " in layer " + layer
					 * + " with node : " + neighbourNode.value + " in layer " + layer);
					 */
					currNode.addNeighbour(neighbourNode, SW);

					break;

				case 3:

					if (layer + 1 != layers.size()) {
						if (isCurrNodeLyingAtVertex) {
							neighbourNode = layers.get(layer + 1).get(nodeIdx - 1 + edge);
							/*
							 * System.out.println("Connecting Node " + currNode.value + " in layer " + layer
							 * + " with node : " + neighbourNode.value + " in layer " + (layer + 1));
							 */
							currNode.addNeighbour(neighbourNode, SE);
						}

						neighbourNode = layers.get(layer + 1).get(nodeIdx + edge);
						/*
						 * System.out.println("Connecting Node " + currNode.value + " in layer " + layer
						 * + " with node : " + neighbourNode.value + " in layer " + (layer + 1));
						 */
						currNode.addNeighbour(neighbourNode, S);

						neighbourNode = layers.get(layer + 1).get(nodeIdx + 1 + edge);
						/*
						 * System.out.println("Connecting Node " + currNode.value + " in layer " + layer
						 * + " with node : " + neighbourNode.value + " in layer " + (layer + 1));
						 */
						currNode.addNeighbour(neighbourNode, SW);
					}

					neighbourNode = layers.get(layer).get((nodeIdx + 1) % layers.get(layer).size());
					/*
					 * System.out.println("Connecting Node " + currNode.value + " in layer " + layer
					 * + " with node : " + neighbourNode.value + " in layer " + layer);
					 */
					currNode.addNeighbour(neighbourNode, NW);

					break;

				case 4:

					if (layer + 1 != layers.size()) {
						if (isCurrNodeLyingAtVertex) {
							neighbourNode = layers.get(layer + 1).get(nodeIdx - 1 + edge);
							/*
							 * System.out.println("Connecting Node " + currNode.value + " in layer " + layer
							 * + " with node : " + neighbourNode.value + " in layer " + (layer + 1));
							 */
							currNode.addNeighbour(neighbourNode, S);
						}

						neighbourNode = layers.get(layer + 1).get(nodeIdx + edge);
						/*
						 * System.out.println("Connecting Node " + currNode.value + " in layer " + layer
						 * + " with node : " + neighbourNode.value + " in layer " + (layer + 1));
						 */
						currNode.addNeighbour(neighbourNode, SW);

						neighbourNode = layers.get(layer + 1).get(nodeIdx + 1 + edge);
						/*
						 * System.out.println("Connecting Node " + currNode.value + " in layer " + layer
						 * + " with node : " + neighbourNode.value + " in layer " + (layer + 1));
						 */
						currNode.addNeighbour(neighbourNode, NW);
					}
					neighbourNode = layers.get(layer).get((nodeIdx + 1) % layers.get(layer).size());
					/*
					 * System.out.println("Connecting Node " + currNode.value + " in layer " + layer
					 * + " with node : " + neighbourNode.value + " in layer " + layer);
					 */
					currNode.addNeighbour(neighbourNode, N);

					break;

				case 5:

					if (layer + 1 != layers.size()) {
						if (isCurrNodeLyingAtVertex) {
							neighbourNode = layers.get(layer + 1).get(nodeIdx - 1 + edge);
							/*
							 * System.out.println("Connecting Node " + currNode.value + " in layer " + layer
							 * + " with node : " + neighbourNode.value + " in layer " + (layer + 1));
							 */
							currNode.addNeighbour(neighbourNode, SW);
						}

						neighbourNode = layers.get(layer + 1).get(nodeIdx + edge);
						/*
						 * System.out.println("Connecting Node " + currNode.value + " in layer " + layer
						 * + " with node : " + neighbourNode.value + " in layer " + (layer + 1));
						 */
						currNode.addNeighbour(neighbourNode, NW);

						neighbourNode = layers.get(layer + 1).get(nodeIdx + 1 + edge);
						/*
						 * System.out.println("Connecting Node " + currNode.value + " in layer " + layer
						 * + " with node : " + neighbourNode.value + " in layer " + (layer + 1));
						 */
						currNode.addNeighbour(neighbourNode, N);
					}

					neighbourNode = layers.get(layer).get((nodeIdx + 1) % layers.get(layer).size());
					/*
					 * System.out.println("Connecting Node " + currNode.value + " in layer " + layer
					 * + " with node : " + neighbourNode.value + " in layer " + layer);
					 */
					currNode.addNeighbour(neighbourNode, NE);
					break;
				}
				count++;
				isCurrNodeLyingAtVertex = false;

				if (!characterNodes.containsKey(currNode.value)) {
					characterNodes.put(currNode.value, new HashSet<Node>());
				}
				characterNodes.get(currNode.value).add(currNode);
			}
		}
	}

	/**
	 * 
	 * @param word
	 * @param traversedNodes
	 * @param wordsFoundInHoneyComb
	 */
	public void findWord(String word, Set<Node> traversedNodes, Set<String> wordsFoundInHoneyComb) {

		// If this is a duplicate word. Just go back and get the next word from the
		// dictionary
		if (wordsFoundInHoneyComb.contains(word)) {
			return;
		}

		// Get all the nodes that begin with the first letter of this word from the
		// characterNodes hashmap
		// We need to find the starting node. Once its found then we need to follow
		// the connections path.
		Set<Node> setOfBeginnerNodes = this.characterNodes.get("" + word.charAt(0));
		if (setOfBeginnerNodes.isEmpty()) {
			return;
		}

		// Start iterating all those nodes and find if they connect to subsequent nodes
		// that correspond to the subsequent characters of the word
		for (Node beginnerNode : setOfBeginnerNodes) {

			// Add it to used nodes so that it do not create a circular word that
			// starts using the already used nodes and will give false output
			traversedNodes.add(beginnerNode);

			// Call the Util to see if this word is found by following the links from
			// the starting node
			if (findWordUtil(beginnerNode, word.substring(1), traversedNodes)) {
				wordsFoundInHoneyComb.add(word);
				return;
			}
		}
	}

	/**
	 * DFS Search
	 * 
	 * @param n
	 * @param word
	 * @param traversedNodes
	 * @return
	 */
	private boolean findWordUtil(Node n, String word, Set<Node> traversedNodes) {

		if (word.isEmpty()) {
			return true;
		}

		// Checking if we need to proceed next or return from here only
		// Improvises on the additional checking nodes
		if (!n.mapOfConnectedNodes.containsKey("" + word.charAt(0))) {
			return false;
		}

		for (Node nextNode : n.mapOfConnectedNodes.get("" + word.charAt(0))) {
			if (!traversedNodes.contains(nextNode)) {

				// Mark the current node as being traversed
				traversedNodes.add(nextNode);
				if (findWordUtil(nextNode, word.substring(1), traversedNodes)) {
					return true;
				}

				// Unmark it as being traversed since we are recurring back to some point where
				// we will begin our new search
				traversedNodes.remove(nextNode);
			}
		}

		return false;
	}

}
