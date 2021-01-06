package LeetCode.LC_1401_1600.LC1539;

/**
 * Solution 1: linear search.
 */
public class Solution_1 {
    public int findKthPositive(int[] arr, int k) {
        int missing = arr[0] - 1;
        if(k <= missing) return k;
        for(int i = 1; i<arr.length; i++) {
            missing += arr[i] - arr[i-1] - 1;
            if(k <= missing) return (arr[i] - 1) - (missing - k);
        }
        return arr[arr.length-1] + k - missing;
    }
}
