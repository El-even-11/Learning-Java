package partitionList;

import nodes.ListNode;

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode Head = new ListNode();
		Head.next = head;
		ListNode p = Head;
		while (p.next != null) {
			if (p.next.val >= x) {
				break;
			}
			p = p.next;
		}

		ListNode q = p;
		while (q.next != null) {
			if (q.next.val < x) {
				ListNode temp = new ListNode(q.next.val);
				temp.next = p.next;
				p.next = temp;
				p = p.next;
				q.next = q.next.next;
			} else {
				q = q.next;
			}
		}

		return Head.next;
	}
}
