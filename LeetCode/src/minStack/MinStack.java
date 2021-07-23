package minStack;

import java.util.Stack;

public class MinStack {

	Stack<Integer> st = new Stack<Integer>();
	Stack<Integer> min = new Stack<Integer>();

	public MinStack() {

	}

	public void push(int x) {
		st.push(x);
		if (min.isEmpty() || x <= min.lastElement()) {
			min.push(x);
		}
	}

	public void pop() {
		int pop=st.pop();
		if (pop==min.lastElement()) {
			min.pop();
		}
	}

	public int top() {
		return st.lastElement();
	}

	public int getMin() {
		
		return min.lastElement();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack mst=new MinStack();
		mst.push(0);
		mst.push(1);
		mst.push(0);
		mst.getMin();
		mst.pop();
		mst.getMin();		
		
		
	}

}
