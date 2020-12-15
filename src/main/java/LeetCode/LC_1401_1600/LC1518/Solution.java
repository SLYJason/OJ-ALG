package LeetCode.LC_1401_1600.LC1518;

public class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drink = 0, empty = 0;
        while(numBottles > 0) {
            drink += numBottles;
            empty += numBottles;
            numBottles = empty / numExchange;
            empty = empty % numExchange;
        }
        return drink;
    }
}
