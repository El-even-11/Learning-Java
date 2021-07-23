package binaryTreeMaximumPathSum;

import nodes.TreeNode;

public class BinaryTreeMaximumPathSum {

	int maxPath = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		dps(root, 0);
		return maxPath;
	}

	public int dps(TreeNode root, int pathSum) {
		if (root == null) {
			return 0;
		}

		int left = dps(root.left, pathSum);
		int right = dps(root.right, pathSum);

		int thisPath = pathSum;
		if (left < 0 && right < 0) {
			thisPath += root.val;
		} else if (left < 0) {
			thisPath += root.val + right;
		} else if (right < 0) {
			thisPath += root.val + left;
		} else {
			thisPath += root.val + left + right;
		}

		if (left < 0 && right < 0) {
			pathSum += root.val;
		} else {
			pathSum += root.val + Math.max(left, right);
		}

		maxPath = Math.max(thisPath, maxPath);
		return pathSum;
	}
}
