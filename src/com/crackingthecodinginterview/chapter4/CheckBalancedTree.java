package com.crackingthecodinginterview.chapter4;

public class CheckBalancedTree {
	
	Node root;
	
	public void createBinaryTree() {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.left.left = new Node(8);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		//root.right.right = new Node(7);
		root.right.left.right = new Node(9);
		//root.right.left.right.left = new Node(10);
	}
	
	public boolean isBalanced(Node node) {
		
		if (node == null) {
			return true;
		}
		
		int lh = height(node.left);
		int rh = height(node.right);
		
		/*System.out.println(lh - rh);
		if (node.left != null) {
			System.out.println("Tree with root node : "+node.left.data+" is balanced :: "+isBalanced(node.left));
		}
		if (node.right != null) {
			System.out.println("Tree with root node : "+node.right.data+" is balanced :: "+isBalanced(node.right));
		}*/
		
		if (Math.abs(lh - rh) <=  1 && isBalanced(node.left) && isBalanced(node.right)) {
			return true;
		} else {
			return false;
		}
		
		
	}
	
	public int height(Node node) {
		
		if (node == null) {
			return 0;
		}
		
		return 1 + Math.max(height(node.left), height(node.right));		
	}
	
	public static void main(String[] args) {
		
		CheckBalancedTree tree = new CheckBalancedTree();
		
		tree.createBinaryTree();
		
		System.out.println(tree.isBalanced(tree.root));
		
		
				
	}

}
