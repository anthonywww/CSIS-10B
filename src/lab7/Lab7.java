package lab7;

import java.util.Arrays;
import java.util.Random;

/**
 * Lab 7 Test driver for Sorting Algorithms
 */

public class Lab7 {
	
	public static void main(String[] args) {
		// -----------------------------------
		// Part 1 Bench Testing
		// -----------------------------------

		// -----------------------------------
		// Array and other declarations
		// -----------------------------------
		StopWatch sw = new StopWatch(); // timer for measuring execution speed
		final int SIZE = 100000; // size of array we are using

		int[] sourceArray, copyArray; // arrays for testing insertionSort and selectionSort
		Integer[] sourceArray2, copyArray2; // arrays for testing shell, merge, quicksort

		// -------------------------------------------------
		// Array initialization to a predetermined shuffle
		// -------------------------------------------------
		sourceArray = new int[SIZE]; // for use in selection, insertion sort
		scrambleArray(sourceArray, true); // scramble to a random state
		sourceArray2 = new Integer[SIZE]; // for use in shell,merge,quicksort
		scrambleArray(sourceArray2, true); // scramble to a random state

		// ---------------------------------------
		// SELECTION SORT
		// ---------------------------------------
		// for all sorts, we must reset copyArray
		// to sourceArray before sorting
		// ---------------------------------------
		copyArray = Arrays.copyOf(sourceArray, SIZE);

		System.out.println("Before Selection Sort");
		// printArray(copyArray);
		System.out.println("Selection Sort");
		sw.start(); // start timer
		SortArray.selectionSort(copyArray, SIZE);
		sw.stop(); // stop timer
		System.out.println("selection sort took " + sw.getElapsedTime() + " msec");
		System.out.println("After Selection Sort");
		// printArray(copyArray);

		// -----------------------------------------
		// INSERTION SORT
		// -----------------------------------------
		// Reset copyArray back to unsorted state
		// -----------------------------------------

		// add statements for STEP 2 here

		// -----------------------------------------
		// SHELL SORT
		// -----------------------------------------
		// Reset copyArray2 back to unsorted state
		// -----------------------------------------

		// add statements for STEP 3 here

		// -----------------------------------------
		// MERGE SORT
		// -----------------------------------------
		// Reset copyArray2 back to unsorted state
		// -----------------------------------------

		// add statements for STEP 4 here

		// -----------------------------------------
		// QUICK SORT
		// -----------------------------------------
		// Reset copyArray2 back to unsorted state
		// -----------------------------------------

		// add statements for STEP 5 here

	}

	/**
	 * Print an array of integers to the screen
	 */
	private static void printArray(int[] a) {
		for (int k = 0; k < a.length; k++) {
			System.out.print(a[k] + " ");
		}
		System.out.println();
	}

	/**
	 * Initialize and scramble an int array, either to a known state or a random
	 * state
	 * 
	 * @param randomize
	 *            a boolean indicating whether scramble should be random or known
	 *            (using false means all copies of this program will run the same)
	 */
	private static void scrambleArray(int[] a, boolean randomize) {
		for (int k = 0; k < a.length; k++)
			a[k] = k;
		if (randomize) // use unpredictable random shuffle
		{
			Random gen = new Random();
			for (int k = 0; k < a.length; k++) {
				swap(a, k, gen.nextInt(a.length));
			}
		} else // use repeatable math formula for shuffle
		{
			int cell = (int) (a.length * 3.14159) % a.length;
			for (int k = 0; k < a.length; k++) {
				swap(a, k, cell);
				cell = (int) (cell * 3.14159) % a.length;
			}
		}

	}

	/**
	 * Exchange cells x and y in int array a
	 */
	private static void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

	/**
	 * Print Integer array to screen
	 */
	private static void printArray(Integer[] a) {
		for (int k = 0; k < a.length; k++) {
			System.out.print(a[k] + " ");
		}
		System.out.println();
	}

	/**
	 * Initialize and scramble an Integer array, either to a known state or a random
	 * state
	 * 
	 * @param randomize
	 *            a boolean indicating whether scramble should be random or known
	 *            (using false means all copies of this program will run the same)
	 */
	private static void scrambleArray(Integer[] a, boolean randomize) {
		for (int k = 0; k < a.length; k++)
			a[k] = k;
		if (randomize) {
			Random gen = new Random();
			for (int k = 0; k < a.length; k++) {
				swap(a, k, gen.nextInt(a.length));
			}
		} else {
			int cell = (int) (a.length * 3.14159) % a.length;
			for (int k = 0; k < a.length; k++) {
				swap(a, k, cell);
				cell = (int) (cell * 3.14159) % a.length;
			}
		}

	}

	/**
	 * Exchange cells x and y in Integer array a
	 */
	private static void swap(Integer[] a, int x, int y) {
		Integer temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

}
