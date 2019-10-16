package LeetCode;

public class LeetCode896 {
    public boolean isMonotonic(int[] A) {
        boolean isMonoInc = A[0] <= A[A.length-1];
        for(int i=0; i<A.length-1; i++) {
            if (isMonoInc && A[i] <= A[i+1]) {
                continue;
            } else if (!isMonoInc && A[i] >= A[i+1]) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}