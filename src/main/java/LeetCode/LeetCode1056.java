package LeetCode;

import java.util.Map;
import java.util.HashMap;

public class LeetCode1056 {
    public boolean confusingNumber(int N) {
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        int rotate = 0;
        int n = N;
        while(n!=0) {
            int reminder = n%10;
            if (!map.containsKey(reminder)) return false;
            rotate = rotate*10 + map.get(reminder);
            n = n/10;
        }
        return rotate == N ? false : true;
    }
}
