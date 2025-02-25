public class MergeSort {

    public int[] merge(int[] A, int p, int q, int r) {
        int nL = q - p + 1;
        int nR = r - q;

        int[] L = new int[nL - 1];
        int[] R = new int[nR - 1];

        for (int i = 0; i < nL -1; i++) {
            L[i] = A[p+i];
        }

        for (int j = 0; j < nR -1; j++) {
            R[j] = A[q+j+1];
        }


        int i = 0; // Indexes the smallest remaining element in L
        int j = 0; // Indexes the smallest remaining element in R
        int k = p; // k indexes the location in A to fill

        while (i < nL && j < nR) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i += 1;
            } else if (A[k] == R[j]) {
               j += 1;
            }
            k += 1;
        }

        while (i < nL) {
            A[k] = L[i];
            i +=1;
            k +=1;
        }

        while (j < nR) {
            A[k] = R[j];
            j +=1;
            k +=1;
        }

        return A;
    }


    public int[] mergeSort(int[] A, int p, int r) {
        if (p >= r) {
            return A;
        }

        int q = (int) Math.floor((p + r) / 2);

        mergeSort(A, p, q);
        mergeSort(A, q+ 1, r);



        return merge(A, p, q, r);
    }
}
