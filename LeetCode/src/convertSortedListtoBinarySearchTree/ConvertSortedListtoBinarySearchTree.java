package convertSortedListtoBinarySearchTree;

import java.util.ArrayList;

import nodes.ListNode;
import nodes.TreeNode;

public class ConvertSortedListtoBinarySearchTree {

	public TreeNode sortedListToBST(ListNode head) {

		int[] nums = new int[10000];

		int cnt = 0;
		for (ListNode i = head; i != null; i = i.next) {
			nums[cnt++] = i.val;
		}

		return dfs(nums, 0, cnt - 1);
	}

	public TreeNode dfs(int[] nums, int left, int right) {

		if (left > right) {
			return null;
		}
		int mid = left + (right - left) / 2;

		TreeNode node = new TreeNode(nums[mid]);

		node.left = dfs(nums, left, mid - 1);
		node.right = dfs(nums, mid + 1, right);
		return node;
	}

	public TreeNode sortedListToBST_two(ListNode head) {

		return buildTree(head, null);
	}

	public TreeNode buildTree(ListNode left, ListNode right) {
		if (left == right) {
			return null;
		}

		ListNode mid=getMid(left,right);
		TreeNode root = new TreeNode(mid.val);
		root.left=buildTree(left, mid);
		root.right=buildTree(mid.next,right);
		
		return root;
	}

	public ListNode getMid(ListNode left, ListNode right) {
		ListNode slow = left;
		ListNode fast = left;

		while (fast != right && fast.next != right) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
