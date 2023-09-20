package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.getData() == null;
	}

	@Override
	public int size() {
		if (isEmpty())
			return 0;
		
		SingleLinkedListNode<T> element = head.getNext();
		int cont  = 1;

		while (element != null){
			cont += 1;
			element = element.getNext();
		}

		return cont;
	}

	@Override
	public T search(T element) {
		if (isEmpty() || element == null)
			return null;

		if (element == head.getData())
			return element;
	
		SingleLinkedListNode<T> aux = head.getNext();

		while (aux != null){
			if (aux.getData() == element) {
				return element;
			}

			aux = aux.getNext();
		}
		
		return null;
	}

	@Override
	public void insert(T element) {
		if (element != null){
			SingleLinkedListNode node = new SingleLinkedListNode<T>(element, null);

			if (isEmpty()) {
				this.head = node;

			} else {
				SingleLinkedListNode aux = this.head;

				while (aux.getNext() != null){
					aux = aux.getNext();
				}

				aux.setNext(node);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (!isEmpty() && element != null){
			if (element == head.getData()) {
				this.head = head.getNext();
			
			} else {
				SingleLinkedListNode<T> prev = this.head;

				while (prev.getNext() != null){
					if (prev.getNext().getData() == element){
						SingleLinkedListNode<T> aux = prev.getNext();
						prev.setNext(aux.getNext());

					} else 
						prev = prev.getNext();
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[size()];

		if (isEmpty())
			return array;

		int index = 0;

		SingleLinkedListNode node = this.head;

		while (node != null) {
			array[index] = (T) node.getData();
			index += 1;
			node = node.getNext();
		}

		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}
}
