package kthSmallestElementinaBST;

import java.util.ArrayList;

import nodes.TreeNode;

public class KthSmallestElementinaBST {

	ArrayList<Integer> nums=new ArrayList<>();
	
	public int kthSmallest(TreeNode root, int k) {
		dfs(root);
		return nums.get(k-1);
	}

	public void dfs(TreeNode root) {
		if (root==null) {
			return;
		}
		
		dfs(root.left);
		nums.add(root.val);
		dfs(root.right);
	}
}
