package two_sum;
import java.util.*;
public class Solution {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> hm = new HashMap<>(nums.length);
		
		for(int i = 0; i < nums.length; i++) {
			hm.put(nums[i], i);
		}
		
		for(int i = 0; i < nums.length; i++) {
			final int needNum = target - nums[i];
			if(hm.get(needNum) != null && hm.get(needNum) != i) {
				return new int[] {i, hm.get(needNum)};
			}
		}
		
		return new int[] { 0, 0 };
	}
}
