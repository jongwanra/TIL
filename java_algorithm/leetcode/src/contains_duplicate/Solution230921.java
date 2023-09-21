/*
* https://leetcode.com/problems/contains-duplicate/description
*
* */

package contains_duplicate;
import java.util.*;
public class Solution230921 {
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for(int n:nums) {
			if(set.contains(n)) {
				return true;
			}
			set.add(n);
		}
		
		return nums.length != set.size();
		
	}
}
