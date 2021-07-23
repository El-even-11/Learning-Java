package sumOfLeftLeaves;

import nodes.TreeNode;

public class SumOfLeftLeaves {

	int sum = 0;

	public int sumOfLeftLeaves(TreeNode root) {

		dfs(root);
		
		return sum;
	}

	public void dfs(TreeNode root) {
		if (root==null) {
			return;
		}
		
		if (root.left!=null) {
			if (isLeave(root.left)) {
				sum+=root.left.val;
			}else {
				dfs(root.left);
			}
		}else {
			dfs(root.right);
		}
		
		return;
	}

	public boolean isLeave(TreeNode root) {
		if (root.left == null && root.right == null) {
			return true;
		} else {
			return false;
		}
	}

}
