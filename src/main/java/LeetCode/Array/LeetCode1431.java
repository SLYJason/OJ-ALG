package LeetCode.Array;

import java.util.List;
import java.util.ArrayList;

public class LeetCode1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList();
        int max_candy = candies[0];
        for(int i=0; i<candies.length; i++) {
            max_candy = Math.max(max_candy, candies[i]);
        }
        for(int i=0; i<candies.length; i++) {
            if(candies[i] + extraCandies >= max_candy) {
                res.add(true);
            } else{
                res.add(false);
            }
        }
        return res;
    }
}
