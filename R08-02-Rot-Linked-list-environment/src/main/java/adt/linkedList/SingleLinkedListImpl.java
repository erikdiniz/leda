package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head == null;
	}

	@Override
	public int size() {
		SingleLinkedListNode<T> element = this.head;
		int cont  = 0;

		while (element != null){
			element = element.getNext();
			cont += 1;
		}

		return cont;
	}

	@Override
	public T search(T element) {
		if (element != null) {
			if (element.equals(head))
				return this.head;
			
			else {
				SingleLinkedListNode<T> node = this.head;
			}
		}

	}

	@Override
	public void insert(T element) {
		if (element != null){
			SingleLinkedListNode<T> aux = this.head;

			while (aux.getNext() != null){
				aux = aux.getNext();
			}

			SingleLinkedListNode<T> node = new SingleLinkedListNode<T>(element, null);
			aux.setNext(node);
		}
	}

	@Override
	public void remove(T element) {
		if (element != null){
			if (element.equals(head))
				this.head = head.getNext();
			else {
				SingleLinkedListNode<T> prev = this.head;

				while (!prev.getNext().equals(element)){
					prev = prev.getNext();
				}

				prev.setNext(prev.getNext().getNext());
			}
		}
		// usa o search aqui
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented!");
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
