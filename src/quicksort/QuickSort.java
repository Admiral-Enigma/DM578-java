package quicksort;

public class QuickSort {

    public int partition(int[] array, int p, int r) {
        if (array.length >= 16) {
            selectPivot(array, p, r);
        }

        int x = array[r]; // pivot element
        int i = p - 1;    // index of smaller element

        // Process all elements except the pivot
        for (int j = p; j < r; j++) {
            if (array[j] <= x) {
                i++;
                // Swap array[i] and array[j]
                swap(array, i, j);
            }
        }

        int pivotNewIndex = i + 1; // Just after the last swapped element in the partition

        // Swap array[i+1] and array[r] (put pivot in its correct position)
        swap(array, pivotNewIndex, r);

        return pivotNewIndex; // Return the pivot's position
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void selectPivot(int[] array, int p, int r) {
        int middle = p + (r - p) / 2;

        // If the middle element is smaller than the first element, swap them
        if (array[middle] < array[p]) {
            swap(array, middle, p);
        }

        // If the last element is smaller than the first element, swap them
        if (array[r] < array[p]) {
            swap(array, r, p);
        }

        // If the middle element is smaller than the last element, swap them
        if (array[middle] < array[r]) {
            swap(array, middle, r);
        }
    }


    public void quicksort(int[] array, int p, int r) {
        // This is text book divide and conquer.
        // Partition the input array such that you have a pivot
        // point where to the "left" of it values are smaller than the pivot point
        // and to the right they are larger.
        // These sub arrays/partitions can then be sorted faster independently
        if (p < r) {
            int pivotIndex = partition(array, p, r);
            quicksort(array, p, pivotIndex - 1); // Sort values left of the pivot
            quicksort(array, pivotIndex +1, r); // Sort values to the right of the pivot
        }
    }

}
