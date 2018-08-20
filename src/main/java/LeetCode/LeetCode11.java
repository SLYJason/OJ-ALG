package LeetCode;

public class LeetCode11 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0;
        int j = height.length-1;
        while(i<j){
            if(height[i] > height[j]) {
                maxArea = Math.max(maxArea, height[j] * (j-i));
                j--;
            }
            else{
                maxArea = Math.max(maxArea, height[i] * (j-i));
                i++;
            }
        }
        return maxArea;
    }
}
