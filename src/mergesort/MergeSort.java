package mergesort;

import java.util.Arrays;

public class MergeSort {

    public int[] merge(int[] A, int p, int q, int r) {
        int nL = q - p + 1;
        int nR = r - q;

        // Create arrays of the correct size
        int[] L = new int[nL];
        int[] R = new int[nR];

        // Fill the arrays completely
        for (int i = 0; i < nL; i++) {
            L[i] = A[p + i];
        }

        for (int j = 0; j < nR; j++) {
            R[j] = A[q + j + 1];
        }

        int i = 0; // Indexes the smallest remaining element in L
        int j = 0; // Indexes the smallest remaining element in R
        int k = p; // k indexes the location in A to fill

        // Merge the arrays back into A
        while (i < nL && j < nR) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from L
        while (i < nL) {
            A[k] = L[i];
            i++;
            k++;
        }

        // Copy any remaining elements from R
        while (j < nR) {
            A[k] = R[j];
            j++;
            k++;
        }

        return A;
    }

    public int[] mergeSort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2; // Math.floor not needed for integer division

            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }

        return A;
    }
}
