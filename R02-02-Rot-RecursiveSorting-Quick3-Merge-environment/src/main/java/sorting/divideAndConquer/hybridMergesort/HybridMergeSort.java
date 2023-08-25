package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if ((array != null) && (leftIndex >= 0) && (rightIndex < array.length)){
			MERGESORT_APPLICATIONS = 0;
			INSERTIONSORT_APPLICATIONS = 0;

			if (array.length <= SIZE_LIMIT){
				insertionSort(array, leftIndex, rightIndex);
			} else {
				mergeSort(array, leftIndex, rightIndex);
			}
		}
	}

	private void insertionSort(T[] array, int ini, int fim){
		if (ini < fim) {
            insertionSort(array, ini, fim - 1);
			INSERTIONSORT_APPLICATIONS++;

            T key = array[fim];
            int j = fim - 1;

            while (j >= ini && array[j].compareTo(key) > 0) {
                Util.swap(array, j, j + 1);
                j--;
            }
			
            array[j+1] = key;
        }
	}

	private void merge(T[] array, int ini, int meio, int fim){
		T[] aux = (T[]) new Comparable[array.length];
		for (int i = 0; i < array.length; i++){
			aux[i] = array [i];
		}

		int i = ini;
		int j = meio+1;
		int k = ini;

		while (i <= meio && j <= fim){
			if(aux[i].compareTo(aux[j])<0){
				array[k++] = aux[i++];
			} else {
				array[k++] = aux[j++];
			}
		}

		while(i <= meio){
			array[k++] = aux[i++];
		}

		while(j <= fim){
			array[k++] = array[j++];
		}
	}

	public void mergeSort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex){
			int meio = (leftIndex+rightIndex)/2;
			mergeSort(array, leftIndex, meio);
			mergeSort(array, meio+1, rightIndex);
			merge(array, leftIndex, meio, rightIndex);
			MERGESORT_APPLICATIONS += 2;
		}
	}
}
