package binary_search;
import java.util.*;

public class Solution {
	public int search(int[] nums, int target) {
		int leftIndex = 0;
		int rightIndex = nums.length -1;

		while(leftIndex <= rightIndex) {
			final int middleIndex = (leftIndex + rightIndex) / 2;

			if(nums[middleIndex] == target) {
				return middleIndex;
			}

			if(nums[middleIndex] < target) {
				leftIndex = middleIndex +1;
				continue;
			}
			rightIndex = middleIndex - 1;
		}

		return -1;
	}
}