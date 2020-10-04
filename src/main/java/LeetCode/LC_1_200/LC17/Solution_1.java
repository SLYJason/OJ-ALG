package LeetCode.LC_1_200.LC17;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Solution 1: brute force, backtrack + DFS.
 */
public class Solution_1 {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList();
        List<String> res = new ArrayList();
        Map<Integer, List<Character>> map = buildMap();
        combination("", digits, 0, map, res);
        return res;
    }

    private void combination(String tmp, String digits, int index, Map<Integer, List<Character>> map, List<String> res) {
        if(tmp.length() == digits.length()) {
            res.add(tmp);
            return;
        }
        int num = Character.getNumericValue(digits.charAt(index));
        List<Character> dict = map.get(num);
        for(int i=0; i<dict.size(); i++) {
            tmp += dict.get(i);
            combination(tmp, digits, index+1, map, res);
            tmp = tmp.substring(0, tmp.length()-1);
        }
    }

    private Map<Integer, List<Character>> buildMap() {
        Map<Integer, List<Character>> map = new HashMap();
        char ch = 'a';
        for(int i=2; i<=9; i++) {
            map.put(i, new ArrayList());
            for(int j=0; j < (i==7 || i == 9 ? 4 : 3); j++) {
                map.get(i).add(ch++);
            }
        }
        return map;
    }
}
