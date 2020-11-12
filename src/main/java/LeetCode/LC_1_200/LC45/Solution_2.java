package LeetCode.LC_1_200.LC45;

/**
 * Solution 2: Greedy.
 */
public class Solution_2 {
    public int jump(int[] nums) {
        int max_position = 0;
        int steps = 0;
        int end = 0;
        for(int i=0; i<nums.length-1; i++) { // we don't access the last element.
            max_position = Math.max(max_position, i+nums[i]);
            if(i == end) {
                end = max_position;
                steps++;
            }
            // debug:
            // System.out.println("i=" + i + " max_position=" + max_position + " end=" + end + " steps=" + steps);
        }
        return steps;
    }
}
