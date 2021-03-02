package LeetCode.LC_401_600.LC575;

import java.util.Set;
import java.util.HashSet;

/**
 * Solution: HashSet.
 */
public class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for(int type : candyType) set.add(type);
        int n = candyType.length / 2;
        return set.size() <= n ? set.size() : n;
    }
}
