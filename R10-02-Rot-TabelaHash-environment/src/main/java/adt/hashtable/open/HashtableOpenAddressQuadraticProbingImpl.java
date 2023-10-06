package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (element != null){
			int probing = 0;
			boolean add = false;

			while (probing < this.capacity() && !add){
				int position = getIndexHash(element, probing);
				
				if (this.table[position] == null){
					this.table[position] = element;
					add = true;
				} else if (this.table[position].equals(element))
					add = true;				
				else {
					probing += 1;
					this.COLLISIONS += 1;
				}
			}
			this.elements += 1;
		}
	}

	@Override
	public void remove(T element) {
		if (element != null){
			int probing = 0;
			boolean remove = false;
			
			while (probing < this.capacity() && !remove){
				int position = getIndexHash(element, probing);

				if (this.table[position] == null)
					remove = true;
				else if (this.table[position].equals(element)){
					this.table[position] = this.deletedElement;
					remove = true;
					this.elements -= 1;
				} else 
					probing += 1;
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
		return ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, probing);
	}
}
