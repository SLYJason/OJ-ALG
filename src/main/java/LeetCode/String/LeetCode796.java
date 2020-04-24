package LeetCode.String;

public class LeetCode796 {
    // Solution 1: initial thoughts, brute force
    public boolean rotateString1(String A, String B) {
        if(A == null || B == null || A.length() != B.length()) return false;
        if(A.equals(B)) return true;
        for(int i=0; i<A.length()-1; i++) {
            A = A.substring(1) + A.substring(0, 1);;
            if(A.equals(B)) return true;
        }
        return false;
    }

    // Solution 2
    public boolean rotateString2(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
}

