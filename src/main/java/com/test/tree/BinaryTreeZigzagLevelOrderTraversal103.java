package com.test.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BinaryTreeZigzagLevelOrderTraversal103 {
	
	public static Logger logger = LoggerFactory.getLogger(BinaryTreeZigzagLevelOrderTraversal103.class);
	public ArrayList<TreeNode> s = new ArrayList<TreeNode>();
	  
 	public void push(TreeNode t) {
	    s.add(t);
	}
 	
 	public void pushTagNode(int val) {
 		TreeNode node = new TreeNode(val);
 		node.left = new TreeNode(0);
 		node.right = node.left;
 		s.add(node);
 	}
 	
 	public boolean checkIsTagNode(TreeNode node) {
 		boolean flag = false;
 		if(node != null && node.left != null && node.right != null && node.right == node.left) {
 			flag = true;
 		}
 		return flag;
 	}
 	
 	public TreeNode get() {
 		TreeNode t = s.get(0);
		return t;
 	}
 	
	public TreeNode pop() {
		TreeNode t = s.get(0);
		s.remove(0);
		return t;
	}
	public boolean isEmpty() {
		return s.isEmpty();
	}
	
	public List<List<Integer>> twoListArr = new ArrayList<List<Integer>>();
	
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if(root != null) {
			pushTagNode(0);
			push(root);
			pushTagNode(0);
			ArrayList<Integer> arrList = new ArrayList<Integer>();
			
			visitTree(arrList, 0);
		}
		for(int i = 1; i < twoListArr.size(); i += 2) {  
            Collections.reverse(twoListArr.get(i));  
        } 
        return twoListArr;
    }
	
	private void visitTree(ArrayList<Integer> arrList, int count) {
		if(s.isEmpty()) {
			twoListArr.add(arrList);
			return;
		}
		TreeNode root = pop();
		
		if(checkIsTagNode(root) && root.val > count) {
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
			visitTree(arrList, count);
		}
	}
	
	
	
	/***************************************************************************************************/
	public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();  
	    if(root == null) return res;
	    
	    queue.add(root); 
	    bfs(res, queue);
	    
	 	for(int i = 1; i < res.size(); i += 2) {  
            Collections.reverse(res.get(i));  
        } 
	    return res;
    }
	
	private void bfs(List<List<Integer>> res, Queue<TreeNode> queue) {
		int len = queue.size();
		if(len == 0) return;
		
		TreeNode node = null;
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < len; i++) {
			node = queue.poll();  
            list.add(node.val);  
            if(node.left != null){  
                queue.add(node.left);  
            }  
            if(node.right!=null){  
                queue.add(node.right);  
            }  
		}
		res.add(list);
		bfs(res, queue);
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);
		TreeNode node6 = new TreeNode(12);
		
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		node2.left = node6;
		BinaryTreeZigzagLevelOrderTraversal103 demo = new BinaryTreeZigzagLevelOrderTraversal103();
		demo.zigzagLevelOrder(node1);
		
		logger.info(demo.twoListArr.toString());
	}
	
}
