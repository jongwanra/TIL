package binary_tree_right_side_view;
import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode() {
	}
	
	TreeNode(int val) {
		this.val = val;
	}
	
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

// https://leetcode.com/problems/binary-tree-right-side-view/description
public class Solution {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> answer = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root == null) {
			return answer;
		}
		queue.offer(root);
		answer.add(root.val);
		
		while (!queue.isEmpty()) {
			final int size = queue.size();
			boolean isFound = false;
			for (int i = 0; i < size; i++) {
				TreeNode parent = queue.poll();
				// System.out.println("parent::" +  (parent.right != null));
				if (parent.right != null) {
					if (!isFound) {
						isFound = true;
						answer.add(parent.right.val);
					}
					queue.offer(parent.right);
					
				}
				if (parent.left != null) {
					if (!isFound) {
						isFound = true;
						answer.add(parent.left.val);
					}
					queue.offer(parent.left);
				}
			}
			
		}
		
		return answer;
	}
}