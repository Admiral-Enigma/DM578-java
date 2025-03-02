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

        ArrayList<Long> sortedTimes = new ArrayList<Long>();
        ArrayList<Long> unsortedTimes = new ArrayList<Long>();
        ArrayList<Long> reversedTimes = new ArrayList<Long>();

        for (int i = 0; i < iterations; i++) {
            for (int n : testN) {
                int[] testArray = randomArray(n);

                int[] testArraySorted = Arrays.stream(testArray).sorted().toArray();
                int[] testArraySortedReverse = Arrays.copyOf(testArraySorted, testArraySorted.length);
                reverseArray(testArraySortedReverse);

                long startSorted = System.currentTimeMillis();
                sorter.mergeSort(testArraySorted, 0, testArraySorted.length -1);
                long stopSorted = System.currentTimeMillis();
                sortedTimes.add(stopSorted - startSorted);


                long startUnsorted = System.currentTimeMillis();
                sorter.mergeSort(testArray, 0, testArray.length -1);
                long stopUnsorted = System.currentTimeMillis();
                unsortedTimes.add(stopUnsorted - startUnsorted);

                long startSortedReverse = System.currentTimeMillis();
                sorter.mergeSort(testArraySortedReverse, 0, testArraySortedReverse.length -1);
                long stopSortedReverse = System.currentTimeMillis();
                reversedTimes.add(stopSortedReverse - startSortedReverse);
            }
        }


        long unsortedSum = 0;
        long sortedSum = 0;
        long sortedReversedSum = 0;

        for (Long time : unsortedTimes) {
            unsortedSum += time;
        }

        for (Long time : sortedTimes) {
            sortedSum += time;
        }

        for (Long time : reversedTimes) {
            sortedReversedSum += time;
        }


        long unsortedAverage = unsortedSum / unsortedTimes.size();
        long sortedAverage = sortedSum / sortedTimes.size();
        long sortedReverseAverage = sortedReversedSum / reversedTimes.size();



        System.out.println("Array based unsorted average: " + unsortedAverage);
        System.out.println("Array based Sorted average: " + sortedAverage);
        System.out.println("Array based Sorted reverse average: " + sortedReverseAverage);


        for (int n : testN) {
            double thing = n * log2(n);

            System.out.println();
            System.out.println("=============");
            System.out.println("For n = " + n);

            for (int i = 0; i < iterations; i++) {
                System.out.println("Iteration: " + i);
                System.out.println("=============");
                double constantUnsorted = unsortedAverage / thing;
                double constantSorted =  sortedAverage / thing;
                double constantSortedReverse =  sortedReverseAverage / thing;

                System.out.println("Array based unsorted constant: " + constantUnsorted);
                System.out.println("Array based Sorted constant: " + constantSorted);
                System.out.println("Array based Sorted reverse constant: " + constantSortedReverse);
            }

        }

        /*ArrayList<Long> sortedTimesArrayList = new ArrayList<Long>();
        ArrayList<Long> unsortedTimesArrayList = new ArrayList<Long>();

        for (int i = 0; i < iterations; i++) {
            int[] randomArray = randomArray(arraySize);

            ArrayList<Integer> testArray = new ArrayList<>();

            for (int element : randomArray) {
                testArray.add(element);
            }

            ArrayList<Integer> testArraySorted = new ArrayList<>(testArray);
            testArraySorted.sort(null);


            long startSorted = System.currentTimeMillis();
            MergeSortArrayList.merge_sort(testArraySorted, 0, testArraySorted.size() -1);
            long stopSorted = System.currentTimeMillis();
            sortedTimesArrayList.add(stopSorted - startSorted);


            long startUnsorted = System.currentTimeMillis();
            MergeSortArrayList.merge_sort(testArray, 0, testArray.size() -1);
            long stopUnsorted = System.currentTimeMillis();
            unsortedTimesArrayList.add(stopUnsorted - startUnsorted);

        }


        long unsortedSumArraylist = 0;
        long sortedSumArraylist = 0;

        for (Long time : unsortedTimesArrayList) {
            unsortedSumArraylist += time;
        }

        for (Long time : sortedTimesArrayList) {
            sortedSumArraylist += time;
        }


        System.out.println("ArrayList based unsorted average: " + unsortedSumArraylist / unsortedTimesArrayList.size());
        System.out.println("ArrayList based Sorted average: " + sortedSumArraylist / sortedTimesArrayList.size());*/

    }
    
    
    public static int[] randomArray(int size ) {
        return IntStream.generate(() -> new Random().nextInt(size)).limit(size).toArray();
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

    public static int log2(int N)
    {

        return (int)(Math.log(N) / Math.log(2));
    }
}