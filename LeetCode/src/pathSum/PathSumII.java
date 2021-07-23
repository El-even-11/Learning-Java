package pathSum;

import java.util.ArrayList;
import java.util.List;

import nodes.TreeNode;

public class PathSumII {
	List<List<Integer>> ret = new ArrayList<>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {

		dfs(root, 0, new ArrayList<>(), sum);

		return ret;
	}

	public void dfs(TreeNode root, int pathSum, List<Integer> cur, int sum) {
		if (root == null) {
			return;
		}

		cur.add(root.val);
		pathSum += root.val;
		if (root.left == null && root.right == null) {
			if (pathSum == sum) {
				ret.add(cur);
			}
			return;
		}

		dfs(root.left, pathSum, new ArrayList<>(cur), sum);
		dfs(root.right, pathSum, new ArrayList<>(cur), sum);

	}

}
