package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (Util.indexValido(array, leftIndex, rightIndex)){
			for (int i = rightIndex; i > leftIndex; i--){
				int pos = i;
				for (int j = i-1; j > leftIndex-1; j--){
					if (array[pos].compareTo(array[j]) < 0){
						pos = j;
					}
				}
				Util.swap(array, i, pos);
			}
		}
	}
}
