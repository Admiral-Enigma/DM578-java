import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MergeSort sorter = new MergeSort();
        int[] test = {3,2,6,5,4};
        int[] test2 = {3,2,6,5,2,9,19,10,4};


        System.out.println(Arrays.toString( sorter.mergeSort(test, 0, test.length -1)));
        System.out.println(Arrays.toString( sorter.mergeSort(test2, 0, test2.length -1)));
    }
}