package common;

import java.util.Random;
import java.util.stream.IntStream;

public class Common {

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
