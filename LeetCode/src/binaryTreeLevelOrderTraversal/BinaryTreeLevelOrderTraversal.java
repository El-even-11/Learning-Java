package binaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		Queue<TreeNode> nodes = new LinkedList<>();
		nodes.offer(root);

		while (!nodes.isEmpty()) {
			int cnt = nodes.size();
			List<Integer> list = new ArrayList<>();

			while (cnt > 0) {
				TreeNode temp = nodes.poll();
				list.add(temp.val);
				
				if (temp.left != null) {
					nodes.add(temp.left);
				}
				if (temp.right != null) {
					nodes.add(temp.right);
				}
				cnt--;
			}
			ans.add(list);
		}

		return ans;
	}

}
