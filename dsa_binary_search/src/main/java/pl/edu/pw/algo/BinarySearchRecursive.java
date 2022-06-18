package pl.edu.pw.algo;

import pl.edu.pw.algo.Interfaces.SearcherRecursive;

public class BinarySearchRecursive  implements SearcherRecursive {

    @Override
    public int searchRecursive(int[] arr, int left, int right, int target) {

        if( left > right || arr == null){
            return -1;
        }

        int mid = left + (right-left)/2;

        if(arr[mid]==target){
            return mid;
        } else if(arr[mid] > target) {
            return searchRecursive(arr, left,mid-1, target);
        } else {
            return searchRecursive(arr, mid+1, right, target);
        }
    }

}
