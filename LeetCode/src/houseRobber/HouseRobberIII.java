package houseRobber;

import nodes.TreeNode;
import serializeandDeserializeBinaryTree.Codec;

public class HouseRobberIII {

	public static int rob(TreeNode root) {
		int[] ret = dfs(root);

		return Math.max(ret[0], ret[1]);
	}

	public static int[] dfs(TreeNode root) {
		if (root == null) {
			return new int[] { 0, 0 };
		}

		int[] l = dfs(root.left);
		int[] r = dfs(root.right);

		int[] o = new int[2];
		o[1] = root.val + l[0] + r[0];
		o[0] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
		return o;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(rob(Codec.deserialize("3,4,5,1,3,null,1")));
	}

}
