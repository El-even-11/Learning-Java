package implementQueueUsingStacks;

import java.util.Stack;

public class MyQueue {

	Stack<Integer> main = new Stack<>();
	Stack<Integer> help = new Stack<>();

	/** Initialize your data structure here. */
	public MyQueue() {

	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		while (!main.isEmpty()) {
			help.push(main.pop());
		}
		
		help.push(x);
		
		while (!help.isEmpty()) {
			main.push(help.pop());
		}
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		return main.pop();
	}

	/** Get the front element. */
	public int peek() {
		return main.lastElement();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return main.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
