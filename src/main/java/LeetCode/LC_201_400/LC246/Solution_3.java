package LeetCode.LC_201_400.LC246;

/**
 * Solution 3: two pointers - optimized
 */
public class Solution_3 {
    public boolean isStrobogrammatic(String num) {
        for(int i=0, j=num.length()-1; i<=j; i++, j--) {
            if (!"00 11 96 69 88".contains(num.charAt(i) + "" + num.charAt(j))) return false;
        }
        return true;
    }
}
