package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insertFirst(T element) {
		if (element != null){

			DoubleLinkedListNode node = new DoubleLinkedListNode<T>(element, null, null);

			if (isEmpty()){
				setHead(node);
				setLast(node);
			} else {
				node.setNext(head);
				((DoubleLinkedListNode<T>) head).setPrevious(node);
				setHead(node);
			}
		}
	}

	@Override
	public void removeFirst() {
		if (!isEmpty()){
			if (this.head.equals(this.last)){
				setHead(null);
				setLast(null);
			} else {
				setHead(head.getNext());
				((DoubleLinkedListNode<T>) head).setPrevious(null);
			}
		}
	}

	@Override
	public void removeLast() {
		if (!isEmpty()){
			if (this.head.equals(this.last)){
				setHead(null);
				setLast(null);
			} else {
				setLast(last.previous);
				last.setNext(null);
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
