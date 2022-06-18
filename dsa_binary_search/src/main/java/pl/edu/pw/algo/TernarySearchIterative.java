package pl.edu.pw.algo;

import pl.edu.pw.algo.Interfaces.SearcherIterative;

public class TernarySearchIterative implements SearcherIterative {

    @Override
    public int searchIterative(int[] arr, int target) {

        if( arr == null){
            return -1;
        }

        int result = -1;
        int right = arr.length - 1;
        int left = 0;

        while(right >= left){
            int mid1 = left + (right-left)/3;
            int mid2 = right - (right-left)/3;

            if( arr[mid1]==target ){
                result = mid1;
                break;
            } else if( arr[mid2]==target ){
                result = mid2;
                break;
            }

            if( target < arr[mid1]){
                right = mid1 - 1;
            } else if (target > arr[mid2]){
                left = mid2 + 1;
            } else {
                left = mid1 + 1;
                right = mid2 - 1;
            }
        }

        return result;
    }
}
