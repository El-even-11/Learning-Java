package myAvlTree;

import java.nio.BufferUnderflowException;

public class MyAvlTree<AnyType extends Comparable<? super AnyType>> {

	AvlNode<AnyType> root;

	public MyAvlTree() {
		this.root = null;
	}

	private static class AvlNode<AnyType> {
		AnyType val;
		AvlNode<AnyType> left;
		AvlNode<AnyType> right;
		int height;

		public AvlNode(AnyType val) {
			this.val = val;
			this.height = 0;
		}

		@SuppressWarnings("unused")
		public AvlNode(AnyType val, AvlNode<AnyType> left, AvlNode<AnyType> right) {
			this.val = val;
			this.left = left;
			this.right = right;
			this.height = 0;
		}
	}

	private int height(AvlNode<AnyType> t) {
		return t == null ? -1 : t.height;
	}

	public void insert(AnyType x) {
		root = insert(x, root);
	}

	public void remove(AnyType x) {
		root = remove(x, root);
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void makeEmpty() {
		root = null;
	}

	public AnyType findMin() {
		if (isEmpty()) {
			throw new BufferUnderflowException();
		}

		return findMin(root).val;
	}

	public AnyType findMax() {
		if (isEmpty()) {
			throw new BufferUnderflowException();
		}

		return findMax(root).val;
	}

	public boolean contains(AnyType x) {
		return contains(x, root);
	}

	private boolean contains(AnyType x, AvlNode<AnyType> cur) {
		if (cur == null) {
			return false;
		}

		int compareResult = x.compareTo(cur.val);

		if (compareResult < 0) {
			return contains(x, cur.left);
		} else if (compareResult > 0) {
			return contains(x, cur.right);
		} else {
			return true;
		}
	}

	private AvlNode<AnyType> findMin(AvlNode<AnyType> cur) {
		if (cur == null) {
			return null;
		}

		if (cur.left == null) {
			return cur;
		}

		return findMin(cur.left);
	}

	private AvlNode<AnyType> findMax(AvlNode<AnyType> cur) {
		if (cur == null) {
			return null;
		}

		if (cur.right == null) {
			return cur;
		}

		return findMax(cur.right);
	}

	private AvlNode<AnyType> insert(AnyType x, AvlNode<AnyType> cur) {
		if (cur == null) {
			return new AvlNode<AnyType>(x);
		}

		int compareResult = x.compareTo(cur.val);
		if (compareResult < 0) {
			cur.left = insert(x, cur.left);
		} else if (compareResult > 0) {
			cur.right = insert(x, cur.right);
		} else {
			// Duplicate
		}

		return balance(cur);
	}

	private AvlNode<AnyType> remove(AnyType x, AvlNode<AnyType> cur) {

		if (cur == null) {
			return null;
		}

		int compareResult = x.compareTo(cur.val);
		if (compareResult < 0) {
			cur.left = remove(x, cur.left);
		} else if (compareResult > 0) {
			cur.right = remove(x, cur.right);
		} else {
			if (cur.left == null || cur.right == null) {
				cur = cur.left == null ? cur.right : cur.left;
			} else {
				cur.val = findMin(cur.right).val;
				cur.right = remove(cur.val, cur.right);
			}
		}

		return balance(cur);
	}

	private static final int ALLOWED_IMBALANCE = 1;

	private AvlNode<AnyType> balance(AvlNode<AnyType> cur) {
		if (cur == null) {
			return null;
		}

		if (height(cur.left) - height(cur.right) > ALLOWED_IMBALANCE) {
			if (height(cur.left.left) >= height(cur.left.right)) {
				cur = rotateWithLeftChild(cur);
			} else {
				cur = doubleWithLeftChild(cur);
			}
		} else if (height(cur.right) - height(cur.left) > ALLOWED_IMBALANCE) {
			if (height(cur.right.right) >= height(cur.right.left)) {
				cur = rotateWithRightChild(cur);
			} else {
				cur = doubleWithRightChild(cur);
			}
		}

		cur.height = Math.max(height(cur.left), height(cur.right)) + 1;

		return cur;
	}

	private AvlNode<AnyType> rotateWithLeftChild(AvlNode<AnyType> k2) {

		AvlNode<AnyType> k1 = k2.left;

		k2.left = k1.right;
		k1.right = k2;

		k1.height = Math.max(height(k1.left), height(k1.right)) + 1; // k1.left may be null
		k2.height = Math.max(height(k2.left), height(k2.right)) + 1; // Do not use k1.left.height

		return k1;
	}

	private AvlNode<AnyType> rotateWithRightChild(AvlNode<AnyType> k2) {

		AvlNode<AnyType> k1 = k2.right;

		k2.right = k1.left;
		k1.left = k2;

		k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
		k2.height = Math.max(height(k2.left), height(k2.right)) + 1;

		return k1;
	}

	private AvlNode<AnyType> doubleWithLeftChild(AvlNode<AnyType> k3) {

		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);

	}

	private AvlNode<AnyType> doubleWithRightChild(AvlNode<AnyType> k3) {

		k3.right = rotateWithLeftChild(k3.right);
		return rotateWithRightChild(k3);
	}

	// part for testing

	public void checkBalance() {
		checkBalance(root);
	}

	public void printTree() {
		printTree(root);
	}

	private int checkBalance(AvlNode<AnyType> t) {
		if (t == null)
			return -1;

		if (t != null) {
			int hl = checkBalance(t.left);
			int hr = checkBalance(t.right);
			if (Math.abs(height(t.left) - height(t.right)) > 1 || height(t.left) != hl || height(t.right) != hr)
				System.out.println("OOPS!!");
		}

		return height(t);
	}

	private void printTree(AvlNode<AnyType> t) {
		if (t != null) {
			printTree(t.left);
			System.out.println(t.val);
			printTree(t.right);
		}
	}

	public static void main(String[] args) {
		MyAvlTree<Integer> t = new MyAvlTree<>();
		final int SMALL = 40;
		final int NUMS = 1000000; // must be even
		final int GAP = 37;

		System.out.println("Checking... (no more output means success)");

		for (int i = GAP; i != 0; i = (i + GAP) % NUMS) {
			// System.out.println( "INSERT: " + i );
			t.insert(i);
			//if (NUMS < SMALL)
				t.checkBalance();
		}

		for (int i = 1; i < NUMS; i += 2) {
			// System.out.println( "REMOVE: " + i );
			t.remove(i);
			//if (NUMS < SMALL)
				t.checkBalance();
		}
		if (NUMS < SMALL)
			t.printTree();
		if (t.findMin() != 2 || t.findMax() != NUMS - 2)
			System.out.println("FindMin or FindMax error!");

		for (int i = 2; i < NUMS; i += 2)
			if (!t.contains(i))
				System.out.println("Find error1!");

		for (int i = 1; i < NUMS; i += 2) {
			if (t.contains(i))
				System.out.println("Find error2!");
		}
	}
}
