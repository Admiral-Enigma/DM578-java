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

        // Swap array[i+1] and array[r] (put pivot in its correct position)
        int temp = array[i + 1];
        array[i + 1] = array[r];
        array[r] = temp;

        return i + 1; // Return the pivot's position
    }

}
