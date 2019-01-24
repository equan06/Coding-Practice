public class MergeSort {
    public static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        int[] left = copy(arr, 0, n/2);
        int[] right = copy(arr, n/2, n);
        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);
    }

    public static int[] copy(int[] A, int start, int end) {
        // return copied subarray of A from index start to index end-1
        if (start == end) {
            return A;
        }
        int[] B = new int[end - start];
        for (int i = 0; i < B.length; i++){
            B[i] = A[start];
            start++;
        }
        return B;
    }

    public static int[] merge(int[] A, int[] B, int[] out) {
        // merge two sorted lists A, B into out
        int i = 0; // left ptr
        int j = 0; // right ptr
        int k = 0; // out ptr

        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                out[k] = A[i];
                i++;
            } else {
                out[k] = B[j];
                j++;
            }
            k++;
        }

        while (i < A.length) {
            out[k] = A[i];
            i++;
            k++;
        }
        while (j < B.length) {
            out[k] = B[j];
            j++;
            k++;
        }
        return out;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] test = new int[]{3, 5, 2, 1, 6, 9, 7, 4, 8, 10};
        print(test);
        mergeSort(test);
        print(test);
    }

}
