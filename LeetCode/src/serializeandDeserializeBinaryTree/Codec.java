package serializeandDeserializeBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import nodes.TreeNode;

public class Codec {

	// 构造二叉树轮子！！！！！

	// Encodes a tree to a single string.
	public static String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}

		StringBuilder ret = new StringBuilder();

		Queue<TreeNode> nodes = new LinkedList<>();

		nodes.offer(root);

		while (!nodes.isEmpty()) {
			int size = nodes.size();
			for (int i = 0; i < size; i++) {
				TreeNode temp = nodes.poll();
				if (temp == null) {
					ret.append("null,");
				} else {
					ret.append("" + temp.val + ",");
					nodes.offer(temp.left);
					nodes.offer(temp.right);
				}
			}
		}
		
		ret.deleteCharAt(ret.length()-1);
		while (ret.charAt(ret.length()-1)=='l') {
			ret.delete(ret.length()-5, ret.length());
		}

		return ret.toString();
	}

	// Decodes your encoded data to tree.
	public static TreeNode deserialize(String data) {
		String[] nodes = data.split(",");

		ArrayList<String[]> rows = new ArrayList<>();

		int cnt = 1;
		int pos = 0;
		while (pos < nodes.length) {
			ArrayList<String> row = new ArrayList<>();
			int nullcnt = 0;
			for (int i = 0; i < cnt && pos + i < nodes.length; i++) {
				row.add(nodes[pos + i]);
				if (row.get(i).equals("null")) {
					nullcnt++;
				}
			}
			pos += cnt;
			cnt = (cnt - nullcnt) * 2;
			rows.add(row.toArray(new String[row.size()]));
		}

		if (rows.get(0)[0].equals("null")) {
			return null;
		}

		Queue<TreeNode> roots = new LinkedList<>();

		int rootVal = Integer.parseInt(rows.get(0)[0]);
		TreeNode root = new TreeNode(rootVal);

		roots.offer(root);
		int deep = 1;
		while (deep < rows.size()) {
			int size = roots.size();
			int rowPos = 0;
			for (int i = 0; i < size; i++) {
				if (rowPos == rows.get(deep).length) {
					break;
				}
				TreeNode temp = roots.poll();
				if (!rows.get(deep)[rowPos].equals("null")) {
					int val = Integer.parseInt(rows.get(deep)[rowPos]);

					temp.left = new TreeNode(val);
				} else {
					temp.left = null;
				}
				rowPos++;

				if (rowPos == rows.get(deep).length) {
					break;
				}

				if (!rows.get(deep)[rowPos].equals("null")) {
					int val = Integer.parseInt(rows.get(deep)[rowPos]);

					temp.right = new TreeNode(val);
				} else {
					temp.right = null;
				}
				rowPos++;

				if (temp.left != null) {
					roots.offer(temp.left);
				}
				if (temp.right != null) {
					roots.offer(temp.right);
				}
			}
			deep++;

		}
		return root;
	}

	public static void main(String[] args) {
		System.out.println(serialize(deserialize("4,1,null,2,null,3")));
	}
}
