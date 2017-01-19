package com.test.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricTree101 {

	public boolean isSymmetric(TreeNode root) {
        boolean flag = true;
		List<List<TreeNode>> res = zigzagLevelOrder2(root);
        for(int i = 0; i < res.size(); i++) {
        	if(checkArrayIsSymmetircOrNot(res.get(i)) == false ) {
        		flag = false;
        		break;
        	}
        }
        
        return flag;
    }
	
	private List<List<TreeNode>> zigzagLevelOrder2(TreeNode root) {
		List<List<TreeNode>> res = new ArrayList<List<TreeNode>>();
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();  
	    if(root == null) return res;
	    
	    queue.add(root); 
	    bfs(res, queue);

	    return res;
    }
	
	private void bfs(List<List<TreeNode>> res, Queue<TreeNode> queue) {
		int len = queue.size();
		if(len == 0) return;
		
		List<TreeNode> list = new ArrayList<TreeNode>();
		for(int i = 0; i < len; i++) {
			TreeNode node = queue.poll();  
            list.add(node);  
            if(node != null) {
            	queue.add(node.left);
            	queue.add(node.right);
            }
		}
		res.add(list);
		bfs(res, queue);
	}
	
	private boolean checkArrayIsSymmetircOrNot(List<TreeNode> list) {
		boolean flag = true;
		for(int i = 0; i < list.size() / 2; i++) {
			if( (list.get(i) == null && list.get(list.size() - 1 - i) != null) ||
					(list.get(i) != null && list.get(list.size() - 1 - i) == null)	||
					((list.get(i) != null && list.get(list.size() - 1 - i) != null) && (list.get(i).val != list.get(list.size() - 1 - i).val)) ) {
				flag = false;
				break;
			}
		}
		
		return flag;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
