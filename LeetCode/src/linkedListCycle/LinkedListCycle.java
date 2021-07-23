package linkedListCycle;

import java.util.HashSet;

import nodes.ListNode;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		HashSet<ListNode> nodes=new HashSet<>();
		
		ListNode now=head;
		while (now!=null) {
			if (nodes.contains(now)) {
				return true;
			}
			nodes.add(now);
			now=now.next;
		}
		
		return false;
	}
	
	public boolean fast_slow_ptr(ListNode head) {
		
		if (head==null){
            return false;
        }
        ListNode fast=head.next;
		ListNode slow=head;
		
		while (fast!=null&&fast.next!=null) {
			if (fast==slow||fast.next==slow) {
				return true;
			}
            fast=fast.next.next;
			slow=slow.next;
		}
		return false;
	}
}
