package LeetCode.LC_1_200.LC12;

/**
 * Solution 1: brute force.
 */
public class Solution_1 {
    public String intToRoman(int num) {
        if(num == 0) return "";
        StringBuilder sb = new StringBuilder();
        while(num != 0) {
            if(num >= 1 && num <= 5) {
                if(num == 1) {
                    sb.append("I");
                } else if(num == 2){
                    sb.append("II");
                } else if(num == 3){
                    sb.append("III");
                } else if(num == 4){
                    sb.append("IV");
                } else if(num == 5){
                    sb.append("V");
                }
                num = 0;
            } else if(num > 5 && num < 10) {
                if(num == 9) {
                    sb.append("IX");
                    num -= 9;
                } else {
                    sb.append("V");
                    num -= 5;
                }
            } else if(num >= 10 && num < 50) {
                if(num >= 40) {
                    sb.append("XL");
                    num -= 40;
                } else {
                    sb.append("X");
                    num -= 10;
                }
            } else if(num >= 50 && num < 100) {
                if(num >= 90) {
                    sb.append("XC");
                    num -= 90;
                } else {
                    sb.append("L");
                    num -= 50;
                }
            } else if(num >= 100 && num < 500) {
                if(num >= 400) {
                    sb.append("CD");
                    num -= 400;
                } else {
                    sb.append("C");
                    num -= 100;
                }
            } else if(num >= 500 && num < 1000) {
                if(num >= 900) {
                    sb.append("CM");
                    num -= 900;
                } else {
                    sb.append("D");
                    num -= 500;
                }
            } else {
                sb.append("M");
                num -= 1000;
            }
        }
        return sb.toString();
    }
}
