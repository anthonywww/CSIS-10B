package lab7;/** * A class of static, iterative methods for sorting an array of Comparable * objects from smallest to largest. *  * @author Frank M. Carrano * @version 3.0 */public class SortArray {	public static final int MIN_SIZE = 20; // minimum size for quicksort vs insertion sort	/**	 * Sorts the first n objects in an array of int into ascending order.	 * 	 * @param a	 *            an array of int objects	 * @param n	 *            an integer > 0	 */	public static void selectionSort(int[] a, int n) {		for (int index = 0; index < n - 1; index++) {			int indexOfNextSmallest = getIndexOfSmallest(a, index, n - 1);			swap(a, index, indexOfNextSmallest);			// Assertion: a[0] <= a[1] <= . . . <= a[index] <= all other a[i]		} // end for	} // end selectionSort	/*	 * Finds the index of the smallest value in a portion of an array.	 * 	 * @param a an array of int objects	 * 	 * @param first an integer >= 0 and < a.length that is the index of the first	 * array entry to consider	 * 	 * @param last an integer >= first and < a.length that is the index of the last	 * array entry to consider	 * 	 * @return the index of the smallest value among a[first], a[first + 1], . . . ,	 * a[last]	 */	private static int getIndexOfSmallest(int[] a, int first, int last) {		int min = a[first];		int indexOfMin = first;		for (int index = first + 1; index <= last; index++) {			if (a[index] < min) {				min = a[index];				indexOfMin = index;			} // end if				// Assertion: min is the smallest of a[first] through a[index].		} // end for		return indexOfMin;	} // end getIndexOfSmallest	// -------------------------------------------------------------------------------	// INSERTION SORT	public static void insertionSort(int[] a, int n) {		insertionSort(a, 0, n - 1);	} // end insertionSort	public static void insertionSort(int[] a, int first, int last) {		for (int unsorted = first + 1; unsorted <= last; unsorted++) { // Assertion: a[first] <= a[first + 1] <= ... <=																		// a[unsorted - 1]			int firstUnsorted = a[unsorted];			insertInOrder(firstUnsorted, a, first, unsorted - 1);		} // end for	} // end insertionSort	private static void insertInOrder(int element, int[] a, int begin, int end) {		int index;		for (index = end; (index >= begin) && (element < a[index]); index--) {			a[index + 1] = a[index]; // make room		} // end for		// Assertion: a[index + 1] is available		a[index + 1] = element; // insert	} // end insertInOrder	// -------------------------------------------------------------------------------	// SHELL SORT	public static <T extends Comparable<? super T>> void shellSort(T[] a, int n) {		shellSort(a, 0, n - 1);	} // end shellSort	/**	 * Sorts equally spaced elements of an array into ascending order.	 * 	 * @param a	 *            an array of Comparable objects	 * @param first	 *            an integer >= 0 that is the index of the first array element to	 *            consider	 * @param last	 *            an integer >= first and < a.length that is the index of the last	 *            array element to consider	 * @param space	 *            the difference between the indices of the elements to sort	 */	public static <T extends Comparable<? super T>> void shellSort(T[] a, int first, int last) {		int n = last - first + 1; // number of array entries		for (int space = n / 2; space > 0; space = space / 2) {			for (int begin = first; begin < first + space; begin++)				incrementalInsertionSort(a, begin, last, space);		} // end for	} // end shellSort	/*	 * Sorts equally spaced elements of an array into ascending order.	 * 	 * @param a an array of Comparable objects	 * 	 * @param first the integer index of the first array entry to consider; first >=	 * 0 and < a.length	 * 	 * @param last the integer index of the last array entry to consider; last >=	 * first and < a.length	 * 	 * @param space the difference between the indices of the entries to sort	 */	private static <T extends Comparable<? super T>> void incrementalInsertionSort(T[] a, int first, int last,			int space) {		int unsorted, index;		for (unsorted = first + space; unsorted <= last; unsorted = unsorted + space) {			T nextToInsert = a[unsorted];			for (index = unsorted - space; (index >= first)					&& (nextToInsert.compareTo(a[index]) < 0); index = index - space) {				a[index + space] = a[index];			} // end for			a[index + space] = nextToInsert;		} // end for	} // end incrementalInsertionSort	// -------------------------------------------------------------------------------	// -------------------------------------------------------------------------------	// MERGE SORT	public static <T extends Comparable<? super T>> void iterativeMergeSort(T[] a, int n) {		// the cast is safe because the new array contains null entries		@SuppressWarnings("unchecked")		T[] tempArray = (T[]) new Comparable<?>[a.length]; // unchecked cast		int beginLeftovers = n;		for (int segmentLength = 1; segmentLength <= n / 2; segmentLength = 2 * segmentLength) {			beginLeftovers = mergeSegmentPairs(a, tempArray, n, segmentLength);			// 2 full segments do not remain at end; the following are possibilites:			// a. one full segment and a partial second segment			// b. one full segment only			// c. one partial segment			// d. nothing is left at end			int endSegment = beginLeftovers + segmentLength - 1;			if (endSegment < n - 1)				// Case a: one full segment and a partial second segment exist, so merge them				merge(a, tempArray, beginLeftovers, endSegment, n - 1);			// else Cases b, c, or d: only one full or partial segment is left (leave it in			// place)			// or nothing is left		} // end for		// merge sorted leftovers, if any, with rest of sorted array		if (beginLeftovers < n)			merge(a, tempArray, 0, beginLeftovers - 1, n - 1);	} // end iterativeMergeSort	// Merges pairs of segments of a given length within an array	// and returns the index after the last merged pair.	private static <T extends Comparable<? super T>> int mergeSegmentPairs(T[] a, T[] tempArray, int n,			int segmentLength) {		int mergedPairLength = 2 * segmentLength; // length of two merged segments		int numberOfPairs = n / mergedPairLength;		int beginSegment1 = 0;		for (int count = 1; count <= numberOfPairs; count++) {			int endSegment1 = beginSegment1 + segmentLength - 1;			int beginSegment2 = endSegment1 + 1;			int endSegment2 = beginSegment2 + segmentLength - 1;			merge(a, tempArray, beginSegment1, endSegment1, endSegment2);			beginSegment1 = endSegment2 + 1;		} // end for		return beginSegment1; // return index of element after last merged pair	} // end mergeSegmentPairs	private static <T extends Comparable<? super T>> void merge(T[] a, T[] tempArray, int first, int mid, int last) {		// Two adjacent subarrays are a[beginHalf1..endHalf1] and		// a[beginHalf2..endHalf2].		int beginHalf1 = first;		int endHalf1 = mid;		int beginHalf2 = mid + 1;		int endHalf2 = last;		// while both subarrays are not empty, copy the		// smaller item into the temporary array		int index = beginHalf1; // next available location in								// tempArray		for (; (beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2); index++) { // Invariant:																				// tempArray[beginHalf1..index-1] is in																				// order			if (a[beginHalf1].compareTo(a[beginHalf2]) < 0) {				tempArray[index] = a[beginHalf1];				beginHalf1++;			} else {				tempArray[index] = a[beginHalf2];				beginHalf2++;			} // end if		} // end for		// finish off the nonempty subarray		// finish off the first subarray, if necessary		for (; beginHalf1 <= endHalf1; beginHalf1++, index++)			// Invariant: tempArray[beginHalf1..index-1] is in order			tempArray[index] = a[beginHalf1];		// finish off the second subarray, if necessary		for (; beginHalf2 <= endHalf2; beginHalf2++, index++)			// Invariant: tempa[beginHalf1..index-1] is in order			tempArray[index] = a[beginHalf2];		// copy the result back into the original array		for (index = first; index <= last; index++)			a[index] = tempArray[index];	} // end merge	// -------------------------------------------------------------------------------	// QuickSort	/**	 * Sorts an array into ascending order. Uses quick sort with median-of-three	 * pivot selection for arrays of at least MIN_SIZE entries, and uses insertion	 * sort for other arrays.	 */	public static <T extends Comparable<? super T>> void quickSort(T[] a, int n) {		quickSort(a, 0, n - 1);	}	/**	 * Sorts an array into ascending order. Uses quick sort with median-of-three	 * pivot selection for arrays of at least MIN_SIZE entries, and uses insertion	 * sort for other arrays.	 */	public static <T extends Comparable<? super T>> void quickSort(T[] a, int first, int last) {		if (last - first + 1 < MIN_SIZE) {			insertionSort(a, first, last);		} else {			// create the partition: Smaller | Pivot | Larger			int pivotIndex = partition(a, first, last);			// sort subarrays Smaller and Larger			quickSort(a, first, pivotIndex - 1);			quickSort(a, pivotIndex + 1, last);		} // end if	} // end quickSort	/**	 * Partitions an array as part of quick sort into two subarrays called Smaller	 * and Larger that are separated by a single entry called the pivot. Entries in	 * Smaller are <= pivot and appear before the pivot in the array. Entries in	 * Larger are >= pivot and appear after the pivot in the array.	 * 	 * @param a	 *            an array of Comparable objects	 * @param first	 *            the integer index of the first array entry; first >= 0 and <	 *            a.length	 * @param last	 *            the integer index of the last array entry; last - first >= 3; last	 *            < a.length	 * @return the index of the pivot	 */	private static <T extends Comparable<? super T>> int partition(T[] a, int first, int last) {		int mid = (first + last) / 2;		sortFirstMiddleLast(a, first, mid, last);		// Assertion: The pivot is a[mid]; a[first] <= pivot and		// a[last] >= pivot, so do not compare these two array entries		// with pivot.		// move pivot to next-to-last position in array		swap(a, mid, last - 1);		int pivotIndex = last - 1;		T pivot = a[pivotIndex];		// determine subarrays Smaller = a[first..endSmaller]		// and Larger = a[endSmaller+1..last-1]		// such that entries in Smaller are <= pivot and		// entries in Larger are >= pivot; initially, these subarrays are empty		int indexFromLeft = first + 1;		int indexFromRight = last - 2;		boolean done = false;		while (!done) {			// starting at beginning of array, leave entries that are < pivot;			// locate first entry that is >= pivot; you will find one,			// since last entry is >= pivot			while (a[indexFromLeft].compareTo(pivot) < 0)				indexFromLeft++;			// starting at end of array, leave entries that are > pivot;			// locate first entry that is <= pivot; you will find one,			// since first entry is <= pivot			while (a[indexFromRight].compareTo(pivot) > 0)				indexFromRight--;			assert a[indexFromLeft].compareTo(pivot) >= 0 && a[indexFromRight].compareTo(pivot) <= 0;			if (indexFromLeft < indexFromRight) {				swap(a, indexFromLeft, indexFromRight);				indexFromLeft++;				indexFromRight--;			} else				done = true;		} // end while			// place pivot between Smaller and Larger subarrays		swap(a, pivotIndex, indexFromLeft);		pivotIndex = indexFromLeft;		// Assertion:		// Smaller = a[first..pivotIndex-1]		// Pivot = a[pivotIndex]		// Larger = a[pivotIndex+1..last]		return pivotIndex;	} // end partition	/**	 * Sorts the first, middle, and last entries of an array into ascending order.	 * 	 * @param a	 *            an array of Comparable objects	 * @param first	 *            the integer index of the first array entry; first >= 0 and <	 *            a.length	 * @param mid	 *            the integer index of the middle array entry	 * @param last	 *            the integer index of the last array entry; last - first >= 2, last	 *            < a.length	 */	private static <T extends Comparable<? super T>> void sortFirstMiddleLast(T[] a, int first, int mid, int last) {		order(a, first, mid); // make a[first] <= a[mid]		order(a, mid, last); // make a[mid] <= a[last]		order(a, first, mid); // make a[first] <= a[mid]	} // end sortFirstMiddleLast	/**	 * Orders two given array entries into ascending order so that a[i] <= a[j].	 * 	 * @param a	 *            an array of Comparable objects	 * @param i	 *            an integer >= 0 and < array.length	 * @param j	 *            an integer >= 0 and < array.length	 */	private static <T extends Comparable<? super T>> void order(T[] a, int i, int j) {		if (a[i].compareTo(a[j]) > 0)			swap(a, i, j);	} // end order	// GENERIC BASED INSERTION SORT for use in QUICKSORT	public static <T extends Comparable<? super T>> void insertionSort(T[] a, int n) {		insertionSort(a, 0, n - 1);	} // end insertionSort	public static <T extends Comparable<? super T>> void insertionSort(T[] a, int first, int last) {		for (int unsorted = first + 1; unsorted <= last; unsorted++) { // Assertion: a[first] <= a[first + 1] <= ... <=																		// a[unsorted - 1]			T firstUnsorted = a[unsorted];			insertInOrder(firstUnsorted, a, first, unsorted - 1);		} // end for	} // end insertionSort	private static <T extends Comparable<? super T>> void insertInOrder(T element, T[] a, int begin, int end) {		int index;		for (index = end; (index >= begin) && (element.compareTo(a[index]) < 0); index--) {			a[index + 1] = a[index]; // make room		} // end for		// Assertion: a[index + 1] is available		a[index + 1] = element; // insert	} // end insertInOrder	// -------------------------------------------------------------------------------	// -------------------------------------------------------------------------------	// Swaps the int array entries a[i] and a[j].	private static void swap(int[] a, int i, int j) {		int temp = a[i];		a[i] = a[j];		a[j] = temp;	} // end swap	// Swaps the Object array entries a[i] and a[j].	private static void swap(Object[] a, int i, int j) {		Object temp = a[i];		a[i] = a[j];		a[j] = temp;	} // end swap} // end SortArrayIterative