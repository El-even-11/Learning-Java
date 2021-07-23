package reserveLinkedList;

import nodes.ListNode;

public class ReserveLinkedList {
	public ListNode reverseList(ListNode head) {
		ListNode newHead = new ListNode();
		newHead.next = null;

		ListNode p = head;

		while (p != null) {
			ListNode q = new ListNode();
			ListNode temp = newHead.next;
			q.val = p.val;
			newHead.next = q;
			q.next = temp;
			p = p.next;
		}

		return newHead.next;
	}
}
