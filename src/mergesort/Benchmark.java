package mergesort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Benchmark {
    public static void main(String[] args) {
        MergeSort sorter = new MergeSort();

        int iterations = 3;
        int[] testN = {10000, 100000, 1000000, 10000000, 50000000};

        System.out.println("Array sizes: " + Arrays.toString(testN));
        System.out.println("Iterations per size: " + iterations);
        System.out.println("==================================");

        for (int n : testN) {
            System.out.println("\nBenchmarking for n = " + n);

            long unsortedSum = 0;
            long sortedSum = 0;
            long reversedSum = 0;

            for (int i = 0; i < iterations; i++) {
                int[] testArray = randomArray(n);
                int[] testArraySorted = Arrays.stream(testArray).sorted().toArray();
                int[] testArrayReversed = Arrays.copyOf(testArraySorted, testArraySorted.length);
                reverseArray(testArrayReversed);

                long startUnsorted = System.nanoTime();
                sorter.mergeSort(testArray, 0, testArray.length - 1);
                long stopUnsorted = System.nanoTime();
                unsortedSum += (stopUnsorted - startUnsorted);

                long startSorted = System.nanoTime();
                sorter.mergeSort(testArraySorted, 0, testArraySorted.length - 1);
                long stopSorted = System.nanoTime();
                sortedSum += (stopSorted - startSorted);

                long startReversed = System.nanoTime();
                sorter.mergeSort(testArrayReversed, 0, testArrayReversed.length - 1);
                long stopReversed = System.nanoTime();
                reversedSum += (stopReversed - startReversed);

                System.out.print(".");
            }
            System.out.println();

            double unsortedAvgMs = (unsortedSum / (double)iterations) / 1_000_000.0;
            double sortedAvgMs = (sortedSum / (double)iterations) / 1_000_000.0;
            double reversedAvgMs = (reversedSum / (double)iterations) / 1_000_000.0;

            System.out.println("Average times (ms):");
            System.out.println("  Unsorted array: " + unsortedAvgMs);
            System.out.println("  Sorted array: " + sortedAvgMs);
            System.out.println("  Reversed array: " + reversedAvgMs);

            double nLogN = n * log2(n);

            System.out.println("n*log2(n) = " + nLogN);
            System.out.println("Constants (time in ms divided by n*log2(n)):");
            System.out.println("  Unsorted array constant: " + (unsortedAvgMs / nLogN));
            System.out.println("  Sorted array constant: " + (sortedAvgMs / nLogN));
            System.out.println("  Reversed array constant: " + (reversedAvgMs / nLogN));

            System.out.println("----------------------------------");
        }
    }

    public static int[] randomArray(int size) {
        Random random = new Random();
        return IntStream.generate(() -> random.nextInt(size)).limit(size).toArray();
    }

    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            // Swap elements
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            // Move indices toward the center
            start++;
            end--;
        }
    }

    public static double log2(double N) {
        return Math.log(N) / Math.log(2);
    }
}
