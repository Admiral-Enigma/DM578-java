package countingsort;

public class CountingSort {


    public int[] countingSort(int[] A, int n, int k) {
        int[] B = new int[n];
        int[] C = new int[k];


        // Count occurrences of each element
        for (int j = 0; j < n; j++) {
            C[A[j]] = C[A[j]] + 1;
        }

        // Calculate cumulative counts
        for (int i = 1; i < k; i++) {
            C[i] = C[i] + C[i - 1];
        }

        // Place elements in correct positions
        for (int j = n - 1; j >= 0; j--) {
            B[C[A[j]] - 1] = A[j];
            C[A[j]] = C[A[j]] - 1;
        }

        return B;
    }
}
