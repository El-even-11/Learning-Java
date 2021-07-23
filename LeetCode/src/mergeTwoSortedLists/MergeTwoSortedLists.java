package mergeTwoSortedLists;

public class MergeTwoSortedLists {

	public ListNode mergeTwoListsTwo(ListNode l1, ListNode l2) {
		ListNode head=new ListNode();
		ListNode cur=head;

		while (l1!=null&&l2!=null) {
			if (l1.val>=l2.val) {
				cur.next=l2;
				cur=cur.next;
				l2=l2.next;
			}else {
				cur.next=l1;
				cur=cur.next;
				l1=l1.next;
			}
		}
		
		if (l1==null) {
			cur.next=l2;
		}else {
			cur.next=l1;
		}
		
		return head.next;
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1==null) {
			return l2;
		}else if (l2==null) {
			return l1;
		}else if (l1.val>=l2.val) {
			l2.next=mergeTwoLists(l1, l2.next);
			return l2;
		}else {
			l1.next=mergeTwoLists(l1.next, l2);
			return l1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
