package assignment2.assignment2;

/**
 * Write a description of class CodingBat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CodingBat {

	public int countEvens(int[] nums) {
		int evens = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0) {
				evens++;
			}
		}
		return evens;
	}

	public boolean only14(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 1 && nums[i] != 4) {
				return false;
			}
		}
		return true;
	}

	public int[] shiftLeft(int[] nums) {
		if (nums.length == 0) {
			return nums;
		}
		int first = nums[0];
		for (int i = 0; i < nums.length - 1; i++) {
			nums[i] = nums[i + 1];
		}
		nums[nums.length - 1] = first;
		return nums;
	}

	public int sum13(int[] nums) {
		int sum = 0;
		boolean unlucky = false;
		for (int i = 0; i < nums.length; i++) {
			if (unlucky) {
				unlucky = false;
				continue;
			}
			if (nums[i] == 13) {
				unlucky = true;
				continue;
			}
			sum += nums[i];
		}
		return sum;
	}

}
