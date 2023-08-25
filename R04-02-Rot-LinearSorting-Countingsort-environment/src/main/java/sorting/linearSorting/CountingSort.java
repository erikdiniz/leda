package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if ((array != null) && (leftIndex >= 0) && (leftIndex < rightIndex)){
			int k = encontraMaior(array, leftIndex, rightIndex);
			int[] frequencia = new int[k]; 

			for (int i = leftIndex; i < frequencia.length; i++){
				frequencia[array[i]-1] += 1;
			}

			for (int i = 0; i < frequencia.length-1; i++){
				frequencia[i+1] += frequencia[i];
			}

			Integer[] helper = array.clone();

			for (int i = leftIndex; i <= rightIndex; i++){
				array[frequencia[helper[i]-1]-1] = helper[i];
			}
		}
	}

	private int encontraMaior(Integer[] array, int ini, int fim){
		int maior = array[ini];
		for (int i = ini+1; i <= fim; i++){
			if (maior < array[i])
				maior = array[i];
		}
		return maior;
	}

}
