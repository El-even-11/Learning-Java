package myArrayList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<AnyType> implements Iterable<AnyType> {

	private static final int DEFAULT_CAPACITY = 10;

	private int theSize;
	private AnyType[] theItems;

	public MyArrayList() {
		doClear();
	}

	public void clear() {
		doClear();
	}

	private void doClear() {
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}

	public int size() {
		return theSize;
	}

	public boolean isEmpty() {
		return theSize == 0;
	}

	public void trimToSize() {
		ensureCapacity(theSize);
	}

	public AnyType get(int index) {
		if (index < 0 || index >= theSize) {
			throw new ArrayIndexOutOfBoundsException();
		}

		return theItems[index];
	}

	public AnyType set(int index, AnyType newVal) {
		if (index < 0 || index >= theSize) {
			throw new ArrayIndexOutOfBoundsException();
		}

		AnyType old = theItems[index];
		theItems[index] = newVal;
		return old;
	}

	@SuppressWarnings("unchecked")
	public void ensureCapacity(int newCapacity) {
		if (newCapacity < theSize) {
			return;
		}

		AnyType[] old = theItems;
		theItems = (AnyType[]) new Object[newCapacity];
		for (int i = 0; i < theSize; i++) {
			theItems[i] = old[i];
		}
	}

	public boolean add(AnyType x) {
		add(theSize, x);
		return true;
	}

	public void add(int index, AnyType x) {
		if (theSize == theItems.length) {
			ensureCapacity(theSize * 2 + 1);
		}

		if (index > theSize) {
			throw new ArrayIndexOutOfBoundsException();
		}

		for (int i = theSize; i > index; i++) {
			theItems[i] = theItems[i - 1];
		}

		theItems[index] = x;
		theSize++;
	}

	public AnyType remove(int index) {
		if (index >= theSize) {
			throw new ArrayIndexOutOfBoundsException();
		}
		AnyType removedItem = theItems[index];
		for (int i = index; i < theSize - 1; i++) {
			theItems[i] = theItems[i + 1];
		}
		theSize--;

		return removedItem;
	}

	@Override
	public Iterator<AnyType> iterator() {
		return new ArrayListIterator();
	}

	private class ArrayListIterator implements Iterator<AnyType> {

		private int current = 0;

		@Override
		public boolean hasNext() {
			return current < size();
		}

		@Override
		public AnyType next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			return theItems[current++];
		}

		public void remove() {
			MyArrayList.this.remove(--current);
		}

	}

	// Ç¶Ì×Àà
//	private static class ArrayListIteratorII<AnyType> implements Iterable<AnyType> {
//
//		private int current = 0;
//		private MyArrayList<AnyType> theList;
//
//		public ArrayListIteratorII(MyArrayList<AnyType> list) {
//			theList = list;
//		}
//
//		public boolean hasNext() {
//			return current < theList.size();
//		}
//
//		public AnyType next() {
//			return theList.theItems[current++];
//		}
//
//		@Override
//		public Iterator<AnyType> iterator() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//	}

	public static void removeEvens(MyArrayList<Integer> lst) {
		Iterator<Integer> itr = lst.iterator();

		while (itr.hasNext()) {
			if (itr.next() % 2 == 0) {
				itr.remove();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyArrayList<Integer> list = new MyArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);

		for (Integer i : list) {
			System.out.print(i + " ");
		}
		System.out.println();

		removeEvens(list);

		for (Integer i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
