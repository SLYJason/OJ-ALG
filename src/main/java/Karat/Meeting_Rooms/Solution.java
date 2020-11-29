package Karat.Meeting_Rooms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    private static List<int[]> findAvailableTimes(List<int[][]> meetings) {
        List<int[]> all_meetings = new ArrayList<>();
        for(int[][] meeting : meetings) {
            for(int[] m : meeting) {
                all_meetings.add(m);
            }
        }
        Collections.sort(all_meetings, (a, b) -> a[0] - b[0]);
        // merge intervals.
        List<int[]> merged = new ArrayList<>();
        merged.add(all_meetings.get(0));
        for(int i=1; i<all_meetings.size(); i++) {
            int[] prev = all_meetings.get(i-1);
            int[] cur = all_meetings.get(i);
            if(cur[0] <= prev[1]) {
                prev[1] = Math.max(cur[1], prev[1]);
            } else {
                merged.add(cur);
            }
        }
        // find available time slots.
        List<int[]> available = new ArrayList<>();
        if(merged.get(0)[0] != 0) available.add(new int[]{0, merged.get(0)[0]}); // add the beginning 0
        for(int i=1; i<merged.size(); i++) {
            int[] m1 = merged.get(i-1);
            int[] m2 = merged.get(i);
            if(m1[1] == m2[0]) continue;
            int[] available_meeting = new int[]{m1[1], m2[0]};
            available.add(available_meeting);
        }
        if(merged.get(merged.size()-1)[1] != 2400) available.add(new int[]{merged.get(merged.size()-1)[1], 2400}); // add the last 2400
        return available;
    }

    public static void main(String[] args) {
        int[][] p1_meetings = {
                {1230, 1300},
                {845, 900},
                {1300, 1500}
        };
        int[][] p2_meetings = {
                {0, 844},
                {930, 1200},
                {1515, 1546},
                {1600, 2400}
        };
        int[][] p3_meetings = {
                {845, 915},
                {1515, 1545},
                {1235, 1245}
        };

        List<int[][]> schedules1 = Arrays.asList(p1_meetings, p2_meetings, p3_meetings);
        List<int[][]> schedules2 = Arrays.asList(p1_meetings, p3_meetings);
        System.out.println("test case 1:");
        print(findAvailableTimes(schedules1));
        System.out.println("test case 2:");
        print(findAvailableTimes(schedules2));
    }

    private static void print(List<int[]> schedules) {
        for(int[] schedule : schedules) {
            System.out.println("[" + schedule[0] + ", " + schedule[1] + "]");
        }
    }
}
