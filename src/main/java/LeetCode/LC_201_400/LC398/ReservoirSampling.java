package LeetCode.LC_201_400.LC398;

import java.util.Random;

public class ReservoirSampling {
    public static int[] select(int[] nums, int k) {
        int n = nums.length;
        int[] reservoir = new int[k];
        // fill the reservoir.
        for(int i=0; i<k; i++) reservoir[i] = nums[i];
        // replacement.
        for(int i=k; i<n; i++) {
            int rand = new Random().nextInt(i+1);
            if(rand < k) {
                reservoir[rand] = nums[i];
            }
        }
        return reservoir;
    }
    public static void main(String[] args) {
        int nums[] = {1, 7, 4, 8, 2, 6, 5, 9};
        int k = 4;
        for(int n : select(nums, k)) {
            System.out.print(n + " ");
        }
    }
}
