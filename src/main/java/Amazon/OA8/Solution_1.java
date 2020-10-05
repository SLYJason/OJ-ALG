package Amazon.OA8;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/**
 * Solution 1: brute force.
 */
public class Solution_1 {
    public List<String> subStrings(String inputString, int num) {
        List<String> res = new ArrayList<>();
        for(int i=0, j=num; j<=inputString.length(); i++, j++) {
            String sub = inputString.substring(i, j);
            Set<Character> set = new HashSet();
            for(char ch : sub.toCharArray()) set.add(ch);
            if(set.size() == num-1 && !res.contains(sub)) res.add(sub);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_1 s = new Solution_1();
        String inputString1 = "awaglk";
        int num1 = 4;
        String inputString2 = "democracy";
        int num2 = 5;
        String inputString3 = "wawaglknagagwunagkwkwagl";
        int num3 = 4;
        System.out.println(s.subStrings(inputString1, num1));
        System.out.println(s.subStrings(inputString2, num2));
        System.out.println(s.subStrings(inputString3, num3));
    }
}
