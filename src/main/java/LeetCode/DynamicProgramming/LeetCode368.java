package LeetCode.DynamicProgramming;

import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class LeetCode368 {
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            if(nums.length == 0) return new LinkedList();
            Arrays.sort(nums);
            // length of largest divisible subsets ends with nums[i]
            int[] dp = new int[nums.length];
            int maxIndex = 0;
            int maxSize= 0;
            for(int i=0; i<nums.length; i++) {
                int subsetSize = 0;
                for(int j=i; j>=0; j--) {
                    if(nums[i] % nums[j] == 0) {
                        dp[i] = Math.max(dp[i], dp[j]+1);
                    }
                }
                if(dp[i] > maxSize) {
                    maxSize = dp[i];
                    maxIndex = i;
                }
            }
            // collect all elements belongs to the largest divisible subsets
            LinkedList<Integer> ans = new LinkedList();
            for(int i=maxIndex; i>=0; i--) {
                if(nums[maxIndex] % nums[i] == 0 && dp[i] == maxSize) {
                    ans.addFirst(nums[i]);
                    maxSize--;
                }
            }
            return ans;
        }
    }
}
