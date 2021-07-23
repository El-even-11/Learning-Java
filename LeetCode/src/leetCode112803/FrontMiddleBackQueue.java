package leetCode112803;

import java.util.ArrayList;

public class FrontMiddleBackQueue {
	
	ArrayList<Integer> myQueue=new ArrayList<>();
	
	public FrontMiddleBackQueue() {
		
	}

	public void pushFront(int val) {
		myQueue.add(0, val);
	}

	public void pushMiddle(int val) {
		myQueue.add(myQueue.size()/2, val);
	}

	public void pushBack(int val) {
		myQueue.add(val);
	}

	public int popFront() {
		if (myQueue.size()==0) {
			return -1;
		}
		int front=myQueue.get(0);
		myQueue.remove(0);
		return front;
	}

	public int popMiddle() {
		if (myQueue.size()==0) {
			return -1;
		}
		int middle=myQueue.get((myQueue.size()-1)/2);
		myQueue.remove(myQueue.size()/2);
		return middle;
	}

	public int popBack() {
		if (myQueue.size()==0) {
			return -1;
		}
		int back=myQueue.get(myQueue.size()-1);
		myQueue.remove(myQueue.size()-1);
		return back;
	}
	
	public static void main(String[] args) {
		FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
		 obj.pushFront(1);
		 obj.pushBack(2);
		 obj.pushMiddle(3);
		 obj.pushMiddle(4);
		 
		 int param_4 = obj.popFront();
		 int param_5 = obj.popMiddle();
		 int param_6 = obj.popMiddle();
		 int param_7 = obj.popBack();
		 
	}
}
