package pl.edu.pw.algo;

import pl.edu.pw.algo.Interfaces.SortingInterface;

public class BubbleSort implements SortingInterface {
    @Override
    public void sort(double[] arr) {

        if(arr == null) {
            return;
        }

        int length = arr.length;

        for( int i = 0 ; i < length ; i++ ){
            for( int j = i+1 ; j < length ; j++){
                if(arr[i] > arr[j]){
                    double temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }
}
