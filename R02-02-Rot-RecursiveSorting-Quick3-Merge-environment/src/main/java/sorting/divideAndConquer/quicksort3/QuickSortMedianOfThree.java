package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if ((array != null) && (leftIndex >= 0) && (rightIndex < array.length)){
			if (leftIndex < rightIndex) {
    	    	int pivotIndex = medianOfThree(array, leftIndex, rightIndex);
     	    	int pivotNewIndex = particiona(array, leftIndex, rightIndex, pivotIndex);
            
       	  		sort(array, leftIndex, pivotNewIndex - 1);
        	    sort(array, pivotNewIndex + 1, rightIndex);
			}
		}
	}

	private int medianOfThree(T[] array, int ini, int fim) {
        int meio = (ini + fim) / 2;
        
        if (array[ini].compareTo(array[meio]) > 0) {
            Util.swap(array, ini, meio);
        }
        
        if (array[ini].compareTo(array[fim]) > 0) {
            Util.swap(array, ini, fim);
        }
        
        if (array[meio].compareTo(array[fim]) > 0) {
            Util.swap(array, meio, fim);
        }
        
        Util.swap(array, meio, fim - 1);
        
        return fim - 1;
    }

	private int particiona(T[] array, int ini, int fim, int pivotIndex){
		T pivot = array[pivotIndex];
		int i = ini;
		for(int j=ini+1; j <= fim ; j++){
			if(array[j].compareTo(pivot) < 0){
				i+=1;
				Util.swap(array,i, j);
			}
		}
		Util.swap(array, ini, i);
		return i;
	}

}
