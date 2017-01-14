package com.test.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SumRoot129 {
	public static Logger logger = LoggerFactory.getLogger(SumRoot129.class);
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
	
	
	public int sumNumbers(TreeNode root) {
//		return recursionFristTree(root, 0, 0);
		map.put(root, 0);
		return notRecursionFristTree(root);
	}
	
	private int recursionFristTree(TreeNode root, int val, int all) {
		if(root != null) {
			int sum = root.val + val * 10;
			if(root.left == null && root.right == null) {
				all = all + sum;
			}
			all = recursionFristTree(root.left, sum, all);
			all = recursionFristTree(root.right, sum, all);
		}
		
		return all;
	}
	
	Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
	int all = 0;
	
	public int notRecursionFristTree(TreeNode root) {
		while(true) {
			if(root != null) {
				int val = map.get(root) * 10 + root.val;
				if(root.left == null && root.right == null) {
					all = all + val;
				}
				push(root);
				root = root.left;
				map.put(root, val);
			} else {
				if(isEmpty()) return all;
				root = pop();
				int val = map.get(root) * 10 + root.val;
				root = root.right;
				map.put(root, val);
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node1.left = node2;
		node1.right = node3;
		
		SumRoot129 demo = new SumRoot129();
		logger.info(demo.sumNumbers(node1) + "");
	}
}
