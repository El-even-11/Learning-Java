package myBinarySearchTree;

import java.nio.BufferUnderflowException;

public class MyBinarySearchTree<AnyType extends Comparable<? super AnyType>> {

	private BinaryNode<AnyType> root;

	private static class BinaryNode<AnyType> {

		public BinaryNode(AnyType val) {
			this.val = val;
		}

		@SuppressWarnings("unused")
		public BinaryNode(AnyType val, BinaryNode<AnyType> left, BinaryNode<AnyType> right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

		AnyType val;
		BinaryNode<AnyType> left;
		BinaryNode<AnyType> right;
	}

	public MyBinarySearchTree() {
		root = null;
	}

	public void clear() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public boolean contains(AnyType x) {
		return contains(x, root);
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

	public void insert(AnyType x) {
		root = insert(x, root);
	}

	public void remove(AnyType x) {
		root = remove(x, root);
	}

	public void printTree() {
		inorderPrint(root);
		System.out.println();
	}

	private boolean contains(AnyType x, BinaryNode<AnyType> cur) {
		if (cur == null) {
			return false;
		}

		int result = x.compareTo(cur.val);

		if (result == 0) {
			return true;
		} else if (result < 0) {
			return contains(x, cur.left);
		} else {
			return contains(x, cur.right);
		}
	}

	// tail recursion can be optimized to loop.
	private BinaryNode<AnyType> findMin(BinaryNode<AnyType> cur) {
		if (cur == null) {
			return null;
		}

		if (cur.left == null) {
			return cur;
		}

		return findMin(cur.left);
	}

	// tail recursion can be optimized to loop.
	private BinaryNode<AnyType> findMax(BinaryNode<AnyType> cur) {
		if (cur == null) {
			return null;
		}

		if (cur.right == null) {
			return cur;
		}

		return findMax(cur.right);
	}

	private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> cur) {
		if (cur == null) {
			return new BinaryNode<AnyType>(x);
		}

		int result = x.compareTo(cur.val);
		if (result < 0) {
			cur.left = insert(x, cur.left);
		} else if (result > 0) {
			cur.right = insert(x, cur.right);
		} else {
			// Duplicate.
		}

		return cur;
	}

	private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> cur) {

		if (cur == null) {
			return null;
		}

		int result = x.compareTo(cur.val);
		if (result < 0) {
			cur.left = remove(x, cur.left);
		} else if (result > 0) {
			cur.right = remove(x, cur.right);
		} else {
			if (cur.left == null || cur.right == null) {
				cur = cur.left == null ? cur.right : cur.left;
			} else {
				cur.val = findMin(cur.right).val;
				cur.right = remove(cur.val, cur.right);
			}
		}

		return cur;
	}

	private void inorderPrint(BinaryNode<AnyType> root) {
		if (root == null) {
			return;
		}

		inorderPrint(root.left);

		System.out.print(root.val.toString() + " ");

		inorderPrint(root.right);
	}

	public static void main(String[] args) {
		MyBinarySearchTree<Integer> t = new MyBinarySearchTree<>( );
        final int NUMS = 4000;
        final int GAP  =   37;

        System.out.println( "Checking... (no more output means success)" );

        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
            t.insert( i );

        for( int i = 1; i < NUMS; i+= 2 )
            t.remove( i );

        if( NUMS < 40 )
            t.printTree( );
        if( t.findMin( ) != 2 || t.findMax( ) != NUMS - 2 )
            System.out.println( "FindMin or FindMax error!" );

        for( int i = 2; i < NUMS; i+=2 )
             if( !t.contains( i ) )
                 System.out.println( "Find error1!" );

        for( int i = 1; i < NUMS; i+=2 )
        {
            if( t.contains( i ) )
                System.out.println( "Find error2!" );
        }
	}

}
