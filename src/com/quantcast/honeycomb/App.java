/**
 * 
 */
package com.quantcast.honeycomb;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Manav
 *
 */
public class App {

	// Honeycomb reference variable to store the initial honeycomb given
	HoneyComb honeyComb;
	
	// Stores the absolute path to dictionary file
	private String dictionaryFile;
	
	// Stores the words from dictionary that are to be searched in honeycomb
	private List<String> wordsToSearchInHoneyComb;
	
	// Stores the words that are found in the honeycomb
	private Set<String> wordsFoundInHoneyComb;
	
	/**
	 * Default Constructor to initialize the data structures
	 */
	public App() {
		this.wordsFoundInHoneyComb=new HashSet<String>();
		this.wordsToSearchInHoneyComb=new ArrayList<String>();
	}	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		App app = new App();
		
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("HONEYCOMB WORD SEARCH APP");
			
			// Initialize the honeycomb
			// Uses linked network of nodes to initialize honeycomb	
			app.honeyComb = new HoneyComb(args[0]);
			app.dictionaryFile = args[1];
		} finally {}
		
		// Create a nested list of layers of the honeycomb
		app.honeyComb.createLayersOfHoneycomb();
		
		// Connect the node in each layer with its neighbouring nodes in the same layer and the nodes in the next layer.
		app.honeyComb.connectLayers();
		
		// Add the words from the dictionary into a List 
		app.createListOfWordsToSearch();
		
		// Process the words in the dictionary
		// Basically attempts to find each word one by one from the dictionary
		app.processDictionary();
		
		// Prints all the words from the dictionary that we found in the HoneyComb
		app.printResults();
	}

	public void processDictionary() {
		for (String word : this.wordsToSearchInHoneyComb) {
			Set<Node> traversedNodes = new HashSet<Node>();
			System.out.print("..");
			this.honeyComb.findWord(word.trim(), traversedNodes, this.wordsFoundInHoneyComb);
		}
		
		System.out.println("\nDictionary Processed. Printing the found words below \n");
	}

	public void createListOfWordsToSearch() {
		try (Scanner scan = new Scanner(new File(this.dictionaryFile))) {
			while (scan.hasNext()) {
				this.wordsToSearchInHoneyComb.add(scan.next().toUpperCase());
			}
		} catch (FileNotFoundException e) {
			System.err.println("FILE NOT FOUND : FileName and Location = " + this.dictionaryFile);
		} finally {
		}
	}

	public void printResults() {
		List<String> wordsFound = new ArrayList<String>(this.wordsFoundInHoneyComb);
		Collections.sort(wordsFound);
		for (String s : wordsFound) {
			System.out.println(s);
		}
		this.wordsFoundInHoneyComb.clear();
	}

}
