package LeetCode.LC_1_200.LC13;

public class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        char[] romanArray = s.toUpperCase().toCharArray();
        for(int i=0; i<romanArray.length-1; i++) {
            int cur = getNum(romanArray[i]);
            int next = getNum(romanArray[i+1]);
            if(cur<next) {
                sum -= cur;
            }
            else {
                sum += cur;
            }
        }
        sum += getNum(romanArray[romanArray.length-1]);
        return sum;
    }

    private int getNum(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
