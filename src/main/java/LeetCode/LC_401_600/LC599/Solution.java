package LeetCode.LC_401_600.LC599;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Solution: using HashMap.
 */
public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if(list1.length == 0 || list2.length == 0) return new String[0];
        // build list1 preferences.
        Map<String, Integer> pref1 = new HashMap(); // K: restaurant name, V: preference.
        for(int i=0; i<list1.length; i++) pref1.put(list1[i], i);
        // find common interests with the least list index sum.
        List<String> res = new ArrayList();
        int pref = Integer.MAX_VALUE; // least list index sum.
        for(int i=0; i<list2.length; i++) {
            if(pref1.containsKey(list2[i])) {
                if(i + pref1.get(list2[i]) < pref) { // find a new least list index sum.
                    pref = i + pref1.get(list2[i]);
                    res.clear();
                    res.add(list2[i]);
                } else if(i + pref1.get(list2[i]) == pref) { // add restaurant to a existing least list index sum.
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
