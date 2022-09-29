package DataDog.Onsite.Q1;

import java.util.*;

public class Solution {
    private static List<String> filter(List<List<String>> list, List<String> filter) {
        if (list == null || filter == null) return null;
        List<String> res = new ArrayList<>();

        Set<String> set = new HashSet<>();
        for (List<String> l : list) {
            Collections.sort(l);
            StringBuilder sb = new StringBuilder();
            for (String s : l) sb.append(s).append("-");
            set.add(sb.substring(0, sb.length() - 1));
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(filter);
        for (String f : filter) sb.append(f).append("-");
        String key = sb.substring(0, sb.length() - 1);

        for (String s : set) {
            if (s.contains(key)) {
                String[] split = s.split("-");
                for (String sp : split) {
                    if (!filter.contains(sp)) res.add(sp);
                }
            }
        }


//        for (List<String> l : list) {
//            boolean includes = true;
//            for (String f : filter) {
//                if (!l.contains(f)) includes = false;
//            }
//            if (includes) {
//                for (String s : l) {
//                    if (!filter.contains(s)) {
//                        res.add(s);
//                    }
//                }
//            }
//        }
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        List<String> l1 = new ArrayList<>() {
            {
                add("apple"); add("facebook"); add("google");
            }
        };
        List<String> l2 = new ArrayList<>() {
            {
                add("banana"); add("facebook");
            }
        };
        List<String> l3 = new ArrayList<>() {
            {
                add("facebook"); add("google"); add("tesla");
            }
        };
        List<String> l4 = new ArrayList<>() {
            {
                add("intuit"); add("google"); add("facebook");
            }
        };
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);

        List<String> filter1 = new ArrayList<>(){
            {
                add("apple");
            }
        };
        List<String> filter2 = new ArrayList<>(){
            {
                add("facebook"); add("google");
            }
        };
        System.out.println(filter(list, filter1));
        System.out.println(filter(list, filter2));
    }
}
