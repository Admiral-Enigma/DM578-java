package examples;// Algorithm for calculating largest contiguous segment sum, with one
// loop collapsed.

import java.util.Random;

public class MaxSum2 {
    public static void main(String[] args) {

        // Set up array of n random ints (including negatives)
        int n = 2500;
        int[] data = new int[n];
        Random random = new Random();
        for(int i=0; i<n; i++){
            data[i] = -1000 + random.nextInt(2000);
        }

        // Visualize data
        if (n <= 20){
            for(int i=0; i<n; i++){
                System.out.println(data[i]);
            }
        }

        // Start timing
        long time = System.currentTimeMillis();

        // Start of main algorithm
        int maxsofar = 0;
        int sum;
        // For all segment starting points
        for(int i=0; i<n; i++){
            sum = 0; // start with the empty segment
            // For all segment ending points
            for(int j=i; j<n; j++){
                // Expand the previous segment with data[j]
                sum += data[j];
                // Update best known segment sum
                maxsofar = Math.max(maxsofar, sum);
            }
        }

        // Print final best segment sum
        System.out.println("Max segment sum: " + maxsofar);

        // End timing
        time = System.currentTimeMillis() - time;
        System.out.println("Milliseconds: " + time);
    }
}

