package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if ((array != null) && (leftIndex > -1) && (leftIndex < rightIndex) && (rightIndex < array.length)){
			int k = encontraMaior(array, leftIndex, rightIndex);
			int menor = encontraMenor(array, leftIndex, rightIndex);
			int[] frequencia = new int[k-menor+1];

			for (int i = leftIndex; i <= rightIndex; i++){
				frequencia[array[i]-menor] += 1;
			}

			for (int i = 1; i < frequencia.length; i++){
				frequencia[i] += frequencia[i-1];
			}

			Integer[] helper = array.clone();

			for (int i = rightIndex; i >= leftIndex; i--){
				array[frequencia[helper[i]-menor]-1] = helper[i];
				frequencia[helper[i]-menor] -= 1;
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

	private int encontraMenor(Integer[] array, int ini, int fim){
		int menor = array[ini];

		for (int i = ini+1; i <= fim; i++){
			if (array[i] < menor)
				menor = array[i];
		}
		
		if (menor > 0) {
			return 0;
		} else {
			return menor;
		}
	}
}
