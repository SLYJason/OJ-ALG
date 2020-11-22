package Amazon.OA.Optimal_Utilization;

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public int[][] findIds(int[][] a, int[][] b, int target) {
        List<int[]> list = new ArrayList<>();
        int diff = Integer.MAX_VALUE;
        for(int i=0; i<a.length; i++) {
            for(int j=0; j<b.length; j++) {
                int sum = a[i][1] + b[j][1];
                if(sum == target) { // a, b pair sum equal to target.
                    if(diff != 0) list.clear();
                    diff = 0;
                    list.add(new int[]{a[i][0], b[j][0]});
                } else { // a, b pair sum not equal to target.
                    if(sum < target && target - sum < diff) {
                        diff = target - sum;
                        list.clear();
                        list.add(new int[]{a[i][0], b[j][0]});
                    } else if(target - sum == diff) {
                        list.add(new int[]{a[i][0], b[j][0]});
                    }
                }
            }
        }
        // build results.
        int[][] ans = new int[list.size()][2];
        for(int i=0; i<list.size(); i++) {
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] a1 = {{1, 2}, {2, 4}, {3, 6}};
        int[][] b1 = {{1, 2}};
        int t1 = 7;
        int[][] a2 = {{1, 3}, {2, 5}, {3, 7}, {4, 10}};
        int[][] b2 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int t2 = 10;
        int[][] a3 = {{1, 8}, {2, 7}, {3, 14}};
        int[][] b3 = {{1, 5}, {2, 10}, {3, 14}};
        int t3 = 20;
        int[][] a4 = {{1, 8}, {2, 15}, {3, 9}};
        int[][] b4 = {{1, 8}, {2, 11}, {3, 12}};
        int t4 = 20;
        Solution s = new Solution();
        System.out.println("Test Case 1:");
        printResults(s.findIds(a1, b1, t1));
        System.out.println("Test Case 2:");
        printResults(s.findIds(a2, b2, t2));
        System.out.println("Test Case 3:");
        printResults(s.findIds(a3, b3, t3));
        System.out.println("Test Case 4:");
        printResults(s.findIds(a4, b4, t4));

    }

    private static void printResults(int[][] arr) {
        for(int[] a : arr) {
            System.out.println(a[0] + ", " + a[1]);
        }
    }
}
