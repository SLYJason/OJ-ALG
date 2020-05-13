package LeetCode.BitManipulation;

public class LeetCode476 {
    // Solution 1: flip bit by bit
    public int findComplement(int num) {
        int bitLength = Integer.toBinaryString(num).length();
        int bit = 1;
        while(bitLength > 0) {
            num = num ^ bit;
            bit = bit << 1;
            bitLength--;
        }
        return num;
    }

    // Solution 2: use bit mask
    // 0 0 0 0 1 0 1 (num = 5)
    // 0 0 0 1 0 0 0 (Integer.highestOneBit(5) << 1)
    // 0 0 0 0 1 1 1 (Integer.highestOneBit(5) << 1 - 1 = mask)
    // 0 0 0 0 0 1 0 (num ^ mask)
    public int findComplemen2(int num) {
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        return num ^ mask;
    }
}
