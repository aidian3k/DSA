package pl.edu.pw.algo;

import pl.edu.pw.algo.Interfaces.SortingInterface;

public class InsertionSort implements SortingInterface {

    @Override
    public void sort(double[] arr) {

        if(arr == null ){
            return;
        }

        int length = arr.length;

        for(int i = 1 ; i < length ; i++){
            double key = arr[i];
            int j = i-1;

            while(j>=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = key;
        }
    }
}

