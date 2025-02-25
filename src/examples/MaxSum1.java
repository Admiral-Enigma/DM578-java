package examples;// Basic algorithm for calculating largest contiguous segment sum

import java.util.Random;

public class MaxSum1 {
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
        int sum;
        // For all subsegments
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                // Sum the segment
                sum = 0;
                for(int k=i; k<=j; k++){
                    sum += data[k];
                }
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