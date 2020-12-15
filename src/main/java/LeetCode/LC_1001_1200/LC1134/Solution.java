package LeetCode.LC_1001_1200.LC1134;

public class Solution {
    public boolean isArmstrong(int N) {
        int sum = 0, n = N, k = String.valueOf(N).length();
        while(n > 0) {
            sum += Math.pow(n % 10, k);
            n /= 10;
        }
        return sum == N;
    }
}
