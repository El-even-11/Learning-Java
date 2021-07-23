package binarySearchTreeIterator;

import java.util.ArrayList;
import java.util.Arrays;

import nodes.TreeNode;

public class BSTIterator {

	TreeNode root;
	ArrayList<Integer> vals = new ArrayList<>();
	Integer[] sorted;
	int index = 0;

	public BSTIterator(TreeNode root) {
		this.root = root;
		dfs(root);
		sorted = vals.toArray(new Integer[vals.size()]);
		Arrays.sort(sorted);
	}

	public int next() {
		return sorted[index++];
	}

	public boolean hasNext() {
		return index < vals.size();
	}

	private void dfs(TreeNode root) {
		if (root == null) {
			return;
		}

		vals.add(root.val);
		dfs(root.left);
		dfs(root.right);
	}

}
