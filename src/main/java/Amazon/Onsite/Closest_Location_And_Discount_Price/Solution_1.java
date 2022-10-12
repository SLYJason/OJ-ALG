package Amazon.Onsite.Closest_Location_And_Discount_Price;

import java.util.Arrays;

public class Solution_1 {
    public static int[][] kClosest(int[][] points, int[] customer, int K) {
        // Distance to the customer:
        // (p[0] - c[0]) ^ 2 - (p[1] - c[1]) ^ 2 = p[0] ^ 2 - 2 * p[0] * c[0] + c[0] ^ 2 - p[1] ^ 2 + 2 * p[1] * c[1] - c[1] ^ 2.
        Arrays.sort(points, (p1, p2) -> {
            int diff = p1[0] * p1[0] - 2 * p1[0] * customer[0] + customer[0] * customer[0] - p1[1] * p1[1] + 2 * p1[1] * customer[1] - customer[1] * customer[1] -
                    (p2[0] * p2[0] - 2 * p2[0] * customer[0] + customer[0] * customer[0] - p2[1] * p2[1] + 2 * p2[1] * customer[1] - customer[1] * customer[1]);
            return diff == 0 ? p1[0] + p1[1] - p2[0] - p2[1] : diff;
        });
        return Arrays.copyOf(points, K);
    }

    public static void main(String[] args) {
        int[][] points = {{1, 0}, {2, 0}, {3, 0}, {4, 0}, {5, 0}};
        int[] customer = {4, 0};
        int k = 3;
        for (int[] point: kClosest(points, customer, k)) {
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }
    }
}
