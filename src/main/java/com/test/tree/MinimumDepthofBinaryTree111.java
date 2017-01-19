package com.test.tree;

public class MinimumDepthofBinaryTree111 {
	public int minDepth(TreeNode root) {
		return midDepth(root, 0);
	}
	
	private int midDepth(TreeNode root, int depth) {
		if(root != null) {
			depth++;
			int left = 0;
			int right = 0;
			if(root.left != null) {
				left = midDepth(root.left, depth);
			}
			if(root.right != null) {
				right = midDepth(root.right, depth);
			}
			if(left != 0 && right == 0) {
				depth = left;
			} else if(left == 0 && right != 0) {
				depth = right;
			} else if(left != 0 && right != 0) {
				depth = Math.min(left, right);
			}
		}
		return depth;
	}
}
