package HubSpot.OnSite.Q3;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> topK (List<Integer> list1, List<Integer> list2, int V) {
        if (list1 == null && list2 == null) return null;
        if (list1 != null && list2 == null) return list1.subList(0, V);
        if (list1 == null && list2 != null) return list2.subList(0, V);

        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                list.add(list1.get(i++));
            } else {
                list.add(list2.get(j++));
            }
        }
        while (i < list1.size()) list.add(list1.get(i++));
        while (j < list2.size()) list.add(list2.get(j++));
        return list.subList(0, V);
    }
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(){
            {
                add(1); add(3); add(5);
            }
        };
        List<Integer> list2 = new ArrayList<>(){
            {
                add(2); add(4); add(6);
            }
        };
        System.out.println(topK(list1, list2, 3));
        System.out.println(topK(list1, null, 3));
        System.out.println(topK(null, list2, 3));
        System.out.println(topK(null, null, 3));
    }
}
