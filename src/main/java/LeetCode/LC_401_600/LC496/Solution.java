package LeetCode.LC_401_600.LC496;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.HashMap;

/**
 * Solution: monotonic stack.
 */
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque();
        Map<Integer, Integer> map = new HashMap();
        for(int i=0; i<nums2.length; i++) {
            while(!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                map.put(nums2[stack.poll()], nums2[i]);
            }
            stack.push(i);
        }
        // build the result.
        int[] res = new int[nums1.length];
        for(int i=0; i<nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}
