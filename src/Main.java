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



        System.out.println("Unsorted average: " + unsortedSum / unsortedTimes.size());
        System.out.println("Sorted average: " + sortedSum / sortedTimes.size());

    }
    
    
    public static int[] randomArray(int size ) {
        return IntStream.generate(() -> new Random().nextInt(size)).limit(size).toArray();
    }
}