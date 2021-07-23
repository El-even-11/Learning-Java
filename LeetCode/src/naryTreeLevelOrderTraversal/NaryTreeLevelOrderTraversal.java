package naryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import nodes.Node;

public class NaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(Node root) {
		if (root == null) {
			return new ArrayList<>();
		}

		List<List<Integer>> ret = new ArrayList<>();

		Queue<Node> nodes = new LinkedList<>();
		nodes.offer(root);

		while (!nodes.isEmpty()) {
			int size = nodes.size();
			List<Integer> row = new ArrayList<>();
			
			for (int i = 0; i < size; i++) {
				Node temp = nodes.poll();
				row.add(temp.val);
				nodes.addAll(temp.children);
			}
			
			ret.add(row);
		}
		
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
