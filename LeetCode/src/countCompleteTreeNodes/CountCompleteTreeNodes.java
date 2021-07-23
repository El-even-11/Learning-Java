package countCompleteTreeNodes;

import java.util.LinkedList;
import java.util.Queue;

import nodes.TreeNode;

public class CountCompleteTreeNodes {

	// bfs slow
	public int countNodes_bfs(TreeNode root) {

		Queue<TreeNode> nodes = new LinkedList<>();

		nodes.offer(root);
		int cnt = 0;
		while (!nodes.isEmpty()) {
			TreeNode now = nodes.poll();
			cnt++;
			if (now.left != null) {
				nodes.offer(now.left);
			}
			if (now.right != null) {
				nodes.offer(now.right);
			}
		}

		return cnt;
	}

	// dfs
	public int countNodes_dfs(TreeNode root) {

		return 0;
	}

	public int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		return 1+dfs(root.left)+dfs(root.right);
	}
}
