package LeetCode.LC_1401_1600.LC1539;

/**
 * Solution 2: binary search.
 */
public class Solution_2 {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length, left = 0, right = n;
        while(left < right) {
            int mid = left + (right - left) / 2;
            int missing = arr[mid] - (mid + 1);
            if(k > missing) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left + k; // In the range of [1, i+k], there are i numbers not missing, and k numbers are missing.
    }
}
