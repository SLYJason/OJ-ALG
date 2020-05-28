package LeetCode.BitManipulation;

public class LeetCode338 {
    // Solution 1: using bit manipulation trick
    public int[] countBits1(int num) {
        int[] bits = new int[num+1];
        for(int i=0; i<=num; i++) {
            int ones = 0, n = i;
            while(n != 0) {
                n = n & (n-1);
                ones++;
            }
            bits[i] = ones;
        }
        return bits;
    }

    // Solution 2: using bit manipulation trick + DP
    public int[] countBits2(int num) {
        int[] bits = new int[num+1];
        for(int i=1; i<=num; i++) {
            bits[i] = bits[i & (i-1)]+1;
        }
        return bits;
    }
}
