package com.test.tree;

public class MaximumDepthOfBinaryTree104 {
	
	public int maxDepth(TreeNode root) {
		return midDepth(root, 0);
	}
	
	private int midDepth(TreeNode root, int depth) {
		if(root != null) {
			depth++;
			depth = Math.max(midDepth(root.left, depth),  midDepth(root.right, depth));
		}
		return depth;
	}
}
