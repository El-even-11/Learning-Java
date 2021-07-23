package balancedBinaryTree;

import nodes.TreeNode;

public class BalancedBinaryTree {

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}

		if (Math.abs(getRank(root.left) - getRank(root.right)) <= 1) {
			return isBalanced(root.left) && isBalanced(root.right);
		} else {
			return false;
		}
	}

	public int getRank(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return Math.max(getRank(root.left), getRank(root.right)) + 1;
	}

	public int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);

		if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
