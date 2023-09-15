package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		try {
			this.stack1.push(element);
		} catch (StackOverflowException e) {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		try {
			while (!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}

			T element = stack2.pop();

			while (!stack2.isEmpty()){
				stack1.push(stack2.pop());
			}

			return element;	

		} catch (StackOverflowException | StackUnderflowException e){
			throw new QueueUnderflowException();
		}
	}

	@Override
	public T head() {
		if (stack1.isEmpty())
			return null;

		while (!stack1.isEmpty()){
			try {
				stack2.push(stack1.pop());
			} catch (StackOverflowException | StackUnderflowException e) {
				return null;
			}
		}

		T element = stack2.top();

		while (!stack2.isEmpty()){
			try {
				stack1.push(stack2.pop());
			} catch (StackOverflowException | StackUnderflowException e) {
				return null;
			}
		}

		return element;
	}

	@Override
	public boolean isEmpty() {
		return this.stack1.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.stack1.isFull();
	}
}
