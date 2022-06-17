package pl.edu.pw.algo;

import pl.edu.pw.algo.Interfaces.SortingInterface;

public class QuickSort implements SortingInterface {
    @Override
    public void sort(double[] arr) {
        if(arr == null){
            return;
        }

        quicksort(arr,0,arr.length-1);
    }

    private void quicksort(double [] arr, int lowIndex, int highIndex){

        if(lowIndex >= highIndex){
            return;
        }

        double pivot = arr[highIndex];
        int leftPointer = partition(arr, lowIndex, highIndex, pivot);

        quicksort(arr,0,leftPointer-1);
        quicksort(arr,leftPointer+1,highIndex);

    }

    private int partition(double [] arr, int lowIndex, int highIndex, double pivot){
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while(rightPointer > leftPointer){

            while(arr[leftPointer] <= pivot && leftPointer < rightPointer){
                leftPointer++;
            }

            while(arr[rightPointer] >= pivot && leftPointer < rightPointer){
                rightPointer--;
            }

            swap(arr,leftPointer,rightPointer);
        }

        swap(arr,leftPointer,highIndex);
        return leftPointer;
    }

    private void swap(double [] arr, int firstIndex, int secondIndex){
        double temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
