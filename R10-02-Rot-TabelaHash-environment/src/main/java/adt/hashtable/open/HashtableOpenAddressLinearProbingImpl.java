package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (element != null){
			int probing = 0;
			boolean add = false;

			if (super.size()/super.capacity() >= 0.75){
				resize();
			}

			while (probing < super.capacity() && !add){
				int position = getIndexHash(element, probing);
				
				if (this.table[position] == null){
					this.table[position] = element;
					add = true;
				} else if (this.table[position].equals(element))
					add = true;				
				else {
					probing += 1;
					super.COLLISIONS += 1;
				}
			}
			super.elements += 1;
		}
	}

	@Override
	public void remove(T element) {
		if (element != null){
			int probing = 0;
			boolean remove = false;
			
			while (probing < super.capacity() && !remove){
				int position = getIndexHash(element, probing);

				if (this.table[position].equals(element)){
					this.table[position] = super.deletedElement;
					remove = true;
					super.elements -= 1;
				} else if (super.deletedElement.equals(this.table[position]))
					probing += 1;
				else 
					remove = true;
			}
		}
	}

	@Override
	public T search(T element) {
		int index = indexOf(element);
		T out = null;

		if (index != -1)
			out = (T) this.table[index];
		
		return out;
	}

	@Override
	public int indexOf(T element) {
		int index = -1;

		if (element != null){
			int probing = 0;
			boolean found = false;

			while (probing < super.capacity() && !found){
				int position = getIndexHash(element, probing);

				if (this.table[position] == null)
					found = true;				
				else if (this.table[position].equals(element)){
					index = position;
					found = true;
				} else
					probing += 1;
			}
		}
		return index;
	}

	private int getIndexHash(T element, int probing){
		return ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probing) % super.capacity();
	}

	private void resize(){
		Object[] newTable = new Object[super.capacity()*2];

		for (int i = 0; i < super.capacity(); i++){
			if (super.table[i] != null){
				insert(newTable, (T) super.table[i]);
			}
		}
		this.table = newTable;
	}

	private void insert(Object[] table, T element){
		if (element != null){
			int probing = 0;
			boolean add = false;
			

			while (probing < super.capacity() && !add){
				int position = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probing) % table.length;
				
				if (this.table[position] != null || !super.deletedElement.equals(this.table[position]))
					probing += 1;
				else { 
					this.table[position] = element;
					add = true;
				}
			}
			super.elements += 1;
		}
	}
}
