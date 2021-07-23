package recoverBinarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;

import nodes.TreeNode;

public class RecoverBinarySearchTree {

	ArrayList<TreeNode> all = new ArrayList<>();

	public void recoverTree(TreeNode root) {

		dfs(root);

		int []vals=new int [all.size()];
		int i=0;
		for (TreeNode node:all) {
			vals[i]=node.val;
			i++;
		}
		
		Arrays.sort(vals);
		
		i=0;
		for (TreeNode node:all) {
			node.val=vals[i];
			i++;
		}
	}

	public void dfs(TreeNode root) {
		if (root == null) {
			return;
		}

		dfs(root.left);
		all.add(root);
		dfs(root.right);
	}

}
