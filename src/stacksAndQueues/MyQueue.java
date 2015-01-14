package stacksAndQueues;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

public class MyQueue<T> implements Queue<T>{
	Stack<T> headFirstStack;
	Stack<T> tailFirstStack;
	boolean isHeadFirst;

	public MyQueue() {
		headFirstStack = new Stack<T>();
		tailFirstStack = new Stack<T>();
		isHeadFirst = false;
	}
	
	public T poll() {
		if (!isHeadFirst) {
			toHeadFirst();
		}
		return headFirstStack.pop();
	}

	public boolean add(T item) {
		if (isHeadFirst) {
			toTailFirst();
		}
		return tailFirstStack.add(item);
	}

	public T peek() {
		if (!isHeadFirst) {
			toHeadFirst();
		}
		return headFirstStack.peek();
	}

	private void toHeadFirst() {
		while (!tailFirstStack.empty()) {
			T item = tailFirstStack.pop();
			headFirstStack.push(item);
		}
	}

	private void toTailFirst() {
		while (!headFirstStack.empty()) {
			T item = headFirstStack.pop();
			tailFirstStack.push(item);
		}
	}

	public boolean addAll(Collection<? extends T> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public T element() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean offer(T arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}
}
