package LeetCode.Array;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

/**
 * Solution: intuitive thoughts.
 */
public class LeetCode1152 {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<String> res = new LinkedList();
        // Step 1: build user -> websites_visited KV pair.
        Map<String, List<WebSite>> user_websites = new HashMap();
        for(int i=0; i<username.length; i++) {
            if(!user_websites.containsKey(username[i])) {
                user_websites.put(username[i], new LinkedList());
            }
            user_websites.get(username[i]).add(new WebSite(website[i], timestamp[i]));
        }

        // Step 2: build 3-sequence -> number of occurrence KV pair.
        HashMap<String, Integer> sequence_count = new HashMap();
        String maxSequence = "";
        int maxCount = Integer.MIN_VALUE;
        for(Map.Entry<String, List<WebSite>> entry: user_websites.entrySet()) {
            List<WebSite> websites = entry.getValue();
            Collections.sort(websites);
            Set<String> set = new HashSet();
            for(int i=0; i<websites.size()-2; i++) {
                for(int j=i+1; j<websites.size()-1; j++) {
                    for(int k=j+1; k<websites.size(); k++) {
                        String sequence = websites.get(i).website + "->" + websites.get(j).website + "->" + websites.get(k).website;
                        if(!set.contains(sequence)) {
                            sequence_count.put(sequence, sequence_count.getOrDefault(sequence, 0) + 1);
                            if(sequence_count.get(sequence) > maxCount) {
                                maxSequence = sequence;
                                //System.out.println(maxSequence);
                                maxCount = sequence_count.get(sequence);
                            } else if(sequence_count.get(sequence) == maxCount && sequence.compareTo(maxSequence) < 0) {
                                maxSequence = sequence;
                            }
                        }
                        set.add(sequence);
                    }
                }
            }
        }
        return Arrays.asList(maxSequence.split("->"));
    }

    class WebSite implements Comparable<WebSite> {
        public String website;
        public int timestamp;
        public WebSite(String website, int timestamp) {
            this.website = website;
            this.timestamp = timestamp;
        }

        @Override
        public int compareTo(WebSite w) {
            return this.timestamp - w.timestamp;
        }

        @Override
        public String toString() {
            return "[website=" + website + ", timestamp=" + timestamp + "]";
        }
    }
}
