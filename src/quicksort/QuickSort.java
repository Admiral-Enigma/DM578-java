package quicksort;

public class QuickSort {

    public static int partition(int[] array, int p, int r) {
        int x = array[r]; // pivot element
        int i = p - 1;    // index of smaller element

        // Process all elements except the pivot
        for (int j = p; j < r; j++) {
            if (array[j] <= x) {
                i++;
                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int pivotNewIndex = i + 1; // Just after the last swapped element in the partition

        // Swap array[i+1] and array[r] (put pivot in its correct position)

        int temp = array[pivotNewIndex];
        array[pivotNewIndex] = array[r];
        array[r] = temp;

        return pivotNewIndex; // Return the pivot's position
    }


    public static void quicksort(int[] array, int p, int r) {
        if (p < r) {
            int pivotIndex = partition(array, p, r);
            quicksort(array, p, pivotIndex - 1); // Sort values left of the pivot
            quicksort(array, pivotIndex +1, r); // Sort values to the right of the pivot
        }
    }

}
