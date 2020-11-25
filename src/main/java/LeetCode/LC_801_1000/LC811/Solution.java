package LeetCode.LC_801_1000.LC811;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        if(cpdomains.length == 0) return new ArrayList();
        List<String> res = new ArrayList();
        Map<String, Integer> map = new HashMap();
        for(String cpdomain : cpdomains) {
            int whitespace_index = cpdomain.indexOf(' ');
            int count = Integer.parseInt(cpdomain.substring(0, whitespace_index));
            String domain = cpdomain.substring(whitespace_index+1);
            map.put(domain, map.getOrDefault(domain, 0)+count);
            for(int i=0; i<domain.length(); i++) {
                if(domain.charAt(i) == '.') {
                    String d = domain.substring(i+1);
                    map.put(d, map.getOrDefault(d, 0)+count);
                }
            }
        }
        // build the result.
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String combined = entry.getValue() + " " + entry.getKey();
            res.add(combined);
        }
        return res;
    }
}
