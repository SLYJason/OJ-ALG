package LeetCode.LC_601_800.LC718;

import java.util.List;
import java.util.ArrayList;

/**
 * Follow up: How to Get the Maximum Repeated Subarray?
 */
public class FollowUp {
    public int[] findArray(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int max_length = 0, end_index = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i < nums1.length + 1; i++) {
            for(int j = 1; j < nums2.length + 1; j++) {
                dp[i][j] = nums1[i - 1] == nums2[j - 1] ? dp[i - 1][j - 1] + 1 : 0;
                if(dp[i][j] > max_length) {
                    max_length = dp[i][j];
                    end_index = i - 1;
                }
            }
        }
        // no common
        if(max_length == 0) return new int[0];
        // build the result.
        for(int i = end_index; i > end_index - max_length; i--) {
            res.add(0, nums1[i]);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        FollowUp f = new FollowUp();
        // test case 1.
        System.out.print("test case 1: ");
        int[] A1 = {1,2,3,2,1}, B1 = {3,2,1,4,7};
        for(int n : f.findArray(A1, B1)) {
            System.out.print(n + " ");
        }
        // test case 2.
        System.out.print("\ntest case 2: ");
        int[] A2 = {4,6,7,8}, B2 = {0,1,2,3,4,6,9};
        for(int n : f.findArray(A2, B2)) {
            System.out.print(n + " ");
        }
        // test case 3.
        System.out.print("\ntest case 3: ");
        int[] A3 = {1,2,3}, B3 = {6,7,8,9,10};
        for(int n : f.findArray(A3, B3)) {
            System.out.print(n + " ");
        }
        // test case 4.
        System.out.print("\ntest case 4: ");
        int[] A4 = {10,11,12,13,14,15,19}, B4 = {9,10,11,12,13,14,16,19};
        for(int n : f.findArray(A4, B4)) {
            System.out.print(n + " ");
        }
    }
}
