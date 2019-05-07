package lab11.ExpressionTrees;

//--------------------------------------------------------------------
//
//  Laboratory 11                                   TestExprTree.java
//
//  Test program for the operations in the Expression Tree ADT
//
//--------------------------------------------------------------------

import java.util.*;
import java.io.*;

class TestExprTree
{
    public static void main(String args[]) throws IOException 
    {
        Scanner keyboard = new Scanner(System.in);
        
        ExprTree testExpression = new ExprTree( );    // Test expression
        ExprTree assignExpression = new ExprTree( );  // Test copying ExprTree
        
        System.out.println( );
        System.out.print("Enter an expression in prefix form : ");
        String exprStr = keyboard.nextLine();
        StringTokenizer tokens = new StringTokenizer(exprStr,"0123456789+-*/",true);

        /* use this if you want to remember how the token object works, 
         * then comment out again, since you will consume all your tokens in this loop
        double tokenVal; 
        while (tokens.hasMoreTokens()){
            thisToken = tokens.nextToken().charAt(0); // read one character from tokens
            System.out.println(" token: " + thisToken);
            
            // use this line when you need to convert thisToken to a double
            tokenVal = (double)Character.getNumericValue(thisToken);
            System.out.println(" tokenVal: " + tokenVal);
        }        
        */
       
        testExpression.build( tokens );  // build an expression tree out of tokens
        testExpression.showStructure( );
        
        
        testExpression.expression( );   // prints the expression in infix form
        System.out.println(" = " + testExpression.evaluate( ));

    } // main

} // class TestExprTree