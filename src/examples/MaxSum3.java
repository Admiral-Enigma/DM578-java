package examples;// Algorithm for calculating largest contiguous segment sum saving one
// more loop.

import java.util.Random;

public class MaxSum3 {
    public static void main(String[] args) {

        // Set up array of n random ints (including negatives)
        int n = Integer.parseInt(args[0]);
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
        int maxendinghere = 0; // the max sum for segments ending at
        // [or more precisely: in the gap just
        // after] the current position i

        for(int i=0; i<n; i++){
            // At this point, maxsofar and maxendinghere are correct
            // for data[0..i-1] and current position i-1
            maxendinghere = Math.max(maxendinghere + data[i], 0);
            maxsofar = Math.max(maxsofar, maxendinghere);
        }

        // Print final best segment sum
        System.out.println("Max segment sum: " + maxsofar);

        // End timing
        time = System.currentTimeMillis() - time;
        System.out.println("Milliseconds: " + time);
    }
}

