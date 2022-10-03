package DataDog.Onsite.Q1;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class TagsFilter {
    Map<String, List<Set<String>>> map; // key: tag, value: a list of tags that contains the tag key.
    TagsFilter(List<List<String>> streams) {
        map = new HashMap<>();
        for (List<String> stream : streams) {
            for (String tag : stream) {
                if (!map.containsKey(tag)) map.put(tag, new ArrayList<>());
                map.get(tag).add(new HashSet<>(stream));
            }
        }
    }

    public List<String> filter(List<String> keywords) {
        List<String> res = new ArrayList<>();
        Set<Set<String>> tagsList = new HashSet<>();
        for (String keyword : keywords) {
            if (map.containsKey(keyword)) {
                tagsList.addAll(map.get(keyword));
            }
        }

        for (Set<String> tags : tagsList) {
            boolean match = true; // determine each tags contains the all keyword.
            for (String keyword : keywords) {
                if (!tags.contains(keyword)) {
                    match = false;
                    break;
                }
            }
            if (!match) continue;
            for (String tag : tags) {
                if (!keywords.contains(tag)) res.add(tag);
            }
        }
        return res;
    }
}

public class Solution_1 {
    public static void main(String[] args) {
        List<List<String>> streams1 = new ArrayList<>();
        List<String> stream1 = new ArrayList<>() {
            {
                add("apple"); add("facebook"); add("google");
            }
        };
        List<String> stream2 = new ArrayList<>() {
            {
                add("banana"); add("facebook");
            }
        };
        List<String> stream3 = new ArrayList<>() {
            {
                add("facebook"); add("google"); add("tesla");
            }
        };
        List<String> stream4 = new ArrayList<>() {
            {
                add("intuit"); add("google"); add("facebook");
            }
        };
        streams1.add(stream1);
        streams1.add(stream2);
        streams1.add(stream3);
        streams1.add(stream4);

        List<String> keywords1 = new ArrayList<>(){
            {
                add("apple");
            }
        };
        List<String> keywords2 = new ArrayList<>(){
            {
                add("facebook"); add("google");
            }
        };

        TagsFilter tagsFilter = new TagsFilter(streams1);
        System.out.println(tagsFilter.filter(keywords1));
        System.out.println(tagsFilter.filter(keywords2));
    }
}
