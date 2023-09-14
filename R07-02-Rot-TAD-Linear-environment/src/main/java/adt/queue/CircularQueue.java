package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()){
			throw new QueueOverflowException();
		} else if (isEmpty()){
			this.head = 0;
			this.tail = 0;
			this.array[head] = element;	
		} else {
			tail = (tail + 1) % array.length;
			this.array[tail] = element;
		}
		this.elements += 1;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()){
			throw new QueueUnderflowException();
		}
		
		T element = array[head];
		
		if (head == tail){
			this.head = -1;
			this.tail = -1;
			this.elements = 0;
		} else {
			head = (head+1) % array.length;
		}
		this.elements -= 1;
		return element;
	}

	@Override
	public T head() {
		if (isEmpty()){
			return null;
		}
		return this.array[head];
	}

	@Override
	public boolean isEmpty() {
		return this.tail == -1 && this.head == -1;
	}

	@Override
	public boolean isFull() {
		return this.elements == this.array.length - 1;
	}

}
