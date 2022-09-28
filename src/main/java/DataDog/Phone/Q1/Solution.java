package DataDog.Phone.Q1;

import java.util.Arrays;

public class Solution {
    public static int[] bucket(int[] integers, int bucket, int width) {
        Arrays.sort(integers);
        int[] buckets = new int[bucket];
        for (int integer : integers) {
            int num = integer / width >= bucket ? bucket - 1 : integer / width;
            buckets[num]++;
        }
        return buckets;
    }

    public static void main(String[] args) {
        int[] integers1 = {1, 2, 11, 20, 100};
        System.out.print("case 1: ");
        for (int n : bucket(integers1, 3, 10)) {
            System.out.print(n + " ");
        }
        System.out.print("\ncase 2: ");
        int[] integers2 = {1, 2, 8, 9, 11, 14, 19, 20, 100};
        for (int n : bucket(integers2, 4, 5)) {
            System.out.print(n + " ");
        }
    }
}
