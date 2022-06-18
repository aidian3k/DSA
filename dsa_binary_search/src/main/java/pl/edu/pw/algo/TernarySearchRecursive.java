package pl.edu.pw.algo;

import pl.edu.pw.algo.Interfaces.SearcherRecursive;

public class TernarySearchRecursive implements SearcherRecursive {
    @Override
    public int searchRecursive(int[] arr, int left, int right, int target) {

        if(left > right || arr == null){
            return -1;
        }

        int mid1 = left + (right-left)/3;
        int mid2 = right - (right-left)/3;

        if(arr[mid1]==target){
            return mid1;
        } else if(arr[mid2]==target){
            return mid2;
        }

        if(arr[mid1] > target){
            return searchRecursive(arr,left,mid1 - 1,target);
        } else if(arr[mid2] < target) {
            return searchRecursive(arr,mid2 + 1, right, target);
        } else {
            return searchRecursive(arr, mid1+1, mid2-1, target);
        }
    }
}
