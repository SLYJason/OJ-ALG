package LeetCode.LC_201_400.LC277;

/**
 * Solution: two pass.
 */
public class Solution {
    public int findCelebrity(int n) {
        int celebrity = 0;
        // 1st pass.
        for(int i=1; i<n; i++) {
            if(knows(celebrity, i)) {
                celebrity = i;
            }
        }
        // 2nd pass.
        for(int i=0; i<n; i++) {
            if(i != celebrity && (knows(celebrity, i) || !knows(i, celebrity))) return -1;
        }
        return celebrity;
    }

    // The knows API is defined in the parent class Relation.
    boolean knows(int a, int b) {
        return true;
    }
}
