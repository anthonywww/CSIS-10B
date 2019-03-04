//--------------------------------------------------------------------
//
//  Laboratory 4, In-lab Exercise 1                     TestDNA.java
//
//  Test program for the countbases method
//
//--------------------------------------------------------------------

// Reads a DNA sequence from the keyboard, calls method countBases
// countBases (which uses a list to represent a DNA sequence), and
// outputs the number of times that each base (A, G, C and T) occurs
// in the sequence.

import java.io.IOException;

class TestDNA {
    
	private static int aCount,  // Number of A's in the sequence
                       cCount,  // Number of C's in the sequence
                       tCount,  // Number of T's in the sequence
                       gCount;  // Number of G's in the sequence
    
	public static void main(String[] args) throws IOException {
		LList<Character> dnaSequence = new LList<Character>(); // DNA sequence (unlimited letters.)
		char base; // DNA base

		// Read the DNA sequence from the keyboard.
		System.out.println("\nEnter a DNA sequence: ");

		// read a String one character at a time into the list
		base = (char) System.in.read();
		while (base != '\r' && base != '\n') {
			System.out.println(base);
			dnaSequence.add(base);
			base = (char) System.in.read();
		}

		// Display the sequence.
		System.out.print("Sequence: " + dnaSequence + "\n");

		// Count the number of times that each base occurs.
		countBases(dnaSequence);

		// Output the totals.
		System.out.println("Number of A's : " + aCount);
		System.out.println("Number of C's : " + cCount);
		System.out.println("Number of T's : " + tCount);
		System.out.println("Number of G's : " + gCount);
	}

	/**
	 * 	Counts the number of times that each base (A, C, T, G) occurs in dnaSequence.
	 * @param dnaSequence
	 */
	private static void countBases(LList<Character> dnaSequence) {
		// awful ... and no javadoc either, great
		
		for (Object o : dnaSequence.toArray()) {
			if (o instanceof Character) {
				char c = (char) o;
				
				switch(c) {
					case 'A':
						aCount++;
						break;
					case 'C':
						cCount++;
						break;
					case 'T':
						tCount++;
						break;
					case 'G':
						gCount++;
						break;	
					default:
						System.err.println("Error in DNA sequence '" + c + "'");
						break;
				}
			}
			
		}
		
	}
}

/*
Enter a DNA sequence: 
ABATAGCA
A
B
A
T
A
G
C
A
Sequence: A, B, A, T, A, G, C, A
Error in DNA sequence 'B'
Number of A's : 4
Number of C's : 1
Number of T's : 1
Number of G's : 1
*/
