package binaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import nodes.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<>();

		Queue<TreeNode> nodes = new LinkedList<>();

		nodes.offer(root);

		while (!nodes.isEmpty()) {
			List<Integer> row = new ArrayList<>();
			int size = nodes.size();
			while (size > 0) {
				size--;
				TreeNode cur = nodes.poll();
				row.add(cur.val);

				if (cur.left != null) {
					nodes.offer(cur.left);
				}
				if (cur.right != null) {
					nodes.offer(cur.right);
				}
			}
			ret.add(row);
		}

		for (int i = 0; i < ret.size(); i++) {
			if (i % 2 != 0) {
				int size = ret.get(i).size();
				for (int j = 0; j < size / 2; j++) {
					int temp = ret.get(i).get(j);
					ret.get(i).set(j, ret.get(i).get(size - j - 1));
					ret.get(i).set(size - j - 1, temp);
				}
			}
		}
		return ret;
	}
}
