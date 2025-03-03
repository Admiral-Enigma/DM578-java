package quicksort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Benchmark {

    public static void main(String[] args) {
        int[] test = {13,19,9,5,12,8,7,4,21,2,6,11};

        QuickSort.quicksort(test, 0, test.length -1);
        System.out.println(Arrays.toString(test));

    }
}
