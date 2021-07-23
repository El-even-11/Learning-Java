package binaryTreePaths;

import java.util.ArrayList;
import java.util.List;

import nodes.TreeNode;

public class binaryTreePaths {

	List<String> paths = new ArrayList<>();

	public List<String> theBinaryTreePaths(TreeNode root) {

		dfs(root, "");
		return paths;
	}

	public void dfs(TreeNode root, String path) {
		if (root == null) {
			return;
		}

		StringBuilder now = new StringBuilder(path);

		if (root.left == null && root.right == null) {
			now.append("" + root.val);
			paths.add(now.toString());
		} else {
			now.append("" + root.val);
			now.append("->");
			dfs(root.left, now.toString());
			dfs(root.right, now.toString());
		}
		
	}
}
