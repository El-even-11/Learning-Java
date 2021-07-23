package linkedListCycle;

import java.util.HashSet;

import nodes.ListNode;

public class LinkedListCycleII {

	public ListNode detectCycle(ListNode head) {
		ListNode ptr=head;
		HashSet<ListNode> nodes=new HashSet<>();
		
		while (ptr!=null) {
			if (nodes.contains(ptr)) {
				return ptr;
			}
			
			nodes.add(ptr);
			ptr=ptr.next;
		}
		
		return null;
	}
}
