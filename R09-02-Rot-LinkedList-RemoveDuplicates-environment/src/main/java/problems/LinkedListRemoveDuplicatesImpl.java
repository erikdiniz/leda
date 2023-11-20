package problems;

import adt.linkedList.SingleLinkedListNode;

public class LinkedListRemoveDuplicatesImpl<T> implements LinkedListRemoveDuplicates<T>{

    /**
     * Restricoes extras:
     * - Você NÃO pode usar recursão
     * - Você pode criar métodos auxiliares se achar necessário, desde que sejam criados
     *   nesta classe
     */
    public void removeDuplicates(SingleLinkedListNode<T> node){
        if (node != null && !node.isNIL()){
            while (node != null){
                SingleLinkedListNode aux = node.getNext();

                while(aux != null) {
                    if (node.getData().equals(aux.getData())){
                        node.setNext(aux.getNext());
                    }
                    aux = aux.getNext();
                }
                node = node.getNext();
            }
        }
    }
}

