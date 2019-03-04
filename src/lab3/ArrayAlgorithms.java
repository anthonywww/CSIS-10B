package lab3;

import java.util.Arrays;

/**
 * Write a description of class ArrayProblems here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArrayAlgorithms {
	
	public static void main(String[] args) {
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
		arr1 = remove(arr2, -7);
		// invoke your method to remove 5 from arr3
		arr1 = remove(arr3, 5);

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
		replaceLast(arr2, 3);
		// invoke your method to replace last item of arr3 with 9
		replaceLast(arr3, 9);
		
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
		replace(arr2, 5, 29);
		// invoke your method to replace position 1 of arr3 with 2
		replace(arr3, 1, 2);
		
		System.out.println("Now arr1= " + Arrays.toString(arr1));
		System.out.println("Now arr2= " + Arrays.toString(arr2));
		System.out.println("Now arr3= " + Arrays.toString(arr3));
	}


	private static int sum(int[] nums) {
		int total = 0;
		for (int n=0; n<nums.length; n++) {
			total += nums[n];
		}
		return total;
	}


	private static boolean contains(int[] nums, int value) {
		for (int n : nums) {
			if (n == value) {
				return true;
			}
		}
		return false;
	}


	private static final int min(int[] nums) {
		int min = Integer.MAX_VALUE;
		for (int i=0; i<nums.length; i++) {
			if (nums[i] < min) {
				min = nums[i];
			}
		}
		return min;
	}


	private static final int max(int[] nums) {
		int max = Integer.MIN_VALUE;
		for (int i=0; i<nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
			}
		}
		return max;
	}


	private static final int[] insert(int[] nums, int value) {
		int[] newArray = new int[nums.length+1];
		nums[0] = value;
		for (int i=1; i<newArray.length; i++) {
			newArray[i] = nums[i-1];
		}
		return newArray;
	}


	private static final void replaceLast(int[] nums, int value) {
		replace(nums, nums.length-1, value);
	}
	
	private static final void replace(int[] nums, int position, int value) {
		if (position < nums.length) {
			nums[position] = value;
		}
	}

	private static final int[] remove(int[] nums, int value) {
		if (contains(nums, value)) {
			int[] newArray = new int[nums.length-1];
			for (int i=0; i<nums.length-1; i++) {
				if (nums[i] != value) {
					newArray[i] = nums[i];
				}
			}
			return newArray;
		}
		return null;
	}
	
	
}

/*
Problem 1
sum of arr1 = 64
sum of arr2 = 53
sum of arr3 = 11
Problem 2
is 18 in arr1? true
is 3 in arr2? false
is 1 in arr3? true
Problem 3
minimum value of arr1= 3
minimum value of arr2= -9
minimum value of arr3= 0
Problem 4
maximum value of arr1= 24
maximum value of arr2= 31
maximum value of arr3= 5
Problem 5
Now arr1= [0, 0, 0]
Now arr2= [31, -9, 5, 21, 4, 0, 8, -7]
Now arr3= [5, 5, 0, 1]
Problem 6
Now arr1= [0, 11, 0, 0]
Now arr2= [31, -9, 5, 21, 4, 0, 8, -7]
Now arr3= [5, 5, 0, 1]
Problem 7
Now arr1= [0, 11, 0, 5]
Now arr2= [31, -9, 5, 21, 4, 0, 8, 3]
Now arr3= [5, 5, 0, 9]
Problem 8
Now arr1= [0, 11, 15, 5]
Now arr2= [31, -9, 5, 21, 4, 29, 8, 3]
Now arr3= [5, 2, 0, 9]
*/

