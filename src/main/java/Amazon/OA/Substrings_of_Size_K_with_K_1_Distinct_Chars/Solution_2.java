package Amazon.OA.Substrings_of_Size_K_with_K_1_Distinct_Chars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution 2: sliding window.
 */
public class Solution_2 {
    public List<String> subStrings(String inputString, int num) {
        List<String> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int i=0, j=0;
        while(j < inputString.length()) {
            char ch = inputString.charAt(j++);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if(j-i > num) {
                char leftChar = inputString.charAt(i++);
                map.put(leftChar, map.get(leftChar)-1);
                if(map.get(leftChar) == 0) map.remove(leftChar);
            }
            if(j-i == num && map.size() == num-1 && !res.contains(inputString.substring(i, j))) {
                res.add(inputString.substring(i, j));
            }
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
