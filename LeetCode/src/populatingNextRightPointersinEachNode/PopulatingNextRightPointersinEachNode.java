package populatingNextRightPointersinEachNode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {

	public Node connect(Node root) {

		if (root == null) {
			return null;
		}

		Queue<Node> nodes = new LinkedList<>();
		nodes.offer(root);

		while (!nodes.isEmpty()) {
			int n = nodes.size();
			for (int i = 0; i < n; i++) {
				Node temp = nodes.poll();
				if (i == n - 1) {
					temp.next = null;
				} else {
					temp.next = nodes.peek();
				}
				if (temp.left != null) {
					nodes.offer(temp.left);
				}
				if (temp.right != null) {
					nodes.offer(temp.right);
				}
			}
		}

		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
