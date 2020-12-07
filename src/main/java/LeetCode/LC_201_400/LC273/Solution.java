package LeetCode.LC_201_400.LC273;

/**
 * Solution: recursion.
 */
public class Solution {
    String[] less_than_10 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] less_than_20 = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] less_than_100 = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        return helper(num);
    }

    private String helper(int num) {
        String res = "";
        if(num < 10) {
            res = less_than_10[num];
        } else if(num < 20) {
            res = less_than_20[num-10];
        } else if(num < 100) {
            res = less_than_100[num / 10] + " " + helper(num % 10);
        } else if(num < 1000) {
            res = helper(num / 100) + " Hundred " + helper(num % 100);
        } else if(num < 1000000) {
            res = helper(num / 1000) + " Thousand " + helper(num % 1000);
        } else if(num < 1000000000) {
            res = helper(num / 1000000) + " Million " + helper(num % 1000000);
        } else {
            res = helper(num / 1000000000) + " Billion " + helper(num % 1000000000);
        }
        return res.trim();
    }
}
