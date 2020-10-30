package LeetCode.LC_1401_1600.LC1429;

import java.util.Set;
import java.util.LinkedHashSet;
import java.util.HashSet;

/**
 * Solution: optimal solution, intuitive thoughts, bingo!
 */
public class Solution {
    class FirstUnique {
        Set<Integer> unique; // a collection to store all the unique numbers.
        Set<Integer> duplicate; // a collection to store all the duplicate numbers.
        public FirstUnique(int[] nums) {
            unique = new LinkedHashSet();
            duplicate = new HashSet();
            for(int num : nums) {
                add(num);
            }
        }

        public int showFirstUnique() {
            return unique.isEmpty() ? -1 : unique.iterator().next();
        }

        public void add(int value) {
            if(duplicate.contains(value)) return;
            if(unique.contains(value)) {
                unique.remove(value);
                duplicate.add(value);
            } else {
                unique.add(value);
            }
        }
    }
}
