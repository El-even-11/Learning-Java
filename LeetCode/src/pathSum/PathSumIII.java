package pathSum;

import nodes.TreeNode;
import serializeandDeserializeBinaryTree.Codec;

public class PathSumIII {

	public static int pathSum(TreeNode root, int sum) {

		return dfs(root, 0, sum, 0);
	}

	public static int dfs(TreeNode root, int sum, int target, int path) {
		if (root == null) {
			return path;
		}

		sum += root.val;

		if (sum == target) {
			path++;
			return path + dfs(root.left, sum, target, path) + dfs(root.right, sum, target, path);
		}

		return path + dfs(root.left, sum, target, path) + dfs(root.right, sum, target, path);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pathSum(Codec.deserialize("10,5,-3,3,2,null,11,3,-2,null,1"), 8));
	}

}
