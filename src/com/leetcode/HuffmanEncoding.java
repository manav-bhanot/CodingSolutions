/**
 * 
 */
package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Manav
 * 
 *         Given a string, produce a Huffman encoding of the string.
 * 
 *         Exmaple : str = "go go gophers"
 *
 */
public class HuffmanEncoding {

	public static void main(String[] args) {

		String str = "go go gophers";

		Map<Character, Integer> freqMap = createFrequencyMap(str);
		TreeNode root = createHuffmanTree(freqMap);

		//Map<String, String> charEncoding = new HashMap<String, String>();
		
		String[] charCodes = new String[256];

		getHuffmanEncodedString(charCodes, root, "");

		for (char c : str.toCharArray()) {
			System.out.println(c + " : " + charCodes[c]);
		}
	}
	
	/**
	 * Traverse the tree and produce binary encodings for strings
	 * @param charCodes
	 * @param root
	 * @param code
	 */
	private static void getHuffmanEncodedString(String[] charCodes, TreeNode root, String code) {
		
		if (root == null) {
			return;
		}
		
		if (!root.isLeafNode()) {
			getHuffmanEncodedString(charCodes, root.left, "0" + code);
			getHuffmanEncodedString(charCodes, root.right, "1" + code);
		} else {
			char c = root.str.charAt(0);
			charCodes[c] = code;
		}
	}

	private static TreeNode createHuffmanTree(Map<Character, Integer> freqMap) {

		// Create a Max Heap
		PriorityQueue<TreeNode> pq = new PriorityQueue<TreeNode>();

		for (char c : freqMap.keySet()) {
			pq.add(new TreeNode(c + "", freqMap.get(c)));
		}

		// Iterate the max heap and create the huffman tree
		while (pq.size() > 1) {
			TreeNode left = pq.poll();
			TreeNode right = pq.poll();

			TreeNode parent = new TreeNode(left, right);
			parent.str = left.str + right.str;
			parent.freq = left.freq + right.freq;

			pq.add(parent);
		}
		return pq.remove();
	}

	private static Map<Character, Integer> createFrequencyMap(String str) {

		char[] cArr = str.toCharArray();
		Map<Character, Integer> freqMap = new HashMap<Character, Integer>();

		for (char c : cArr) {
			if (!freqMap.containsKey(c)) {
				freqMap.put(c, 0);
			}
			freqMap.put(c, freqMap.get(c) + 1);
		}
		return freqMap;
	}
}

class TreeNode implements Comparable<TreeNode> {
	String str;
	int freq;
	TreeNode left;
	TreeNode right;

	public TreeNode(String str, int freq) {
		super();
		this.str = str;
		this.freq = freq;
	}

	public TreeNode(TreeNode left, TreeNode right) {
		super();
		this.left = left;
		this.right = right;
	}
	
	public boolean isLeafNode() {
		return (this.left == null && this.right == null);
	}

	@Override
	public int compareTo(TreeNode o) {
		// Comparison to create a MinHeap
		return ((Integer) this.freq).compareTo(o.freq);
	}

}
