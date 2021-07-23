package pathSum;

import nodes.TreeNode;

public class PathSum {

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}

		return judge(root, sum);
	}

	public boolean judge(TreeNode root, int sum) {
		if (root == null && sum != 0) {
			return false;
		}
		if (root == null && sum == 0) {
			return true;
		}

		int sum_now = sum - root.val;

		if (sum_now == 0 && root.left == null && root.right == null) {
			return true;
		}

		if (root.left != null && root.right == null) {
			return judge(root.left, sum_now);
		} else if (root.right != null && root.left == null) {
			return judge(root.right, sum_now);
		} else {
			return judge(root.left, sum_now) || judge(root.right, sum_now);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
