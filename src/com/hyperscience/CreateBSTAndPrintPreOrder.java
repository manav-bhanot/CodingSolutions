/**
 * 
 */
package com.hyperscience;

/**
 * @author Manav
 * 
 * Given a sorted array of integers.
 * Create a BST from the array
 * Print the preOrder traversal of the BST
 *
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int val) {
		this.val = val;
	}
}
public class CreateBSTAndPrintPreOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] arr = new int[] {-20, -11, -3, 2, 5, 18, 25, 28, 39, 43, 51};		
		TreeNode root = createBST(arr, 0, arr.length - 1);		
		preOrderTraversal(root);

	}

	private static void preOrderTraversal(TreeNode root) {
		
		if (root == null) {
			return;
		}
		
		System.out.print(root.val + " ");
		preOrderTraversal(root.left);
		// System.out.print(root.val + " ");
		preOrderTraversal(root.right);
	}

	private static TreeNode createBST(int[] arr, int i, int j) {
		
		if (i > j) {
			return null;
		}
		
		int mid = (i + j) / 2;
		
		TreeNode root = new TreeNode(arr[mid]);
		root.left = createBST(arr, i, mid - 1);
		root.right = createBST(arr, mid + 1, j);
		
		return root;
	}

}
