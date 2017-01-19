package com.test.tree;

/**
 * @author wennan.luo
 * 递归就是本层结果+左右两个孩子的结果；
 * 对于返回值，返回的就是当前的返回值（maybe 会调用它孩子的返回值）
 */

public class PathSum112 {
	
	public boolean hasPathSum(TreeNode root, int sum) {
	    boolean flag = false;
		if(root != null) {
	    	sum -= root.val;
	    	if(root.left == null && root.right == null) {
	    		if(sum == 0) {
	    			flag = true;
	    			return flag;
	    		}
	    	} else {
	    		flag = hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
	    	}
		}
	    return flag;
    }
}
