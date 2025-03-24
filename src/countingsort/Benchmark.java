package countingsort;

import java.util.Arrays;

public class Benchmark {

    public static void main(String[] args) {
        int[] test = new int[]{3,2,1,1,5,6,10,4,7,8,1,9};
        CountingSort sorter = new CountingSort();


        System.out.println(Arrays.toString(sorter.countingSort(test, test.length -1, 11)));
    }
}
