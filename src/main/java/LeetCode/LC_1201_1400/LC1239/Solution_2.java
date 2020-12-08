package LeetCode.LC_1201_1400.LC1239;

import java.util.List;
import java.util.ArrayList;

public class Solution_2 {
    public int maxLength(List<String> arr) {
        List<String> unique_strings = new ArrayList();
        unique_strings.add("");

        for(String cur : arr) {
            List<String> temp = new ArrayList();
            for(String s : unique_strings) {
                String new_string = s + cur;
                if(isUnique(new_string)) {
                    temp.add(new_string);
                }
            }
            unique_strings.addAll(temp);
        }
        int max_length = 0;
        for(String s : unique_strings) max_length = Math.max(max_length, s.length());
        return max_length;
    }

    private boolean isUnique(String s) {
        int[] count = new int[128];
        for(char ch : s.toCharArray()) {
            if(count[ch]++ > 0) return false;
        }
        return true;
    }
}
