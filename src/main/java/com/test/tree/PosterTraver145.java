package com.test.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PosterTraver145 {
	
	Set<TreeNode> switchSet = new HashSet<TreeNode>();
	
	public List<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> posterList = new ArrayList<Integer>();
		
		while(true) {
			if( root != null) {
				stack.push(root);
				root = root.left;
			} else {
				if(stack.getSize() != 0) {
					root = stack.getVal();
					if(checkRight(root)) {
						root = root.right;
					} else {
						root = stack.pop();
						posterList.add(root.val);
						root = null;
					}
				} else {
					break;
				}
			}	
		}
		
		return posterList;
    }
	
	private boolean checkRight(TreeNode node) {
		boolean flag = false;
		if(!switchSet.contains(node)) {
			switchSet.add(node);
			flag = true;
		}
		return flag;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
