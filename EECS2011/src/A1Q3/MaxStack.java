package A1Q3;

import java.util.*;

/**
 * Specializes the stack data structure for comparable elements, and provides a
 * method for determining the maximum element on the stack in O(1) time.
 * 
 * @author jameselder
 */
public class MaxStack<E extends Comparable> extends Stack<E> {

	private Stack<E> maxStack;
	private Stack<E> subStack; // for maxStack to track of max

	public MaxStack() {
		maxStack = new Stack<>();
		subStack = new Stack<>();
	}

	/* must run in O(1) time */
	public E push(E element) {
		maxStack.push(element);

		if (subStack.isEmpty()) {	// 1 2 3 4 5  1 3 4 2 5
			subStack.push(element); // 1 2 3 4 5  1 3
		} else if (subStack.peek().compareTo(maxStack.peek()) <= 0) {
			subStack.push(maxStack.peek());
		} else {
			subStack.push(subStack.peek());
		}

		return element;
	}

	/* @exception EmptyStackException if this stack is empty. */
	/* must run in O(1) time */
	public synchronized E pop() {
		if (maxStack.isEmpty()) {
			throw new EmptyStackException();
		}
		subStack.pop();
		return maxStack.pop();
	}

	/* Returns the maximum value currenctly on the stack. */
	/* @exception EmptyStackException if this stack is empty. */
	/* must run in O(1) time */
	public synchronized E max() {
		if (maxStack.isEmpty()) {
			throw new EmptyStackException();
		}
		
		return subStack.peek();
	}
}
