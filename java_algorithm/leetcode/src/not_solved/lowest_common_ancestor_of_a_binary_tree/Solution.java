package not_solved.lowest_common_ancestor_of_a_binary_tree;

import com.sun.source.tree.Tree;

/**
 * 1시간 동안 풀지 못 한 문제
 * Back Tracking 문제
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x) {
		val = x;
	}
}
class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		return backTracking(root, p , q);
	}
	
	private TreeNode backTracking(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || root == p || root == q) {
			return root;
		}
		
		TreeNode left = backTracking(root.left, p, q);
		TreeNode right = backTracking(root.right, p , q);
		
		if(left != null && right != null) {
			return root;
		}
		
		return left == null ? right : left;
	}
}
