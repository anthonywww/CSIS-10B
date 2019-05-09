package lab11.SimpleBinarySearchTree;

import java.util.Iterator;

/**
 * Write a description of class BSTmainApp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BSTmainApp {
	
	public static void main(String[] args) {

		BST names = new BST();
//
//		names.add("George");
//		names.add("Barbara");
//
//		names.graph();
//		
//		System.out.println(names); // in order traversal
//        
//
//         // add more nodes
//         names.add("Jack");
//         names.add("Harry");
//         
//         // viewing a tree structure (as if tipped over sideways)
//         names.graph();
//         
         // Iterative methods: add, contains, get
         names = new BST();
         names.add("George");
         names.add("Barbara");
         names.add("Jack");
         names.add("Harry");
         names.add("Josephine");
         names.add("Robert");
         names.add("Sarah");
         names.graph();
         System.out.println(names.contains("Sarah"));
         System.out.println(names.get("Sarah"));
 
         // Traversal methods: preorder inorder and postorder traversal
         names.preOrder();
         
         // use of iterator method to retrieve an iterator on BST data
         Iterator<String> it = names.iterator();
         while (it.hasNext()) {
             System.out.println( it.next() + ",");
         }
        
         // Problem 1)    Complete the three traversal methods inOrder, preOrder and postOrder (see handout)
         System.out.print("inOrder: " );
         names.inOrder();
         
         System.out.print("preOrder: " );
         names.preOrder();
         
         System.out.print("postOrder: " );
         names.postOrder();        
         
         System.out.println();
         
         // Problem 2) Complete the count method (see handout)
         System.out.println("count: " + names.count() + ", should be 7" );
         
         // Problem 3) Complete the height method (see handout)
         BST bst = new BST();
         System.out.println("Height of bst = " + bst.height() + "(should be 0) and here it is ");
         bst.graph();        
         
         bst.add("f"); bst.add("d"); 
         System.out.println("Height of bst = " + bst.height() + "(should be 2) and here it is ");
         bst.graph();           
         
         bst.add("e"); bst.add("a");        
         System.out.println("Height of bst = " + bst.height() + "(should be 3) and here it is ");
         bst.graph();

         // Problem 4) Complete the copy method (see handout)
         BST names2 = names.copy();  // names2 gets a duplicate copy of names
         
         System.out.println("After copying, names = ");
         names.graph();
         System.out.println("After copying, names2 = ");
         names2.graph();     
         
         System.out.println("Now adding a test name to names2 ");
         names2.add("TEST");
         System.out.println("Now names = (should NOT show TEST)");
         names.graph();
         System.out.println("Now, names2 = (SHOULD show TEST)");
         names2.graph();        
         

         // It might be useful to use a isLeaf(TreeNode st) method.
		//*************************** Problem 5 trimLeaves  method **************** 
        // write and test a trimLeaves method that removes the leaves of a binary search tree
        //    use a recursive approach
 
        System.out.println("\n\n****************  Problem 5 *********************\n");
        
		// reset the list
		BST tree = new BST();
        tree.add("m");  tree.add("g");  tree.add("t");  tree.add("d"); tree.add("q"); tree.add("v");

        System.out.println("\na) tree before = " ); 
        tree.graph();
		//tree.trimLeaves();
        System.out.println("After trimLeaves() tree = ");
        tree.graph();

        tree = new BST();
        tree.add("m"); 
        
        System.out.println("\nb) tree before = " ); 
        tree.graph();
		//tree.trimLeaves();
        System.out.println("After trimLeaves() tree = (should be empty tree)");
        tree.graph();
        
        tree = new BST();
        tree.add("m");  tree.add("g");  tree.add("t");  tree.add("d"); tree.add("j"); tree.add("q"); tree.add("v");
        tree.add("b");  tree.add("h");  tree.add("o");  tree.add("r");
        tree.add("p");  tree.add("s");
        
        System.out.println("\nc) tree before = " ); 
        tree.graph();
		//tree.trimLeaves();
        System.out.println("After trimLeaves() tree = ");
        tree.graph();        
	    //*************************** END Problem 5 ***********************************/      


         
       
    }
}
