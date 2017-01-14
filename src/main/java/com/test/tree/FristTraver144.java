package com.test.tree;

import java.util.ArrayList;
import java.util.List;

public class FristTraver144 {
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
    
    public List<Integer> preorderTraversal(TreeNode root) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
			
		while(true) {
			if(root != null) {
				push(root);
				list.add(root.val);
				root = root.left;
			} else {
			    if(isEmpty() == true) break;
				root = pop().right;
			}
		}
		
		return list;
    }
}
