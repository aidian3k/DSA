package pl.edu.pw.algo;

import pl.edu.pw.algo.Interfaces.SearcherIterative;

public class BinarySearchIterative implements SearcherIterative {

    @Override
    public int searchIterative(int[] arr, int target) {

        int result = -1;

        if(arr == null ){
            return result;
        }

        int right = arr.length-1;
        int left = 0;

        while(right >= left ){
            int mid = left+ (right-left)/2;

            if(target > arr[mid]){
                left = mid +1;
            }

            else if(target < arr[mid]){
                right = mid-1;
            }

            else {
                result = mid;
                break;
            }
        }

        return result;
    }
}
