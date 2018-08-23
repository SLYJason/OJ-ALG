package LeetCode;

public class LeetCode852 {
    public int peakIndexInMountainArray(int[] A) {
        int i = 0;
        int j = A.length-1;
        while(i<j) {
            int mid = (i+j)/2;
            if(A[mid] < A[mid+1]) {
                i = mid + 1;
            }
            else {
                j = mid;
            }
        }
        return i;
    }
}
