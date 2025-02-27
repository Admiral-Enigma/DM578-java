package examples;

import java.util.ArrayList;

public class MergeSortArrayList {
    // Credits til Christian for implementation
    public static ArrayList<Integer> merge(ArrayList<Integer> v, int p, int q, int r){
        int nl = q-p+1;
        int nr = r-q;

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for(int i = 0; i<nl; i++){
            left.add(v.get(p+i));
        }
        for(int j = 0; j<nr; j++){
            right.add(v.get(q+j+1));
        }
        int i = 0;
        int j = 0;
        int k = p;

        while(i < nl && j < nr){
            if(left.get(i) <= right.get(j)){
                v.set(k, left.get(i));
                i++;
            }
            else{
                v.set(k, right.get(j));
                j++;
            }
            k++;
        }
        while(i < nl){
            v.set(k, left.get(i));
            i++;
            k++;
        }
        while(j < nr){
            v.set(k, right.get(j));
            j++;
            k++;
        }
        return v;
    }

    public static ArrayList<Integer> merge_sort(ArrayList<Integer> v, int p, int r){
        if(p >= r){
            return v;
        }
        int q =(int) Math.floor((p+r)/2);
        merge_sort(v, p,q);
        merge_sort(v, q+1, r);
        return merge(v, p,q,r);
    }
}
