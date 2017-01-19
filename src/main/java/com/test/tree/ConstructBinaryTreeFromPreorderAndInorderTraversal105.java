package com.test.tree;

import javax.swing.plaf.metal.MetalIconFactory.TreeLeafIcon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal105 {
	public static Logger logger = LoggerFactory.getLogger(ConstructBinaryTreeFromInorderAndPostorderTraversal106.class);
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
//		return innerBuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
		return innerBuildTree(preorder, inorder, 0, 0, preorder.length);
	}
	
	private TreeNode innerBuildTree(int[] preorder, int b1, int n1, int[] inorder, int b2, int n2) {
		if(b1 > n1) return null;
		
		TreeNode root = new TreeNode(preorder[b1]);
		int i = b2;
		for(; i <= n2; i++) {
			if(inorder[i] == preorder[b1]) {
				break;
			}
		}
		int leftSize = (i -1) - (b2 - 1);
		root.left = innerBuildTree(preorder, b1 + 1, b1 + leftSize, inorder, b2, (b2 - 1) + leftSize);
		root.right = innerBuildTree(preorder, b1 + leftSize + 1, n1, inorder, i + 1, n2);
		
		return root;
	}
	
	
	private TreeNode innerBuildTree(int[] preorder, int[] inorder, int b1, int b2, int size) {
		logger.info("b1=" + b1 + "\tb2=" + b2 + "\tsize=" + size);
		if(size <= 0) return null;
		TreeNode root = new TreeNode(preorder[b1]);
		int index = 0;
		for(int i = b2; i < b2 + size; i++) {
			if(inorder[i] == preorder[b1]) {
				index = i;
				break;
			}
		}
		int leftSize = (index - 1) - (b2 - 1);
		int rightSize = size - 1 - leftSize;
		root.left = innerBuildTree(preorder, inorder, b1 + 1, b2, leftSize);
		root.right = innerBuildTree(preorder, inorder, b1 + leftSize + 1, b2 + leftSize + 1, rightSize);
		
		return root;
	}
	
	public void TreeNode(TreeNode root) {
		if(root == null) return;
		logger.info(root.val + "");
		TreeNode(root.left);
		TreeNode(root.right);
	}
	
	public static void main(String[] args) {
		int preorder[] ={1, 2};
		int inorder[] ={1, 2};
		ConstructBinaryTreeFromPreorderAndInorderTraversal105 demo = new ConstructBinaryTreeFromPreorderAndInorderTraversal105();
		demo.buildTree(preorder, inorder);
		
	}
	
	
	/******************************************************************************/
	
	public void genNode(int frontIndex, int lastIndex, int[] preorder, int[] inorder) {
		TreeNode root = getRoot(frontIndex, lastIndex, preorder, inorder);
		TreeNode left = getLeft(frontIndex, lastIndex, preorder, inorder);
		TreeNode right = getRight(frontIndex, lastIndex, preorder, inorder);
		root.left = left;
		root.right = right;
		left.left = null;
		left.right = null;
		right.left = null;
		right.right = null;
		
		frontIndex = indexPreorder(root.val, preorder) + 1;
		lastIndex = indexInoder(root.val, inorder);
		if(frontIndex < lastIndex) {
			genNode(frontIndex, lastIndex, preorder, inorder);
		}
		
		frontIndex = indexInoder(root.val, inorder) + 1;
		
	}
	
	public TreeNode getRoot(int frontIndex, int lastIndex, int[] preorder, int[] inorder) {
		if(frontIndex >= lastIndex) return null;
		TreeNode node = new TreeNode(preorder[frontIndex]);
		return node;
	}
	
	public TreeNode getLeft(int frontIndex, int lastIndex, int[] preorder, int[] inorder) {
//		if(frontIndex >= lastIndex) return null;
		if(frontIndex + 1 >= lastIndex) return null;
		TreeNode node = new TreeNode(preorder[frontIndex + 1]);
		return node;
	}
	
	public TreeNode getRight(int frontIndex, int lastIndex, int[] preorder, int[] inorder) {
		if(frontIndex >= lastIndex) return null;
		if(indexInoder(preorder[frontIndex], inorder) >= lastIndex) return null;
		TreeNode node = new TreeNode(preorder[indexInoder(preorder[frontIndex], inorder) + 1]);
		return node;
	}
	
	public int indexPreorder(int target, int[] preorder) {
		for(int i = 0; i < preorder.length; i++) {
			if(target == preorder[i]) {
				return i;
			}
		}
		return -1;
	}
	
	public int indexInoder(int target, int[] inorder) {
		for(int i = 0; i < inorder.length; i++) {
			if(target == inorder[i]) {
				return i;
			}
		}
		return -1;
	}
	
	
}
