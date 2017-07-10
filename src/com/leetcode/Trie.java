/**
 * 
 */
package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Manav
 *
 */
public class Trie {

	Map<Character, Trie> children;
	boolean endOfWord;

	// Will always store the root of the tree
	Trie root;

	/** Initialize your data structure here. */
	public Trie() {
		this.children = new HashMap<Character, Trie>();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {

		if (root == null) {
			root = new Trie();
		}

		Trie node = root;

		for (char c : word.toCharArray()) {

			if (node.children.containsKey(c)) {
				node = node.children.get(c);
			} else {
				// Create a new Trie Node
				Trie newNode = new Trie();

				// Add the character at this node
				node.children.put(c, newNode);
				node = newNode;
			}
		}

		node.endOfWord = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {

		if (root == null) {
			return false;
		}

		Trie node = root;

		for (char c : word.toCharArray()) {
			node = node.children.get(c);
			if (node == null) {
				return false;
			}
		}

		if (!node.endOfWord) {
			return false;
		}

		return true;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {

		if (root == null) {
			return false;
		}
		Trie node = root;

		for (char c : prefix.toCharArray()) {
			node = node.children.get(c);
			if (node == null) {
				return false;
			}
		}
		return true;
	}
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
