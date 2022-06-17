package pl.edu.pw.algo;

public class BinarySearch implements SearcherIterative {

    @Override
    public int binarySearch(int[] arr, int target) {

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
