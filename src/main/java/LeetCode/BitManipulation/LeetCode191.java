package LeetCode.BitManipulation;

public class LeetCode191 {
    // Solution 1: using mask to check every bit
    public int hammingWeight(int n) {
        int count = 0, mask = 1;
        for(int i=0; i<32; i++) {
            if((n & mask) != 0) count++;
            mask = mask << 1;
        }
        return count;
    }

    // Solution 2: using bit manipulation trick
    // For any number n, doing a bit-wise AND of n and n-1 flips the least-significant 1-bit in n to 0, and keeps all other bits the same
    public int hammingWeight2(int n) {
        int ones = 0;
        while(n != 0) {
            n = n & (n-1);
            ones++;
        }
        return ones;
    }
}
