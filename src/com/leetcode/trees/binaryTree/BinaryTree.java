/**
 * 
 */
package com.leetcode.trees.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Manav
 *
 */
public class BinaryTree<E> {
	
	TreeNode<E> root;

	/**
	 * 
	 */
	public BinaryTree() {
		super();
	}

	/**
	 * 
	 * @param data
	 */
	public BinaryTree(E data) {
		root = new TreeNode<E>(data);
	}
	
	public TreeNode<E> createBinaryTree(E[] arr) {
		
		if (arr == null || arr.length == 0) {
			return null;
		}
		
		Queue<TreeNode<E>> queue = new LinkedList<TreeNode<E>>();
		TreeNode<E> root = new TreeNode<E>(arr[0]);
		queue.add(root);
		
		int i = 1;
		while (i < arr.length) {
			TreeNode<E> node = queue.remove();
			
			if (node != null) {
				node.left = new TreeNode<E>(arr[i]);			
				node.right = new TreeNode<E>(arr[i+1]);
			}			
			
			queue.add(node.left);
			queue.add(node.right);
			
			i += 2;
		}
		
		return root;				
	}
}
