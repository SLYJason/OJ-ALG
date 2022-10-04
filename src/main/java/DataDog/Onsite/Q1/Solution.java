package DataDog.Onsite.Q1;

import java.util.*;
import java.util.stream.Collectors;

class TagsFilter1 {
    Map<String, List<Set<String>>> map; // key: tag, value: a list of tags that contains the tag key.
    TagsFilter1(List<List<String>> streams) {
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
            List<String> diff = tags.stream().filter(element -> !keywords.contains(element)).collect(Collectors.toList());
            res.addAll(diff);
        }
        return res;
    }
}

class TagsFilter2 {
    Map<String, Set<String>> map; // key: tag combinations, value: a list of remaining tags.

    TagsFilter2(List<List<String>> streams) {
        map = new HashMap<>();
        for (List<String> stream : streams) {
            Collections.sort(stream);
            List<List<String>> permutations = new ArrayList<>();
            generateCombinations(0, new ArrayList<>(), stream, permutations);

            for (List<String> permutation : permutations) {
                List<String> diff = stream.stream().filter(element -> !permutation.contains(element)).collect(Collectors.toList());
                String key = permutation.toString();
                if (!map.containsKey(key)) map.put(key, new HashSet<>());
                map.get(key).addAll(diff);
            }
        }
    }

    private void generateCombinations(int index, List<String> list, List<String> streams, List<List<String>> permutations) {
        for (int i = index; i < streams.size(); i++) {
            list.add(streams.get(i));
            permutations.add(new ArrayList<>(list));
            generateCombinations(i + 1, list, streams, permutations);
            list.remove(list.size() - 1);
        }
    }

    public List<String> filter(List<String> keywords) {
        Set<String> set = map.getOrDefault(keywords.toString(), new HashSet<>());
        return new ArrayList<>(set);
    }
}

public class Solution {
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

        System.out.println("TagsFilter1:");
        TagsFilter1 tagsFilter1 = new TagsFilter1(streams1);
        System.out.println(tagsFilter1.filter(keywords1));
        System.out.println(tagsFilter1.filter(keywords2));

        System.out.println("TagsFilter2:");
        TagsFilter2 tagsFilter2 = new TagsFilter2(streams1);
        System.out.println(tagsFilter2.filter(keywords1));
        System.out.println(tagsFilter2.filter(keywords2));
    }
}
