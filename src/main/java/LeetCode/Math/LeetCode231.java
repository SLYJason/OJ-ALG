package LeetCode.Math;

public class LeetCode231 {
    // Solution 1: iterative, intuitive thoughts
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        while(n != 1) {
            if(n % 2 != 0) return false;
            n = n / 2;
        }
        return true;
    }

    // Solution 2: a power of two in binary form has and only has one "1"
    public boolean isPowerOfTwo2(int n) {
        if (n <= 0) return false;
        return Integer.bitCount(n) == 1;
    }

    // Solution 3: turn off the rightmost 1-bit
    // 1. power of two has just one 1-bit.
    // 2. x & (x - 1) is a way to set the rightmost 1-bit to zero
    public boolean isPowerOfTwo3(int n) {
        if(n<=0) return false;
        return (n & (n-1)) == 0;
    }
}
