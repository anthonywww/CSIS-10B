package lab3;

/**
 * Write a description of class ArrayProblems here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArrayAlgorithms {
	public static void main(String[] args) {
		System.out.println("\f");
		int arr1[] = { 24, 18, 12, 3, 7 };
		int arr2[] = { 31, -9, 5, 21, 4, 0, 8, -7 };
		int arr3[] = { 5, 5, 0, 1 };
		String arr4[] = { "aba", "bcb", "cdc", "ded", "efe", "fgf", "hih" };
		String arr5[] = {};
		char arr6[] = { 'a', 'b' };
		// ******************* Problem 1 **************************************
		System.out.println("Problem 1");
		System.out.println("sum of arr1 = " + sum(arr1));
		System.out.println("sum of arr2 = " + sum(arr2));
		System.out.println("sum of arr3 = " + sum(arr3));
		// */
		// ****************** Problem 2 **************************************
		System.out.println("Problem 2");
		System.out.println("is 18 in arr1? " + contains(arr1, 18));
		System.out.println("is 3 in arr2? " + contains(arr2, 3));
		System.out.println("is 1 in arr3? " + contains(arr3, 1));
		// */
		// ****************** Problem 3 **************************************
		System.out.println("Problem 3");
		System.out.println("minimum value of arr1= " + min(arr1));
		System.out.println("minimum value of arr2= " + min(arr2));
		System.out.println("minimum value of arr3= " + min(arr3));
		// */
		// ****************** Problem 4 **************************************
		System.out.println("Problem 4");
		System.out.println("maximum value of arr1= " + max(arr1));
		System.out.println("maximum value of arr2= " + max(arr2));
		System.out.println("maximum value of arr3= " + max(arr3)); // */
		// ****************** Problem 5 **************************************
		System.out.println("Problem 5");
		// invoke your method to remove 12 from arr1
		arr1 = remove(arr1, 12); // remove returns the new array so that arr1 changes
		// invoke your method to remove -7 from arr2
		// invoke your method to remove 5 from arr3

		System.out.println("Now arr1= " + Arrays.toString(arr1));
		System.out.println("Now arr2= " + Arrays.toString(arr2));
		System.out.println("Now arr3= " + Arrays.toString(arr3));
		// */
		// ****************** Problem 6 **************************************
		System.out.println("Problem 6");
		// invoke your method to insert 11 at the beginning of arr1
		arr1 = insert(arr1, 11); // insert returns the new array so that arr1 changes
		// invoke your method to insert 2 at the beginning of arr2
		// invoke your method to insert 1 at the beginning of arr3

		System.out.println("Now arr1= " + Arrays.toString(arr1));
		System.out.println("Now arr2= " + Arrays.toString(arr2));
		System.out.println("Now arr3= " + Arrays.toString(arr3));
		// */
		// ****************** Problem 7 **************************************
		System.out.println("Problem 7");
		// invoke your method to replace last item of arr1 with 5
		replaceLast(arr1, 5);
		// invoke your method to replace last item of arr2 with 3
		// invoke your method to replace last item of arr3 with 9

		System.out.println("Now arr1= " + Arrays.toString(arr1));
		System.out.println("Now arr2= " + Arrays.toString(arr2));
		System.out.println("Now arr3= " + Arrays.toString(arr3));
		// */
		// ****************** Problem 8 **************************************
		System.out.println("Problem 8");
		// invoke your method to replace position 2 of arr1 with 15
		replace(arr1, 2, 15);
		// invoke your method to replace position 8 of arr1 with 15
		replace(arr1, 8, 15); // array should remain unchanged and no errors!
		// invoke your method to replace position 5 of arr2 with 29
		// invoke your method to replace position 1 of arr3 with 2

		System.out.println("Now arr1= " + Arrays.toString(arr1));
		System.out.println("Now arr2= " + Arrays.toString(arr2));
		System.out.println("Now arr3= " + Arrays.toString(arr3));
		// */

	}

	public static int sum(int[] nums) {
		return 0; // fix this
	}

	public static int[] remove(int[] nums, int value) {
		return null; // fix this
	}
}
