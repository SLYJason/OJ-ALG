package LeetCode.Array;

public class LeetCode918 {
    public int maxSubarraySumCircular(int[] A) {
        int currMax = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        int currMin = Integer.MAX_VALUE, min = Integer.MAX_VALUE;
        int sum = 0;
        for(int a : A) {
            currMax = Math.max(currMax, 0) + a;
            max = Math.max(currMax, max);
            currMin = Math.min(currMin, 0) + a;
            min = Math.min(currMin, min);
            sum += a;
        }
        return sum - min == 0 ? max : Math.max(max, sum - min);
    }
}
