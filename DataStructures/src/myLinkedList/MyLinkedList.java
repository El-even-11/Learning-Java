package myLinkedList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<AnyType> implements Iterable<AnyType> {

	private Node<AnyType> head;
	private Node<AnyType> tail;
	private int theSize;
	private int modCount = 0;

	private static class Node<AnyType> {
		public AnyType data;
		public Node<AnyType> pre;
		public Node<AnyType> next;

		public Node(AnyType d, Node<AnyType> p, Node<AnyType> n) {
			data = d;
			pre = p;
			next = n;
		}
	}

	public MyLinkedList() {
		doClear();
	}

	private void doClear() {
		head = new Node<AnyType>(null, null, null);
		tail = new Node<AnyType>(null, head, null);
		head.next = tail;
		theSize = 0;
	}

	public int size() {
		return theSize;
	}

	public boolean isEmpty() {
		return theSize == 0;
	}

	public boolean add(AnyType x) {
		add(theSize, x);
		return true;
	}

	public void add(int index, AnyType x) {
		addBefore(getNode(index), x);
	}

	public AnyType get(int index) {
		return getNode(index).data;
	}

	public AnyType set(int index, AnyType newData) {
		AnyType old = getNode(index).data;
		getNode(index).data = newData;
		return old;
	}

	public AnyType remove(int index) {
		return remove(getNode(index));
	}

	public boolean contains(AnyType x) {
		for (Node<AnyType> p = head.next; p != tail; p = p.next) {
			if (p.data == x) {
				return true;
			}
		}

		return false;
	}

	private void addBefore(Node<AnyType> p, AnyType x) {
		Node<AnyType> newNode = new Node<>(x, p.pre, p);
		newNode.pre.next = newNode;
		p.pre = newNode;
		theSize++;
		modCount++;
	}

	private Node<AnyType> getNode(int index) {
		return getNode(index, 0, theSize);
	}

	private Node<AnyType> getNode(int index, int low, int high) {
		if (index < low || index > high) {
			throw new IndexOutOfBoundsException();
		}

		Node<AnyType> p;
		if (index < theSize / 2) {
			p = head.next;

			for (int i = 0; i < index; i++) {
				p = p.next;
			}
		} else {
			p = tail;

			for (int i = theSize; i > index; i--) {
				p = p.pre;
			}
		}

		return p;
	}

	private AnyType remove(Node<AnyType> p) {
		AnyType old = p.data;

		p.pre.next = p.next;
		p.next.pre = p.pre;
		theSize--;
		modCount++;

		return old;
	}

	@Override
	public Iterator<AnyType> iterator() {
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements Iterator<AnyType> {

		private Node<AnyType> current = head;
		private int expectedModCount = modCount;
		private boolean okToRemove = false;

		@Override
		public boolean hasNext() {
			return current.next != tail;
		}

		@Override
		public AnyType next() {
			if (expectedModCount != modCount) {
				throw new ConcurrentModificationException();
			}

			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			AnyType theNext = current.next.data;
			current = current.next;
			okToRemove = true;

			return theNext;
		}

		public void remove() {
			if (expectedModCount != modCount) {
				throw new ConcurrentModificationException();
			}

			if (!okToRemove) {
				throw new IllegalStateException();
			}

			MyLinkedList.this.remove(current);
			expectedModCount++;
			okToRemove = false;

		}

	}

	public static void main(String[] args) {
		MyLinkedList<String> list = new MyLinkedList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		System.out.println(list.contains("a"));
		System.out.println(list.contains("d"));
	}

}
