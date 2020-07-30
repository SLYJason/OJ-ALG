package LeetCode.Greedy;

import java.util.Arrays;

public class LeetCode621 {
    public int leastInterval(char[] tasks, int n) {
        if(n == 0) return tasks.length;
        int[] frequencies = new int[26];
        for(char ch : tasks) {
            frequencies[ch - 'A']++;
        }
        Arrays.sort(frequencies);
        int max_frequency = frequencies[25];
        int idel_time = (max_frequency-1)*n;
        for(int i=24; i>=0; i--) {
            // frequencies[i] maybe equal to the max_frequency, in this case, need to use max_frequency-1 to occupy the idle slots
            idel_time -= Math.min(frequencies[i], max_frequency-1);
        }
        // idle slots maybe negative, i.e. occupy all the idle slots
        idel_time = Math.max(0, idel_time);
        return tasks.length + idel_time;
    }
}
