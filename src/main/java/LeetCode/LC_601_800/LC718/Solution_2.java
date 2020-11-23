package LeetCode.LC_601_800.LC718;

/**
 * Solution 2: sliding window.
 */
public class Solution_2 {
    public int findLength(int[] A, int[] B) {
        int max_length = 0, lenA = A.length, lenB = B.length;
        // fixed A, compare B with every A's element.
        for(int i=0; i<lenA; i++) {
            int max = findLargestCommon(A, B, i, 0, Math.min(lenA-i, lenB));
            max_length = Math.max(max_length, max);
        }
        // fixed B, compare A with every B's element.
        for(int i=0; i<lenB; i++) {
            int max = findLargestCommon(A, B, 0, i, Math.min(lenA, lenB-i));
            max_length = Math.max(max_length, max);
        }
        return max_length;
    }

    private int findLargestCommon(int[] A, int[] B, int startA, int startB, int len) {
        int common = 0, max = 0;
        for(int i=0; i<len; i++) {
            if(A[startA+i] == B[startB+i]) {
                common++;
                max = Math.max(max, common);
            } else {
                common = 0;
            }
        }
        return max;
    }
}
