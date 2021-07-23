package reorderList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import nodes.ListNode;

public class ReorderList {

	public static void reorderList(ListNode head) {

		ListNode p=head;
		
		ArrayList<ListNode> nodes= new ArrayList<>();
		while (p!=null) {
			nodes.add(p);
			p=p.next;
		}
		
		Queue<ListNode> reorderNodes= new LinkedList<ListNode>();
		
		int i=0;
		int j=nodes.size()-1;
		while (i<=j) {
			reorderNodes.offer(nodes.get(i));
			i++;
			reorderNodes.offer(nodes.get(j));
			j--;
			if (i==j) {
				reorderNodes.offer(nodes.get(i));
				break;
			}
		}
		
		reorderNodes.poll();
		p=head;
		
		while (!reorderNodes.isEmpty()) {
			ListNode temp=reorderNodes.poll();
			p.next=temp;
			p=p.next;
			p.next=new ListNode();
		}
		p=null;
	}

	public static void main(String[] args) {
		ListNode head;
		ListNode p;
		ListNode q = new ListNode();
		head = q;
		for (int i = 1; i <= 4; i++) {
			p = new ListNode(i);
			q.next = p;
			q = q.next;
		}
		
		reorderList(head.next);
	}
}
