package LeetCode.Math;

public class LeetCode367 {
    // Solution 1: binary search
    // Time Complexity: O(logN)
    // Space Complexity: O(1)
    public boolean isPerfectSquare(int num) {
        if(num < 2) return true;
        long left = 1, right = num / 2;
        while(left <= right) {
            long mid = left + (right - left) / 2;
            long gussed = mid * mid;
            if(num == gussed) {
                return true;
            } else if(num < gussed) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    // Solution 2: Newton's method
    // Time Complexity: O(logN)
    // Space Complexity: O(1)
    // Reference: https://leetcode.com/problems/valid-perfect-square/solution
    public boolean isPerfectSquare2(int num) {
        if(num < 2) return true;
        long x = num / 2;
        while(x * x - num > 0) {
            x = (x + num / x) / 2;
        }
        return x * x == num;
    }
}
