package com.test.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wennan.luo
 *非递归有个问题，中间变量不好传进来
 */

public class PathSumII113 {
	
	List<List<Integer>> arrList = new ArrayList<List<Integer>>();
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		 ArrayList<Integer> oneList = new ArrayList<Integer>();
		reserveSum(root, sum, oneList);
        return arrList;
    }
	
	private void reserveSum(TreeNode root, int sum, ArrayList<Integer> oneList) {
		if(root != null) {
			oneList.add(root.val);
			sum -= root.val;
			if(root.left == null && root.right == null) {
				if(sum == 0) {
					arrList.add(oneList);
				}
			}
			ArrayList<Integer> leftArr = new ArrayList<Integer>(oneList);
			ArrayList<Integer> rightArr = new ArrayList<Integer>(oneList);
			reserveSum(root.left, sum, leftArr);
			reserveSum(root.right, sum, rightArr);
		}
	}
	
	
	/********************************************/
	public ArrayList<TreeNode> s = new ArrayList<TreeNode>();
  
 	public void push(TreeNode t) {
	    s.add(t);
	}
	public TreeNode pop() {
		TreeNode t = s.get(s.size() - 1);
		s.remove(s.size() - 1);
		return t;
	}
	public TreeNode getVal() {
		TreeNode t = s.get(s.size() - 1);
		return t;
	}
	
	public boolean isEmpty() {
		return s.isEmpty();
	}
	
	private void reserveSumRecursion(TreeNode root, int sum, ArrayList<Integer> oneList) {
		while(true) {
			if(root != null) {
				oneList.add(root.val);
				sum -= root.val;
				if(root.left == null && root.right == null) {
					if(sum == 0) {
						arrList.add(oneList);
					}
				}
				root = root.left;
				ArrayList<Integer> leftArr = new ArrayList<Integer>(oneList);
			} else {
				root = root.right;
			}
		}
	}
}
