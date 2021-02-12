package LeetCode.LC_1201_1400.LC1342;

/**
 * Solution: bit manipulation.
 */
public class Solution {
    public int numberOfSteps (int num) {
        String binary = Integer.toBinaryString(num);
        int steps = 0;
        for(char c : binary.toCharArray()) {
            if(c == '1') {
                steps += 2;
            } else {
                steps++;
            }
        }
        return steps - 1;
    }
}
