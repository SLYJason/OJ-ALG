package LeetCode;


public class LeetCode13 {
    public int romanToInt(String s) {
        int sum = 0;
        char[] romanArray = s.toUpperCase().toCharArray();
        for(int i=0; i<romanArray.length-1; i++) {
            int cur = getValueFromSymbol(romanArray[i]);
            int next = getValueFromSymbol(romanArray[i+1]);
            if(cur<next) {
                sum -= cur;
            }
            else {
                sum += cur;
            }
        }
        sum += getValueFromSymbol(romanArray[romanArray.length-1]);
        return sum;
    }

    private int getValueFromSymbol(char symbol) {
        switch(symbol) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
