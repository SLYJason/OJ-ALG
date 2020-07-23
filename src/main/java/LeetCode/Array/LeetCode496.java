package LeetCode.Array;

import java.util.Arrays;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class LeetCode496 {
    /**
     * Solution 1: brute force
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);
        for(int i=0; i<nums1.length; i++) {
            boolean find = false;
            for(int j=0; j<nums2.length; j++) {
                if(nums1[i] == nums2[j]) find = true;
                if(nums2[j] > nums1[i] && ans[i] == -1 && find) {
                    ans[i] = nums2[j];
                }
            }
        }
        return ans;
    }

    /**
     * Solution 2: optimal solution, stack + hashMap
     */
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack();
        Map<Integer, Integer> map = new HashMap();
        for(int num : nums2) {
            while(!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int[] ans = new int[nums1.length];
        for(int i=0; i<nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}
