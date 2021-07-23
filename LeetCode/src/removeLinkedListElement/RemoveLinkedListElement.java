package removeLinkedListElement;

import nodes.ListNode;

public class RemoveLinkedListElement {
	public ListNode removeElements(ListNode head, int val) {
		
		ListNode newHead=new ListNode();
		newHead.next=head;
		ListNode ptr=newHead;
		
		while (ptr.next!=null) {
			if (ptr.next.val==val) {
				ptr.next=ptr.next.next;
			}
			ptr=ptr.next;
		}
		
		return head;
	}
}
