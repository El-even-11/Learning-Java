package removeInLinkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RemoveInLinkedList {

	public static void removeEvens(List<Integer> lst) {
		Iterator<Integer> itr = lst.iterator();

		while (itr.hasNext()) {
			if (itr.next() % 2 == 0) {
				itr.remove();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> lst = new LinkedList<>();

		lst.add(6);
		lst.add(5);
		lst.add(1);
		lst.add(4);
		lst.add(2);

		removeEvens(lst);

		for (Integer x : lst) {
			System.out.print(x + " ");
		}
	}

}
