import java.util.Arrays;

public class Sorting {

    public static int[] mergeSort(int[] arr) {
        // O(n log n), since recursion tree has log n levels (repeatedly splitting arr in half),
        // and n work done per level (merge)
        if (arr.length == 1) {
            return arr;
        }
        int midIndex = arr.length/2;
        int[] left = new int[midIndex];
        int[] right = new int[arr.length - midIndex];
        System.arraycopy(arr, 0, left, 0, left.length);
        System.arraycopy(arr, midIndex, right, 0, right.length);
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        // merge two sorted arrays
        int[] res = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int count = 0;
        while (count < res.length) {
            if (i >= arr1.length) { // if arr1 exhausted, go to arr1
                res[count] = arr2[j++];
            } else if (j >= arr2.length) { // if arr2 exhausted, go to arr1
                res[count] = arr1[i++];
            } else if (arr1[i] <= arr2[j]) {
                res[count] = arr1[i++];
            } else {
                res[count] = arr2[j++];
            }
            count++;
        }
        return res;
    }

    public static int[] selectionSort(int[] arr) {
        // find the min element from the unsorted subarray and move it to the end of the sorted subarray
        // worst case is O(n^2) if sorted in reverse

        // i marks the start of the unsorted subarray, so everything from 0 to i-1 is sorted.
        for (int i = 0; i < arr.length-1; i++) {
            int min = arr[i];
            int min_ind = i;
            for (int j = i+1; j < arr.length; j++) { // search unsorted subarray for the min
                if (arr[j] < min) {
                    min = arr[j];
                    min_ind = j;
                }
            }
            // swap the min with the first element of the unsorted array, which is now
            // the last element of the sorted array
            int temp = arr[i];
            arr[i] = min;
            arr[min_ind] = temp;


        }
        return arr;
    }

    public static int[] insertionSort(int[] arr) {
        // take an unsorted element i and insert it in order into the sorted subarray

        for (int i = 1; i < arr.length; i++) {
            int unsorted = arr[i];
            int j = i-1;
            while (j >= 0 && unsorted < arr[j]) { // keep moving unsorted down until it hits 0 or an element it's greater than
                arr[j+1] = arr[j]; // shift right to make room for unsorted
                j--;
            }
            arr[j+1] = unsorted; // j is either -1 or the element right before the correct spot (arr[j] <= unsorted)
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] left = new int[]{1,3,5,7,8,9};
        int[] right = new int[]{2,3,5,6,8,10};
        System.out.println(Arrays.toString(merge(left, right)));

        int[] arr1 = new int[]{5,3,2,7,6,10,9,8,1,4};
        System.out.println(Arrays.toString(mergeSort(arr1)));

        System.out.println(Arrays.toString(selectionSort(arr1)));

        int[] arr2 = new int[]{5,3,2,7,6,10,9,8,1,4};
        System.out.println(Arrays.toString(insertionSort(arr2)));
    }
}
