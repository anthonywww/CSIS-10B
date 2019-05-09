package lab11.ExpressionTrees;

//--------------------------------------------------------------------
//
//  Laboratory 11                                       ExprTree.java
//
//  (Shell) Class definitions for the linked implementation of the
//  Expression Tree ADT -- including the recursive partners of the
//  public methods
//
//  The student is to complete all missing or incomplete method 
//     implementations for this class
//
//--------------------------------------------------------------------
import java.util.StringTokenizer;

class ExprTree {
	
	// Data member
	// Reference to the root node
	private TreeNode root;

	// Constructor
	public ExprTree() {
		
	}

	// Expression tree manipulation operations
	// (recursive partners for these methods are declared further down in the file)
	// Build tree from prefix expression 
	public void build(StringTokenizer expression) {
		root = buildSub(expression);
	}
	
	// Output expression in infix form
	public void expression() {
		expressionSub(root);
	}
	
	private void expressionSub(TreeNode node) {
		if (node == null) {
			return;
		}
		if (node.left != null && node.right != null) {
			System.out.print("(");
		}
		expressionSub(node.left);
		System.out.print(node.element);
		expressionSub(node.right);
		if (node.left != null && node.right != null) {
			System.out.print(")");
		}
	}

	public double evaluate() {
		return evaluateSub(root);
	}
	
	private double evaluateSub(TreeNode node) {
		if (node == null) {
			return 0;
		}

		if (!Character.isDigit(node.element)) {
			double left = evaluateSub(node.left);
			double right = evaluateSub(node.right);
			
			switch(node.element) {
			case '+':
				return left + right;
			case '-':
				return left - right;
			case '*':
				return left * right;
			case '/':
				return left / right;
			}
		}
		
		return (double) Character.getNumericValue(node.element);
	}

	public void showStructure()
	// Outputs an expression tree. The tree is output rotated counter-
	// clockwise 90 degrees from its conventional orientation using a
	// "reverse" inorder traversal. This operation is intended for testing
	// and debugging purposes only.
	{
		if (root == null) {
			System.out.println("Empty tree");
		} else {
			System.out.println();
			showSub(root, 1);
			System.out.println();
		}
	}

	// Recursive partners of the public member methods ....
	// -- insert/complete the definition of these methods here.

	private void showSub(TreeNode p, int level)
	// Recursive partner of the showStructure() method. Outputs the
	// subtree whose root node is pointed to by p. Parameter level is the
	// level of this node within the expression tree.
	{
		int j; // Loop counter
		TreeNode right, left;

		if (p != null) {
			// For efficiency, calculate right and left only once
			right = p.right;
			left = p.left;

			showSub(right, level + 1); // Output right subtree
			for (j = 0; j < level; j++) // Tab over to level
				System.out.print("\t");
			System.out.print(" " + p.element);// Output element
			if ((left != null) && // Output "connector"
					(right != null))
				System.out.print("<");
			else if (right != null)
				System.out.print("/");
			else if (left != null)
				System.out.print("\\");
			System.out.println();
			showSub(left, level + 1); // Output left subtree
		}
	}

	// Recursive partner of the build() method.
	// Recursively builds a subtree and returns reference to its root
	private TreeNode buildSub(StringTokenizer expression) {
		TreeNode temp = null;
		if (expression.hasMoreTokens()) {
			char token = expression.nextToken().charAt(0);
			temp = new TreeNode(token, null, null);
			
			if (!Character.isDigit(token)) {
				temp.left = buildSub(expression);
				temp.right = buildSub(expression);
			}
		}
		// define TreeNode temp and set to null
		// if there is another token in the expression
		// assign to temp a new TreeNode with the next token in the expression as data
		// if the token in temp is not a digit (i.e. it's an operator)
		// invoke buildSub on the remaining expression and assign its result to the left
		// subtree of temp
		// invoke buildSub on the remaining expression and assign its result to the
		// right subtree of temp
		// otherwise (it's a digit) don't do anything, a digit is a leaf node, no
		// further recursive calls to buildSub needed.
		return temp;
	}

	// -- Insert the definition of the rest of
	// -- the recursive partners of the public methods below.
	// -- These recursive (helper) methods will be private.

	// ***************************************************************************************
	// TreeNode class for representing a single Expression Tree Node

	// Facilitator class for the ExprTree and LogiTree class
	private class TreeNode {
		
		public Character element;
		public TreeNode left, right;
		
		@SuppressWarnings("unused")
		public TreeNode() {
			this(null, null, null);
		}

		public TreeNode(Character elem, TreeNode leftPtr, TreeNode rightPtr) {
			this.element = elem;
			this.left = leftPtr;
			this.right = rightPtr;
		}
	}

}