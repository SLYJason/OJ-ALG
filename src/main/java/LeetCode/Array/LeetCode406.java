package LeetCode.Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;

public class LeetCode406 {
    public int[][] reconstructQueue(int[][] people) {
        // Sort people: 1.in the descending order by h 2.in the ascending order by k
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        List<int[]> list = new LinkedList();
        for(int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[people.length][2]);
    }
}
