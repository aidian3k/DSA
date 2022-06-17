package pl.edu.pw.algo;

import pl.edu.pw.algo.Interfaces.SortingInterface;

public class HeapSort implements SortingInterface {

    private Heap heap;

    public HeapSort(){
        heap = new Heap();
    }

    @Override
    public void sort(double[] arr) {
        if( arr == null){
            throw new IllegalArgumentException();
        }

        for(double element : arr){
            heap.put(element);
        }

        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = heap.pop();
        }

    }
}
