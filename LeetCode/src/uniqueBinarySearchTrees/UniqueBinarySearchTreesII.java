package uniqueBinarySearchTrees;

import java.util.ArrayList;
import java.util.List;

import nodes.TreeNode;

public class UniqueBinarySearchTreesII {

	public List<TreeNode> generateTrees(int n) {
		if (n==0) {
			return null;
		}
		
		return dfs(1,n);
	}

	public List<TreeNode> dfs(int start, int end) {
		List<TreeNode> all = new ArrayList<>();
		if (start > end) {
			all.add(null);
			return all;
		}

		for (int i = start; i <= end; i++) {
			List<TreeNode> leftTrees = dfs(start, i - 1);
			List<TreeNode> rightTrees = dfs(i + 1, end);

			for (TreeNode left : leftTrees) {
				for (TreeNode right : rightTrees) {
					TreeNode root=new TreeNode(i);
					root.left=left;
					root.right=right;
					all.add(root);
				}
			}
		}
		
		return all;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
