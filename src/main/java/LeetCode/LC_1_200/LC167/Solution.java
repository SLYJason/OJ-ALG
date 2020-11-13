package LeetCode.LC_1_200.LC167;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length-1;
        while(i < j) {
            int sum = numbers[i] + numbers[j];
            if(sum == target) {
                return new int[]{i+1, j+1};
            } else if(sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[2];
    }
}
