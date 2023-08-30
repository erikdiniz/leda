package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		//TODO
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	private int buscaBinaria(Integer[] array,int ini, int fim, int num){
		int meio = (ini+fim)/2;
		// procura o floor aqui dentro

		if (array[meio] == num){
			return num;
		} else if (num < array[meio]){
			return buscaBinaria(array, ini, meio-1, num);
		} else if (num > array[meio]){
			return buscaBinaria(array, meio+1, fim, num);
		} else {
			return array[meio];
		}
	}

	private void quickSort(Integer[] array, int ini, int fim){
		if (ini < fim){
			int indexPivot = particiona(array, ini, fim);

			quickSort(array, ini, indexPivot-1);
			quickSort(array, indexPivot, fim);
		}
	}
	
	private int particiona(Integer[] array, int ini, int fim){
		int pivot = array[ini];
		int i = ini;

		for (int j = ini+1; j <= fim; j++){
			if (array[j] <= pivot){
				i += 1;
				Util.swap(array, i, j);
			}
		}
		Util.swap(array, pivot, i);

		return i;
	}

}
