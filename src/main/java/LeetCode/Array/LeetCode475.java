package LeetCode.Array;

import java.util.Arrays;

public class LeetCode475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        int i=0;
        for(int house : houses) {
            while(i < heaters.length-1 && Math.abs(heaters[i] - house) >= Math.abs(heaters[i+1] - house)) {
                i++;
            }
            ans = Math.max(ans, Math.abs(house - heaters[i]));
        }
        return ans;
    }
}
