package HubSpot.OnSite.Q2;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static List<int[]> getTargetSumPair(List<Integer> list, int target) {
        if (list == null || list.size() < 2) return null;

        List<int[]> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(); // key: num, value: index.
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }

        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (map.containsKey(target - num)) {
                result.add(new int[]{num, list.get(map.get(target - num))});
                map.remove(target - num);
                map.remove(num);
            }
        }
        return result;
    }

    private static void print(List<int[]> list) {
        for (int[] arr : list) {
            System.out.print("[" + arr[0] + ", " + arr[1] + "]" + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // test case 1.
        List<Integer> list1 = new ArrayList<>(){
            {
                add(1); add(2); add(3); add(4); add(5); add(6);
            }
        };
        print(getTargetSumPair(list1, 7));
        // test case 2.
        List<Integer> list2 = new ArrayList<>(){
            {
                add(-4); add(5); add(3); add(-2); add(0); add(1); add(-2); add(3); add(4); add(-3); add(5);
            }
        };
        print(getTargetSumPair(list2, 1));
    }
}
