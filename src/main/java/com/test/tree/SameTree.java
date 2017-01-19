package com.test.tree;

public class SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		return preVistTree(p, q);
	}
	
	public boolean preVistTree(TreeNode t, TreeNode n) {
		 // 若两个指针均为空
		if (t == null && n == null) return true;
        // 若只有一个指针为空
        if (t == null || n == null) return false;
        // 两个指针都不为空，则比较值
        if (t.val != n.val) return false;
		
        return preVistTree(t.left, n.left) && preVistTree(t.right, n.right);
        
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

