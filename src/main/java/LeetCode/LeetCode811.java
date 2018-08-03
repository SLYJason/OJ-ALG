package LeetCode;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class LeetCode811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String cpdomain:cpdomains) {
            String[] cp= cpdomain.split("\\s+");
            int count = Integer.valueOf(cp[0]);
            String[] domain = cp[1].split("\\.");
            String subdomain = "";
            for(int i=domain.length-1; i>=0; i--) {
                subdomain = domain[i] + (i==domain.length-1 ? "" : ".") + subdomain;
                map.put(subdomain, map.getOrDefault(subdomain, 0)+count);
            }
        }
        List<String> list = new ArrayList<String>();
        for(String domain:map.keySet()) {
            String cpdomain = String.valueOf(map.get(domain)) + " " + domain;
            list.add(cpdomain);
        }
        return list;
    }
}
