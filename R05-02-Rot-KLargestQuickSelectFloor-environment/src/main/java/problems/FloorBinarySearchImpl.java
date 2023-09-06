package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		quickSort(array, 0, array.length-1);
		int floor = buscaBinaria(array, 0, array.length-1, x);

		return floor;
	}

	private int buscaBinaria(Integer[] array,int ini, int fim, int num){
		int meio = (ini + fim)/2;
		
		if ((array[meio] == num) || (array[meio+1] == num)){
			return array[meio];
		} else if (num >= array[fim]){
			return array[fim];			
		} else if (num < array[meio]){
			return buscaBinaria(array, ini, meio-1, num);
		} else {
			return buscaBinaria(array, meio+1, fim, num);
		}
	}	


	private void quickSort(Integer[] array, int ini, int fim){
		if (ini < fim){
			int indexPivot = particiona(array, ini, fim);

			quickSort(array, ini, indexPivot-1);
			quickSort(array, indexPivot+1, fim);
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
		Util.swap(array, ini, i);
		return i;
	}
}
