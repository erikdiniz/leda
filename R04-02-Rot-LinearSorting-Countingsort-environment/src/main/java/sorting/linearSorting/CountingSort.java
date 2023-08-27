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
		if ((array != null) && (leftIndex > -1) && (leftIndex < rightIndex) && (rightIndex < array.length)){
			int k = encontraMaior(array, leftIndex, rightIndex);
			int[] frequencia = new int[k+1];

			for (int i = leftIndex; i <= rightIndex; i++){
				frequencia[array[i]] += 1;
			}

			for (int i = 1; i < frequencia.length; i++){
				frequencia[i] += frequencia[i-1];
			}

			Integer[] helper = array.clone();

			for (int i = rightIndex; i >= leftIndex; i--){
				array[frequencia[helper[i]]-1] = helper[i];
				frequencia[helper[i]] -= 1;
			}
		}
	}

	private int encontraMaior(Integer[] array, int ini, int fim){
		int maior = array[ini];

		for (int i = ini+1; i <= fim; i++){
			if (array[i] > maior)
				maior = array[i];
		}
		return maior;
	}
}
