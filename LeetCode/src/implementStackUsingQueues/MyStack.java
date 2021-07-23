package implementStackUsingQueues;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

	Queue<Integer> main = new LinkedList<Integer>();
	Queue<Integer> help = new LinkedList<Integer>();

	/** Initialize your data structure here. */
	public MyStack() {
		
	}

	/** Push element x onto stack. */
	public void push(int x) {
		help.offer(x);
		while (!main.isEmpty()) {
			help.offer(main.poll());
		}
		
		while (!help.isEmpty()) {
			main.offer(help.poll());
		}
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		return main.poll();
	}

	/** Get the top element. */
	public int top() {
		return main.peek();
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return main.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
