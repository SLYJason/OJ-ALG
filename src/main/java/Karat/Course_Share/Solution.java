package Karat.Course_Share;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Solution {
    public Map<List<Integer>, Set<String>> find_pairs(String[][] student_course_pairs) {
        Map<Integer, Set<String>> map = new HashMap<>();
        List<Integer> students = new ArrayList<>();
        for(String[] pair : student_course_pairs) {
            int id = Integer.parseInt(pair[0]);
            String course = pair[1];
            if(!map.containsKey(id)) map.put(id, new HashSet<>());
            map.get(id).add(course);
            if(!students.contains(id)) students.add(id);
        }

        Map<List<Integer>, Set<String>> res = new HashMap<>();
        for(int i=0; i<students.size()-1; i++) {
            for(int j=i+1; j<students.size(); j++) {
                int s1 = students.get(i), s2 = students.get(j);
                List<Integer> pair = Arrays.asList(s1, s2);
                Set<String> c1 = map.get(s1), c2 = map.get(s2);
                Set<String> shared = new HashSet<>();
                for(String course : c1) {
                    if(c2.contains(course)) shared.add(course);
                }
                res.put(pair, shared);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        String[][] student_course_pairs_1 = {
                {"58", "Linear Algebra"},
                {"94", "Art History"},
                {"94", "Operating Systems"},
                {"17", "Software Design"},
                {"58", "Mechanics"},
                {"58", "Economics"},
                {"17", "Linear Algebra"},
                {"17", "Political Science"},
                {"94", "Economics"},
                {"25", "Economics"},
                {"58", "Software Design"},
        };
        String[][] student_course_pairs_2 = {
                {"42", "Software Design"},
                {"0", "Advanced Mechanics"},
                {"9", "Art History"},
        };
        System.out.println(s.find_pairs(student_course_pairs_1));
        System.out.println(s.find_pairs(student_course_pairs_2));
    }
}
