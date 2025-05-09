package quicksort;

import common.Common;

import java.lang.reflect.Array;
import java.util.Arrays;

import static common.Common.randomArray;
import static common.Common.reverseArray;

public class Benchmark {

    public static void main(String[] args) {

        QuickSort sorter = new QuickSort();
        int iterations = 3;
        int[] testN = {45000, 900000, 1900000, 10000000, 50000000};

        System.out.println("Quicksort benchmark");
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
                sorter.quicksort(testArray, 0, testArray.length - 1);
                long stopUnsorted = System.nanoTime();
                unsortedSum += (stopUnsorted - startUnsorted);

                long startSorted = System.nanoTime();
                sorter.quicksort(testArraySorted, 0, testArraySorted.length - 1);
                long stopSorted = System.nanoTime();
                sortedSum += (stopSorted - startSorted);

                long startReversed = System.nanoTime();
                sorter.quicksort(testArrayReversed, 0, testArrayReversed.length - 1);
                long stopReversed = System.nanoTime();
                reversedSum += (stopReversed - startReversed);

                System.out.print(".");
            }
            System.out.println();

            double unsortedAvgMs = (unsortedSum / (double) iterations) / 1_000_000.0;
            double sortedAvgMs = (sortedSum / (double) iterations) / 1_000_000.0;
            double reversedAvgMs = (reversedSum / (double) iterations) / 1_000_000.0;

            System.out.println("Average times (ms):");
            System.out.println("  Unsorted array: " + unsortedAvgMs);
            System.out.println("  Sorted array: " + sortedAvgMs);
            System.out.println("  Reversed array: " + reversedAvgMs);

            double nLogN = n * Common.log2(n);


            // Maybe wrong to do idk? Makes it easier to compare the constants across different N's
            String unsortedConstant = String.format("%.6f", (unsortedAvgMs / nLogN));
            String sortedConstant = String.format("%.6f", (sortedAvgMs / nLogN));
            String reverseSortedConstant = String.format("%.6f", (reversedAvgMs / nLogN));

            System.out.println("n*log2(n) = " + nLogN);
            System.out.println("Constants (time in ms divided by n*log2(n) then rounded to 6 digits for readability):");
            System.out.println("  Unsorted array constant: " + unsortedConstant);
            System.out.println("  Sorted array constant: " + sortedConstant);
            System.out.println("  Reversed array constant: " + reverseSortedConstant);

            System.out.println("----------------------------------");
        }
    }
}
