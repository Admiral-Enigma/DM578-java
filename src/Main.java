import examples.MergeSortArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        MergeSort sorter = new MergeSort();
        
        int iterations = 10;
        int arraySize = 10000000;
        ArrayList<Long> sortedTimes = new ArrayList<Long>();
        ArrayList<Long> unsortedTimes = new ArrayList<Long>();

        for (int i = 0; i < iterations; i++) {
            int[] testArray = randomArray(arraySize);

            int[] testArraySorted = Arrays.stream(testArray).sorted().toArray();

            long startSorted = System.currentTimeMillis();
            sorter.mergeSort(testArraySorted, 0, testArraySorted.length -1);
            long stopSorted = System.currentTimeMillis();
            sortedTimes.add(stopSorted - startSorted);


            long startUnsorted = System.currentTimeMillis();
            sorter.mergeSort(testArray, 0, testArray.length -1);
            long stopUnsorted = System.currentTimeMillis();
            unsortedTimes.add(stopUnsorted - startUnsorted);
            
        }


        long unsortedSum = 0;
        long sortedSum = 0;

        for (Long time : unsortedTimes) {
            unsortedSum += time;
        }

        for (Long time : sortedTimes) {
            sortedSum += time;
        }



        System.out.println("Array based unsorted average: " + unsortedSum / unsortedTimes.size());
        System.out.println("Array based Sorted average: " + sortedSum / sortedTimes.size());


        ArrayList<Long> sortedTimesArrayList = new ArrayList<Long>();
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
        System.out.println("ArrayList based Sorted average: " + sortedSumArraylist / sortedTimesArrayList.size());

    }
    
    
    public static int[] randomArray(int size ) {
        return IntStream.generate(() -> new Random().nextInt(size)).limit(size).toArray();
    }
}