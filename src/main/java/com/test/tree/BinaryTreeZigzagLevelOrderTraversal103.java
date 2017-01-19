package com.test.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal103 {
	
	public ArrayList<TreeNode> s = new ArrayList<TreeNode>();
	  
 	public void push(TreeNode t) {
	    s.add(t);
	}
 	
 	public void pushTagNode(int val) {
 		TreeNode node = new TreeNode(val + 1);
 		node.left = new TreeNode(0);
 		node.right = node.left;
 	}
 	
 	public boolean checkIsTagNode(TreeNode node) {
 		boolean flag = false;
 		if(node != null && node.left != null && node.right != null && node.right == node.left) {
 			flag = true;
 		}
 		return flag;
 	}
 	
	public TreeNode pop() {
		TreeNode t = s.get(s.size() - 1);
		s.remove(s.size() - 1);
		return t;
	}
	public boolean isEmpty() {
		return s.isEmpty();
	}
	
	List<List<Integer>> twoListArr = new ArrayList<List<Integer>>();
	
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if(root != null) {
			pushTagNode(0);
			push(root);
			pushTagNode(0);
			ArrayList<Integer> arrList = new ArrayList<Integer>();
			
			visitTree(arrList, 0);
		}
        return twoListArr;
    }
	
	private void visitTree(ArrayList<Integer> arrList, int count) {
		if(s.isEmpty()) return;
		TreeNode root = pop();

		if(checkIsTagNode(root) && pop().val > count) {
			twoListArr.add(arrList);
			ArrayList<Integer> newArr = new ArrayList<Integer>();
			count++;
			visitTree(newArr, count);
		} else if(checkIsTagNode(root)) {
			visitTree(arrList, count);
		} else {
			if(root.left != null || root.right != null) {
				int val = count + 1;
				pushTagNode(val);
				if(root.left != null) 	push(root.left);
				if(root.right != null) 	push(root.right);
				pushTagNode(val);
			}
			arrList.add(root.val);
		}
	}
	
	
}
