package problems;

import java.util.PriorityQueue;

public class ProfitMaximizationImpl implements ProfitMaximization{  
    /**
    * Implementacao de heap sobrejacente. PriorityQueue é uma min-heap que 
    * pode trabalhar com um comparator interno e permite elementos duplicados
    *
    * O método poll() é semelhante a extrair o root da PriorityQueue
    * O método add(elem) insere in elemento na heap
    */
    private PriorityQueue<Integer> heap;
   
    public ProfitMaximizationImpl(PriorityQueue<Integer> heap) {
        this.heap = new PriorityQueue<>((i1, i2) -> i2 -i1);
    }

    public int maximize(Integer[] array, int amount){
        for (int i = 0; i < array.length; i++){
            this.heap.add(array[i]);
        }

        int vendas = 0;

        if (array.length > 0 && array != null){
            for (int i = 0; i < amount; i++){
                int max = this.heap.poll();
                this.heap.add(max-1);
                if (max > 0)
                    vendas += max;
            }
        }

        return vendas;
    }
}
