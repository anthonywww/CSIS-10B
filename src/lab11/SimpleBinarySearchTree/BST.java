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
		return countAux(0, root);
	}
	
	private int countAux(int count, TreeNode subTree) {
		if (subTree == null) {
			return 0;
		}
		
		count += countAux(count, subTree.left) + countAux(count, subTree.right);
		
		return count+1;
	}
	
	public int height() {
		return heightAux(0, root);
	}
	
	// Must be post-order
	// FIXME: one higher than should be
	private int heightAux(int count, TreeNode subTree) {
		if (subTree == null) {
			return 0;
		}
		int left = countAux(count, subTree.left);
		int right = countAux(count, subTree.right);
		return Math.max(left, right) + 1;
	}
	
	public BST copy() {
		BST copy = new BST();
		copyAux(copy, root);
		return copy;
	}
	
	// Must be pre-order
	// FIXME: not copying properly
	public BST copyAux(BST copy, TreeNode subTree) {
		if (subTree == null) {
			return null;
		}
		
		TreeNode newNode = new TreeNode(new String(subTree.data));
		// using String copy constructor to duplicate a string
		copy.add(newNode.data);
		copy.add(subTree.left.data);
		copy.add(subTree.right.data);
		
		// Remove this
		copy = copyAux(copy, newNode);
		
		//return copy;
		return copy;
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
	}

}