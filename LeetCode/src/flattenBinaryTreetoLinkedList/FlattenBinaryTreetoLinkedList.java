package flattenBinaryTreetoLinkedList;

import java.util.ArrayList;

import nodes.TreeNode;

public class FlattenBinaryTreetoLinkedList {

	ArrayList<TreeNode> nodes=new ArrayList<>();
	public void flatten(TreeNode root) {
		dfs(root);
		
		nodes.remove(0);
		TreeNode p=root;
		for (TreeNode node:nodes) {
			p.right=node;
			p.left=null;
			p=p.right;
		}
	}
	
	public void dfs(TreeNode root) {
		if (root==null) {
			return;
		}
		
		nodes.add(root);
		dfs(root.left);
		dfs(root.right);
	}
}
