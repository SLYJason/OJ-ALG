package LeetCode.LC_801_1000.LC881;

import java.util.Arrays;

/**
 * Solution: two pointers.
 */
public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int count = 0, i = 0, j = n - 1;
        while(i <= j) {
            if(people[i] + people[j] <= limit) {
                i++;
            }
            j--;
            count++;
        }
        return count;
    }
}
