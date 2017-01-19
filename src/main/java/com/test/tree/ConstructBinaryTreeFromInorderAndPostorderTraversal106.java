package com.test.tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal106 {
	 
	public static Logger logger = LoggerFactory.getLogger(ConstructBinaryTreeFromInorderAndPostorderTraversal106.class);
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
//		 return innerBuildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
		return innerBuildTree(inorder, postorder, 0, 0, inorder.length);
	}
	
	public TreeNode innerBuildTree(int[] inorder, int[] postorder, int b1, int n1, int b2, int n2) {
		if(b1 > n1) return null;
		TreeNode root = new TreeNode(postorder[n2]);
		
		int index = 0;
		for(int i = b1; i <= n1; i++) {
			if(inorder[i] == postorder[n2]) {
				index = i;
				break;
			}
		}
		int leftSize = (index - 1) - (b1 - 1);
		root.left = innerBuildTree(inorder, postorder, b1,  (b1 - 1) + leftSize, b2, (b2 - 1) + leftSize);
		root.right = innerBuildTree(inorder, postorder, index + 1, n1, b2 + leftSize, n2 - 1);
		
		return root;
	}
	
	public TreeNode innerBuildTree(int[] inorder, int[] postorder, int b1, int b2, int len) {
		if(len <= 0) return null;
		
		TreeNode root = new TreeNode(postorder[b2 + len - 1]);
		
		int index = 0;
		for(int i = b1; i < len + b1; i++) {
			if(inorder[i] == postorder[b2 + len - 1]) {
				index = i;
				break;
			}
		}
		int leftSize = (index - 1) - (b1 - 1);
		int rightSize = len - 1 - leftSize;
		root.left = innerBuildTree(inorder, postorder, b1, b2, leftSize);
		root.right = innerBuildTree(inorder, postorder, index + 1, b2 + leftSize, rightSize);
		
		return root;
	}
	
	
	public static void main(String[] args) {
		int inorder[] ={1, 2, 3, 4};
		int postorder[] ={4, 3, 2, 1};
		ConstructBinaryTreeFromInorderAndPostorderTraversal106 demo = new ConstructBinaryTreeFromInorderAndPostorderTraversal106();
		demo.buildTree(inorder, postorder);
		
	}
}
