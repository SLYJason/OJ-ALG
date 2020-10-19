package LeetCode.LC_401_600.LC480;

import java.util.ArrayList;

/**
 * Solution: binary search insertion.
 */
public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] medians = new double[nums.length-k+1];
        ArrayList<Integer> window = new ArrayList();
        for(int i=0, j=0; j<nums.length; j++) {
            insert(window, nums[j]);
            if(j >= k-1) {
                if(k % 2 != 0) {
                    medians[i] = window.get(k/2) * 1.0;
                } else {
                    medians[i] = ((double)window.get(k/2-1) + window.get(k/2)) /2;
                }
                remove(window, nums[i++]);
            }
        }
        return medians;
    }

    private int binarySearch(ArrayList<Integer> window, int num) {
        int left = 0, right = window.size()-1;
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(window.get(mid) == num) {
                left = mid;
                break;
            } else if(window.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private void insert(ArrayList<Integer> window, int num) {
        int index = binarySearch(window, num);
        window.add(index, num);
    }

    private void remove(ArrayList<Integer> window, int num) {
        int index = binarySearch(window, num);
        window.remove(index);
    }
}
