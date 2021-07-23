package intersectionofTwoLinkedLists;

import java.util.HashSet;

import nodes.ListNode;

public class IntersectionofTwoLinkedLists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode ret = null;

		HashSet<ListNode> nodes_A = new HashSet<>();
		HashSet<ListNode> nodes_B = new HashSet<>();

		ListNode a = headA;
		ListNode b = headB;
		while (a != null || b != null) {
			if (a != null) {
				if (nodes_B.contains(a)) {
					ret = a;
					break;
				}
				nodes_A.add(a);
				a = a.next;
			}

			if (b != null) {
				if (nodes_A.contains(b)) {
					ret = b;
					break;
				}
				nodes_B.add(b);
				b = b.next;
			}
		}

		return ret;
	}

	public ListNode doublePtr(ListNode headA, ListNode headB) {
		if (headA==null||headB==null) {
			return null;
		}
		
		ListNode a = headA;
		ListNode b = headB;

		while (a != b) {
			if (a.next==null) {
				a.next=headB;
			}
			if (b.next==null) {
				b.next=headA;
			}
			a=a.next;
			b=b.next;
		}
		
		return a;
	}
}
