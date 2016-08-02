package com.practice.search;


/*
 * Create a Binary Search Tree. A BST is a tree structure that the key of left node is 
 * Smaller than root and the key pf th eright node is large than the root.
 */
public class BinarySearchTree {

	public static void main(String[] args) {
		
	}
	
	
	
	
	public class TreeNode {
		
		private int key;
		private String value;
		private TreeNode left;
		private TreeNode right;
		private int nodeCount = 0;
		public int getKey() {
			return key;
		}
		public void setKey(int key) {
			this.key = key;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public TreeNode getLeft() {
			return left;
		}
		public void setLeft(TreeNode left) {
			this.left = left;
		}
		public TreeNode getRight() {
			return right;
		}
		public void setRight(TreeNode right) {
			this.right = right;
		}
		public int getNodeCount() {
			return nodeCount;
		}
		public void setNodeCount(int nodeCount) {
			this.nodeCount = nodeCount;
		}
		
		
		
		
	}
}
