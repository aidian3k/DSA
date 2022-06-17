package pl.edu.pw.algo;

import pl.edu.pw.algo.Interfaces.SortingInterface;

public class SelectionSort implements SortingInterface {

    @Override
    public void sort(double[] arr) {

        if(arr == null){
            throw new IllegalArgumentException();
        }

        int length = arr.length;

        for(int i = 0 ; i < length - 1 ; i++){
            int minElementIndex=i;

            for(int j = i+1 ; j < length; j++) {
                if(arr[minElementIndex] > arr[j]){
                    minElementIndex = j;
                }
            }

            double temp = arr[i];
            arr[i] = arr[minElementIndex];
            arr[minElementIndex] = temp;

        }
    }
}
