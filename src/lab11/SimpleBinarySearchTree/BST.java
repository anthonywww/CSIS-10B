package lab11.SimpleBinarySearchTree;

import java.util.Iterator;
import java.util.Vector;

/**
 * Write a description of class BST here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class BST {

	private TreeNode root;

	BST() {
		root = null;
		
		// Demo tree
		/*
		root = new TreeNode("Turnips");
		root.left = new TreeNode("Strawberries");
		root.right = new TreeNode("Apples");
		root.left.right = new TreeNode("Chard");
		*/
	}

	@Override
	public String toString() {
		if (root != null)
			return root.toString();
		else
			return "";
	}

	public void add(String element) {
		TreeNode current = root, parent = root;
		if (root == null) {
			root = new TreeNode(element);
		} else {
			
			while (current != null) {
				// Locate the parent node
				if (element.compareTo(current.data) < 0) {
					current = current.left;
				} else if (element.compareTo(current.data) > 0) {
					current = current.right;
				} else {
					throw new IllegalArgumentException("Already exists in tree");
				}
				
				if (current != null) {
					parent = current;
				}
			}
			
			// Create the new node and attach it to the parent node
			if (element.compareTo(parent.data) < 0) {
				parent.left = new TreeNode(element);
			} else if (element.compareTo(parent.data) > 0) {
				parent.right = new TreeNode(element);
			} else {
				throw new IllegalArgumentException("Already exists in tree");
			}
			
		}
	}

	public boolean contains(String element) {
		if (root == null) {
			return false;
		} else {
			// traverse through tree looking for element
			TreeNode current = root;
			while (current != null) {
				// Locate the parent node
				if (element.compareTo(current.data) < 0) {
					current = current.left;
				} else if (element.compareTo(current.data) > 0) {
					current = current.right;
				} else {
					return true;
				}
			}
		}
		return false;
	}

	public String get(String element) {
		if (root == null) {
			return null; // tree empty
		} else {
			// traverse through tree looking for element
			TreeNode current = root;
			while (current != null) {
				// Locate the parent node
				if (element.compareTo(current.data) < 0) {
					current = current.left;
				} else if (element.compareTo(current.data) > 0) {
					current = current.right;
				} else {
					return current.data;
				}
			}
		}
		return null;
	}

	public void inOrder() {
		inOrderAux(root);
		System.out.println();
	}
	
	private void inOrderAux(TreeNode subTree) { // left, node, right
		if (subTree == null) {
			return;
		}
		preOrderAux(subTree.left);
		System.out.print(subTree.data + " ");
		preOrderAux(subTree.right);
	}
	
	public void preOrder() {
		preOrderAux(root);
		System.out.println();
	}
	
	private void preOrderAux(TreeNode subTree) { // node, left, right
		if (subTree == null) {
			return;
		}
		System.out.print(subTree.data + " ");
		preOrderAux(subTree.left);
		preOrderAux(subTree.right);
	}
	
	public void postOrder() {
		postOrderAux(root);
		System.out.println();
	}
	
	private void postOrderAux(TreeNode subTree) { // left, right, node
		if (subTree == null) {
			return;
		}
		preOrderAux(subTree.left);
		preOrderAux(subTree.right);
		System.out.print(subTree.data + " ");
	}
	
	
	public int count() {
		return countAux(root);
	}
	
	private int countAux(TreeNode subTree) {
		if (subTree == null) {
			return 0;
		}
		
		return 1 + countAux(subTree.left) + countAux(subTree.right);
	}
	
	public int height() {
		return heightAux(root);
	}
	
	// Must be post-order
	private int heightAux(TreeNode subTree) {
		if (subTree == null) {
			return 0;
		}
		int left = heightAux(subTree.left);
		int right = heightAux(subTree.right);
		return Math.max(left, right) + 1;
	}
	
	public BST copy() {
		BST newBST = new BST();
		copyAux(newBST, root);
		return newBST;
	}
	
	// Must be pre-order
	public BST copyAux(BST newBST, TreeNode subTree) {
		if (subTree == null) {
			return newBST;
		}
		newBST.add(new String(subTree.data));
		copyAux(newBST, subTree.left);
		copyAux(newBST, subTree.right);
		
		return newBST;
	}
	
	public Iterator<String> iterator() {
		Vector<String> vs = new Vector<String>();
		iterAux(vs, root);
		return vs.iterator();
	}

	private void iterAux(Vector<String> v, TreeNode subTree) {
		if (subTree != null) {
			iterAux(v, subTree.left);
			v.add(subTree.data);
			iterAux(v, subTree.right);
		}
	}

	public void graph() {
		this.graphAux(0, root);
	}

	private void graphAux(int indent, TreeNode subTree) {
		if (subTree != null) {
			graphAux(indent + 8, subTree.right);
			
			for (int k = 0; k < indent; k++) {
				System.out.print(" ");
			}
			
			System.out.println(subTree.data);
			graphAux(indent + 8, subTree.left);
		}
	}

	public void trimLeaves() {
		trimLeavesAux(root);
	}
	
	private void trimLeavesAux(TreeNode node) {
		if (node == null) {
			return;
		}
		if (!node.isLeaf()) {
			if (node.left != null && node.left.isLeaf()) {
				node.left = null;
			}
			if (node.right != null && node.right.isLeaf()) {
				node.right = null;
			}
			trimLeavesAux(node.left);
			trimLeavesAux(node.right);
		}
	}
	
	private class TreeNode {
		public String data;
		public TreeNode left, right;

		TreeNode(String data) {
			this.data = data;
			left = null;
			right = null;
		}

		@Override
		public String toString() {
			// in-order recursive traversal
			String result = "";
			
			if (left != null) {
				result += left.toString();
			}
			
			result += " " + data + " ";
			
			if (right != null) {
				result += right.toString();
			}
			
			return result;
		}
		
		public boolean isLeaf() {
			return left == null && right == null;
		}
	}

}
