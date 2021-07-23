package leetCode112802;

import nodes.ListNode;

public class LeetCode112802 {

	public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

		ListNode p=list1;
		
		for (int i=0;i<a-1;i++) {
			p=p.next;
		}                      //p.nextÉ¾³ý
		
		ListNode start=p;
		
		for (int i=a-1;i<b-1;i++) {
			p=p.next;
		}
		
		ListNode end=p.next;
		
		ListNode q=list2;
		
		while (q.next!=null) {
			q=q.next;
		}
		
		q.next=end.next;
		
		start.next=list2;
		return list1;
	}

}
