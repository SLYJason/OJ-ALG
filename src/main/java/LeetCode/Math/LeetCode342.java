package LeetCode.Math;

public class LeetCode342 {
    /**
     * Solution 1: brute force, intuition thought.
     */
    public boolean isPowerOfFour1(int num) {
        if(num == 0) return false;
        while(num % 4 == 0) {
            num = num / 4;
        }
        return num == 1;
    }

    /**
     * Solution 2: bit manipulation.
     * Similar to power of 2.
     */
    public boolean isPowerOfFour2(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0xaaaaaaaa) == 0;
    }
}
