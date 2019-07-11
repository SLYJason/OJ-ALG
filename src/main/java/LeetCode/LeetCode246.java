package LeetCode;

public class LeetCode246 {
    public boolean isStrobogrammatic(String num) {
        for(int i=0, j=num.length()-1; i<=j; i++, j--) {
            if (!"00 11 96 69 88".contains(num.charAt(i) + "" + num.charAt(j))) return false;
        }
        return true;
    }
}
