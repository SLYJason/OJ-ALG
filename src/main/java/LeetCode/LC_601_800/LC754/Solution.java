package LeetCode.LC_601_800.LC754;

public class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0, sum = 0;
        while(sum < target) {
            sum += ++k;
        }
        int d = sum - target;
        if(d % 2 == 0) return k; // If the diff is even, we can return the current k.
        return k + 1 + k % 2; // If the diff is odd, need to increase the k until the diff is even, at most 2 more steps needed.
    }
}
