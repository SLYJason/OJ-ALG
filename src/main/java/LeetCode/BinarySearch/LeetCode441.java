package LeetCode.BinarySearch;

public class LeetCode441 {
    // Solution 1: brute force, intuitive thoughts
    public int arrangeCoins(int n) {
        int total = 0, ans = 0;
        for(int i=1; ;i++) {
            if(i > n - total) break;
            total += i;
            ans++;
        }
        return ans;
    }

    // Solution 2: binary search
    public int arrangeCoins2(int n) {
        long left = 1, right = n, k = 0;
        while(left <= right) {
            k = left + (right-left)/2;
            long curr = (1 + k)*k/2;
            if(curr == n) return (int)k;
            if(curr < n) {
                left = k + 1;
            } else {
                right = k - 1;
            }
        }
        return (int)right;
    }
}
