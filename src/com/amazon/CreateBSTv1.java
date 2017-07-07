/**
 * 
 */
package com.amazon;

import java.util.Random;

/**
 * @author Manav
 * 
 * A BST is defined as a binary tree in which each node satisfies the property such that its textValue
 * is larger than the textValue of every node in its left subtree and less than or equal to the textValue
 * of every node in its right subtree. The distance between the two values in a binary search tree
 * is the minimum number of edges traversed to reach from one textValue to the other.
 * 
 * You are given a list of unique n numbers. Construct a BST by inserting each integer in the given order
 * without rebalancing the tree. Then, find the distance between the two given nodes of the BST representing
 * val1 and val2. In case, either val1 and val2 is not present in the tree, return -1.
 *
 * The input to the function consists of four arguments - 
 * 	values -> representing a list of integers
 * 	n -> an integer representing the number of elements.
 * 	node1 -> an integer representing the first node
 * 	node2 -> an integer representing the second node.
 * 
 * Output the result which is an integer representing the distance between val1 and val2, else return -1,
 * if either node1 or node2 is not present in the tree.
 * 
 * Constraints :
 * 	0 < n < 231
 * 	0 <= values[i] <= 231
 * 	0 <= i < n
 * 
 * Input :
 * 	values = [5,6,3,1,2,4], n = 6, val1 = 2, val2 = 4
 * 
 * Output:
 * 	3
 */
public class CreateBSTv1 {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Random randomInteger = new Random();
		
		int n = randomInteger.nextInt(230);
		
		int[] arr = new int[n];
		
		for (int i=0; i < n; i++) {
			arr[i] = randomInteger.nextInt(230);
		}
		
		int val1 = randomInteger.nextInt(230);
		int val2 = randomInteger.nextInt(230);
		
		arr = new int[] {5,6,3,1,2,4};
		val1 = -1;
		val2 = 3;
		
		TreeNode root = createBST(arr);
		
		// Print In Order Traversal
		printInOrderTraversal(root);
		System.out.println();
		
		System.out.println("distance = " + findDistance(root, val1, val2));
	}

	private static int findDistance(TreeNode root, int val1, int val2) {
		
		if (root == null || val1 == val2) {
			return 0;
		} else {
			
			if ((val1 < root.val && val2 >= root.val) || (val2 < root.val && val1 >= root.val)) {
				int distVal1 = distance(root, val1);
				System.out.println("distVal1 = " + distVal1);
				if (distVal1 < 0) {
					return -1;
				}
				
				int distVal2 = distance(root, val2);
				System.out.println("distVal2 = " + distVal2);
				if (distVal2 < 0) {
					return -1;
				}
				
				return distVal1 + distVal2;
				
			} else if (val1 < root.val && val2 < root.val) {
				return findDistance(root.left, val1, val2);
			} else {
				return findDistance(root.right, val1, val2);
			}
		}
		
	}

	private static int distance(TreeNode root, int val) {
		
		if (root == null) {
			return -1;
		}
		
		if (root.val == val) {
			return 0;
		}
		
		int d = 1;
		
		if (val < root.val) {
			// Go left
			int dist = distance(root.left, val);
			
			if (dist == -1) {
				d = dist;
			} else {
				d = d + dist;
			}
					
			
		} else if (val > root.val) {
			// Go right
			int dist = distance(root.right, val);
			
			if (dist == -1) {
				d = dist;
			} else {
				d = d + dist;
			}
		}
		
		return d;
	}

	private static void printInOrderTraversal(TreeNode root) {
		
		if (root == null) {
			return;
		}
		
		printInOrderTraversal(root.left);		
		System.out.print(root.val + " ");		
		printInOrderTraversal(root.right);		
	}

	private static TreeNode createBST(int[] arr) {
		
		TreeNode root = new TreeNode(arr[0]);
		
		for (int i = 1; i < arr.length; i++) {
			
			TreeNode node = root;
			TreeNode prevNode = node;
			
			while(node != null) {
				prevNode = node;
				node = arr[i] < node.val ? node.left : node.right;
			}
			
			if (arr[i] < prevNode.val) {
				prevNode.left = new TreeNode(arr[i]);
			} else {
				prevNode.right = new TreeNode(arr[i]);
			}
		}		
		return root;		
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int val) {
		this.val = val;
	}
}
