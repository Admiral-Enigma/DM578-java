import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MergeSort sorter = new MergeSort();
        int[] test = {3,2,6,5,4};

        int[] res = sorter.mergeSort(test, 1, 5);

        System.out.println(Arrays.toString(res));
    }
}